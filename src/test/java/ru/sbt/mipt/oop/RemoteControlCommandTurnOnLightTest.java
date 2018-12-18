package ru.sbt.mipt.oop;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RemoteControlCommandTurnOnLightTest {
    private GeneralRemoteControl smartHomeRemoteControl = new GeneralRemoteControl();
    private SmartHome smartHome = new SmartHome();

    @Test
    public void test() {
        Light light1 = new Light("1", false);
        Light light2 = new Light("2", false);

        List<Light> lights = new ArrayList<>();
        lights.add(light1);
        lights.add(light2);
        smartHome.addRoom(new Room(lights, null, "firstRoom"));
        smartHomeRemoteControl.setupCommand("A", new RemoteControlCommandTurnOnLight(smartHome));

        assertFalse(light1.isOn());
        assertFalse(light2.isOn());
        smartHomeRemoteControl.onButtonPressed("A");
        assertTrue(light1.isOn());
        assertTrue(light2.isOn());
    }
}
