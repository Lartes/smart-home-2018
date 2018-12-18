package ru.sbt.mipt.oop;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class HallDoorEventProcessorTest {
    private HallDoorEventProcessor hallDoorEventProcessor = new HallDoorEventProcessor();
    private SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();
    private SmartHome smartHome;

    @Test
    public void test() throws IOException {
        SensorEvent sensorEvent = new SensorEvent(SensorEventType.DOOR_CLOSED, "1");

        smartHome = smartHomeLoader.loadSmartHome();
        hallDoorEventProcessor.processEvent(smartHome, sensorEvent);
        checkLights();
    }

    private void checkLights() {
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                assertEquals(false, light.isOn());
            }
        }
    }
}
