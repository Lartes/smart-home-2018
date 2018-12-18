package ru.sbt.mipt.oop;

public class RemoteControlCommandTurnOnLight implements RemoteControlCommand {
    private final SmartHome smartHome;

    public RemoteControlCommandTurnOnLight(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void executeCommand() {
        smartHome.switchOnLights();
    }
}
