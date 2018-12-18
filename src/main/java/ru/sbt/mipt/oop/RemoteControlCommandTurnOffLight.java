package ru.sbt.mipt.oop;

public class RemoteControlCommandTurnOffLight implements RemoteControlCommand {
    private final SmartHome smartHome;

    public RemoteControlCommandTurnOffLight(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void executeCommand() {
        smartHome.switchOffLights();
    }
}
