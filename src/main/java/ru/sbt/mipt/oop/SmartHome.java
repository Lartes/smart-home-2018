package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Executor {
    Collection<Room> rooms;
    private Alarm alarm;

    public SmartHome() {
        alarm = new Alarm("12345");
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public void setRooms(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public Alarm getAlarm() {
        return alarm;
    }

    public void setAlarm(Alarm alarm) {
        this.alarm = alarm;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void switchOffLights() {
        changeLightsState(false);
    }

    public void switchOnLights() {
        changeLightsState(true);
    }

    private void changeLightsState(boolean isNewStateOn) {
        executeAction(object -> {
            if (object instanceof Light) {
                Light light = (Light) object;
                light.setOn(isNewStateOn);
                SensorCommand command;
                if (isNewStateOn) {
                    command = new SensorCommand(SensorCommandType.LIGHT_ON, light.getId());
                }
                else {
                    command = new SensorCommand(SensorCommandType.LIGHT_OFF, light.getId());
                }
                SensorCommandExecutor.executeCommand(command);
            }
        });
    }

    @Override
    public void executeAction(Action action) {
        for (Room room : rooms) {
            room.executeAction(action);
        }
    }
}
