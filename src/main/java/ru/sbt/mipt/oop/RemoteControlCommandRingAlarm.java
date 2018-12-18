package ru.sbt.mipt.oop;

public class RemoteControlCommandRingAlarm implements RemoteControlCommand {
    private final SmartHome smartHome;

    public RemoteControlCommandRingAlarm(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void executeCommand() {
        smartHome.getAlarm().switchOn();
        smartHome.getAlarm().startAlarm();
    }
}
