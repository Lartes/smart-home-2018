package ru.sbt.mipt.oop;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RemoteControlCommandTurnOffLightTest {
    private GeneralRemoteControl smartHomeRemoteControl = new GeneralRemoteControl();
    private SmartHome smartHome = new SmartHome();

    @Test
    public void test() {
        Light light1 = new Light("1", true);
        Light light2 = new Light("2", true);

        List<Light> lights = new ArrayList<>();
        lights.add(light1);
        lights.add(light2);
        smartHome.addRoom(new Room(lights, null, "firstRoom"));
        smartHomeRemoteControl.setupCommand("A", new RemoteControlCommandTurnOffLight(smartHome));

        assertTrue(light1.isOn());
        assertTrue(light2.isOn());
        smartHomeRemoteControl.onButtonPressed("A");
        assertFalse(light1.isOn());
        assertFalse(light2.isOn());
    }
}

