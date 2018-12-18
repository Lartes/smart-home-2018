package ru.sbt.mipt.oop;

import java.util.Collection;

public class Room implements Executor {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room(Collection<Door> doors, String name) {
        this.doors = doors;
        this.name = name;
    }

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    @Override
    public void executeAction(Action action) {
        if (doors != null) {
            for (Door door : doors) {
                door.executeAction(action);
            }
        }
        if (lights != null) {
            for (Light light : lights) {
                light.executeAction(action);
            }
        }
    }
}
