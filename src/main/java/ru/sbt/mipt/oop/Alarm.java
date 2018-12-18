package ru.sbt.mipt.oop;

public class Alarm {
    private AlarmState state;
    private final String alarmPassword;

    public Alarm(String password) {
        this.alarmPassword = password;
        state = new AlarmStateDeactivate(this);
    }

    public void setState(AlarmState state) {
        this.state = state;
    }

    public AlarmStateEnum getState() {
        return state.getState();
    }

    public void switchOn(){
        state.switchOn();
    }

    public void switchOff() {
        state.switchOff();
    }

    public void enterPassword(String password) {
        state.enterPassword(password);
    }

    boolean checkPassword (String password) {
        return password.equals(alarmPassword);
    }

    public void onSensorEvent(SensorEvent sensorEvent) {
        state.onSensorEvent(sensorEvent);
    }

    public void startAlarm() {
        state.startAlarm();
    }
}