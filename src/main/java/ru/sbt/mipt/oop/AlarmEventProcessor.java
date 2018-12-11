package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.SensorEventType.ALARM_DEACTIVATE;

public class AlarmEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if(!isCorrectEvent(event)) return;
        if(event.getType() == ALARM_ACTIVATE) {
            smartHome.getAlarm().switchOn();
        }
        else {
            smartHome.getAlarm().switchOff();
        }
    }
    private boolean isCorrectEvent(SensorEvent event) {
        return event.getType() == ALARM_ACTIVATE || event.getType() == ALARM_DEACTIVATE;
    }
}