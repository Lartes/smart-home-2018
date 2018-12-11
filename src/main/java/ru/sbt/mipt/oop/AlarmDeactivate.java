package ru.sbt.mipt.oop;

public class AlarmDeactivate implements AlarmState {
    private final Alarm alarm;

    public AlarmDeactivate(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public AlarmStateEnum getState() {
        return AlarmStateEnum.OFF;
    }

    @Override
    public void switchOn() {
        alarm.setState(new AlarmActivate(alarm));
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
