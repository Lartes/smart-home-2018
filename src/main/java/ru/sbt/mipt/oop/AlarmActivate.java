package ru.sbt.mipt.oop;

public class AlarmActivate implements AlarmState {
    private final Alarm alarm;

    public AlarmActivate(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public AlarmStateEnum getState() {
        return AlarmStateEnum.ON;
    }

    @Override
    public void switchOn() {}

    @Override
    public void switchOff() {}

    @Override
    public void onSensorEvent(SensorEvent event) {
        alarm.setState(new AlarmPassword(alarm));
    }

    @Override
    public void enterPassword(String password) {}

    @Override
    public void startAlarm() {
    }
}
