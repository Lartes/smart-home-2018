package ru.sbt.mipt.oop;

public class AlarmPassword implements AlarmState{
    private final Alarm alarm;

    public AlarmPassword(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public AlarmStateEnum getState() {
        return AlarmStateEnum.WAIT_FOR_PASSWORD;
    }

    @Override
    public void switchOn() {

    }

    @Override
    public void switchOff() {

    }

    @Override
    public void enterPassword(String password) {
        if(alarm.checkPassword(password)) {
            alarm.setState(new AlarmDeactivate(alarm));
        }
        else {
            alarm.setState(new AlarmRing(alarm));
        }
    }

    @Override
    public void startAlarm() {

    }

    @Override
    public void onSensorEvent(SensorEvent event) {

    }
}
