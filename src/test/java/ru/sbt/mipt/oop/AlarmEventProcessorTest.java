package ru.sbt.mipt.oop;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class AlarmEventProcessorTest {
    private AlarmEventProcessor alarmEventProcessor = new AlarmEventProcessor();
    private SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();
    private SmartHome smartHome;

    @Test
    public void testAlarmOFF() throws IOException {
        SensorEvent sensorEvent = new SensorEvent(SensorEventType.ALARM_DEACTIVATE, "1");

        smartHome = smartHomeLoader.loadSmartHome();
        Alarm alarm = new Alarm("12345");
        alarm.setState(new AlarmStateRing(alarm));
        smartHome.setAlarm(alarm);

        assertTrue(smartHome.getAlarm().getState() == AlarmStateEnum.RING);
        alarmEventProcessor.processEvent(smartHome, sensorEvent);
        assertTrue(smartHome.getAlarm().getState() == AlarmStateEnum.OFF);
    }

    @Test
    public void testAlarmON() throws IOException {
        SensorEvent sensorEvent = new SensorEvent(SensorEventType.ALARM_ACTIVATE, "1");

        smartHome = smartHomeLoader.loadSmartHome();
        assertTrue(smartHome.getAlarm().getState() == AlarmStateEnum.OFF);
        alarmEventProcessor.processEvent(smartHome, sensorEvent);
        assertTrue(smartHome.getAlarm().getState() == AlarmStateEnum.ON);
    }
}
