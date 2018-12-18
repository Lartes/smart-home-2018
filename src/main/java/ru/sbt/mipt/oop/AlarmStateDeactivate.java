package ru.sbt.mipt.oop;

public class AlarmStateDeactivate implements AlarmState {
    private final Alarm alarm;

    public AlarmStateDeactivate(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public AlarmStateEnum getState() {
        return AlarmStateEnum.OFF;
    }

    @Override
    public void switchOn() {
        alarm.setState(new AlarmStateActivate(alarm));
    }

    @Override
    public void switchOff() {}

    @Override
    public void enterPassword(String password) {}

    @Override
    public void startAlarm() {}

    @Override
    public void onSensorEvent(SensorEvent event) {}
}
