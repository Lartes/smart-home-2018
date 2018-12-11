package ru.sbt.mipt.oop;

public class AlarmRing implements AlarmState{
    private final Alarm alarm;

    public AlarmRing(Alarm alarm) {
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
        alarm.setState(new AlarmDeactivate(alarm));
    }

    @Override
    public void enterPassword(String password) {

    }

    @Override
    public void startAlarm() {
        alarm.setState(new AlarmRing(alarm));
        System.out.println("Alarm ring");
    }

    @Override
    public void onSensorEvent(SensorEvent event) {

    }
}
