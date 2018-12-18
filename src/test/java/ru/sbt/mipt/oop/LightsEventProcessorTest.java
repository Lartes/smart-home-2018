package ru.sbt.mipt.oop;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class LightsEventProcessorTest {
    private LightsEventProcessor lightsEventProcessor = new LightsEventProcessor();
    private SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();
    private SmartHome smartHome;

    @Test
    public void testLightsOFF() throws IOException {
        SensorEvent sensorEvent = new SensorEvent(SensorEventType.LIGHT_OFF, "2");

        smartHome = smartHomeLoader.loadSmartHome();
        checkLights("2", true);
        lightsEventProcessor.processEvent(smartHome, sensorEvent);
        checkLights("2", false);
    }

    @Test
    public void testLightsON() throws IOException {
        SensorEvent sensorEvent = new SensorEvent(SensorEventType.LIGHT_ON, "1");

        smartHome = smartHomeLoader.loadSmartHome();
        checkLights("1", false);
        lightsEventProcessor.processEvent(smartHome, sensorEvent);
        checkLights("1", true);
    }

    private void checkLights(String lightId, boolean isOn) {
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(lightId)) {
                    assertEquals(light.isOn(), isOn);
                }
            }
        }
    }
}
