package ru.sbt.mipt.oop;

public class RemoteControlCommandActivateAlarm implements RemoteControlCommand {
    private final SmartHome smartHome;

    public RemoteControlCommandActivateAlarm(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void executeCommand() {
        smartHome.getAlarm().switchOn();
    }
}
