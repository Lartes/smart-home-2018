package ru.sbt.mipt.oop;

public class AlarmStateRing implements AlarmState{
    private final Alarm alarm;

    public AlarmStateRing(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public AlarmStateEnum getState() {
        return AlarmStateEnum.RING;
    }

    @Override
    public void switchOn() {

    }

    @Override
    public void switchOff() {
        alarm.setState(new AlarmStateDeactivate(alarm));
    }

    @Override
    public void enterPassword(String password) {

    }

    @Override
    public void startAlarm() {

    }

    @Override
    public void onSensorEvent(SensorEvent event) {

    }
}
