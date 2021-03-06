package ru.sbt.mipt.oop;

public class SensorCommand {
    private final SensorCommandType type;
    private final String objectId;

    public SensorCommand(SensorCommandType type, String objectId) {
        this.type = type;
        this.objectId = objectId;
    }

    @Override
    public String toString() {
        return "SensorCommand{" + "type=" + type + ", objectId='" + objectId + '\'' + '}';
    }
}
