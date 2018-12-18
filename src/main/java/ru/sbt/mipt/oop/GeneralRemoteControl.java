package ru.sbt.mipt.oop;

import java.util.HashMap;
import java.util.Map;

public class GeneralRemoteControl implements RemoteControl {
    private final Map<String, RemoteControlCommand> commandsMap = new HashMap<>();

    @Override
    public void onButtonPressed(String buttonCode) {
        RemoteControlCommand command = commandsMap.get(buttonCode);
        command.executeCommand();
    }

    public void setupCommand(String buttonCode, RemoteControlCommand command) {
        commandsMap.put(buttonCode, command);
    }
}
