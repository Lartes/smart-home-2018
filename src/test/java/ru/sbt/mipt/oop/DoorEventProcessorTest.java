package ru.sbt.mipt.oop;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class DoorEventProcessorTest {
    private DoorEventProcessor doorsEventProcessor = new DoorEventProcessor();
    private SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();
    private SmartHome smartHome;

    @Test
    public void testDoorOpen() throws IOException {
        SensorEvent sensorEvent = new SensorEvent(SensorEventType.DOOR_OPEN, "1");

        smartHome = smartHomeLoader.loadSmartHome();
        checkDoor("1", false);
        doorsEventProcessor.processEvent(smartHome, sensorEvent);
        checkDoor("1", true);
    }

    @Test
    public void testDoorClose() throws IOException {
        SensorEvent sensorEvent = new SensorEvent(SensorEventType.DOOR_CLOSED, "3");

        smartHome = smartHomeLoader.loadSmartHome();
        checkDoor("3", true);
        doorsEventProcessor.processEvent(smartHome, sensorEvent);
        checkDoor("3", false);
    }

    private void checkDoor(String doorId, boolean isOpen) {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(doorId)) {
                    assertEquals(door.isOpen(), isOpen);
                }
            }
        }
    }
}
