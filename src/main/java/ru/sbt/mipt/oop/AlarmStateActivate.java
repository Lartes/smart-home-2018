package ru.sbt.mipt.oop;

public class AlarmStateActivate implements AlarmState {
    private final Alarm alarm;

    public AlarmStateActivate(Alarm alarm) {
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
        alarm.setState(new AlarmStatePassword(alarm));
    }

    @Override
    public void enterPassword(String password) {}

    @Override
    public void startAlarm() {
        alarm.setState(new AlarmStateRing(alarm));
        System.out.println("Alarm ring");
    }
}
