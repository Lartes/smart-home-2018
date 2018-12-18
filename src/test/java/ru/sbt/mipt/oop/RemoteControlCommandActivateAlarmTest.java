package ru.sbt.mipt.oop;

import org.junit.Test;
import static org.junit.Assert.*;

public class RemoteControlCommandActivateAlarmTest {
    private GeneralRemoteControl smartHomeRemoteControl = new GeneralRemoteControl();
    private SmartHome smartHome = new SmartHome();

    @Test
    public void test() {
        smartHomeRemoteControl.setupCommand("A", new RemoteControlCommandActivateAlarm(smartHome));

        assertTrue(smartHome.getAlarm().getState() == AlarmStateEnum.OFF);
        smartHomeRemoteControl.onButtonPressed("A");
        assertTrue(smartHome.getAlarm().getState() == AlarmStateEnum.ON);
    }
}
