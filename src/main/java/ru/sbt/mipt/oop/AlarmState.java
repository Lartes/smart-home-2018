package ru.sbt.mipt.oop;

public interface AlarmState {
    AlarmStateEnum getState();
    void switchOn();
    void switchOff();
    void enterPassword(String password);
    void startAlarm();
    void onSensorEvent(SensorEvent event);}
