package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventProcessor implements EventProcessor {
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!isDoorEvent(event)) return;
        smartHome.executeAction(object -> {
            if (object instanceof Door) {
                Door door = (Door) object;
                if (door.getId().equals(event.getObjectId())) {
                    if (event.getType() == DOOR_OPEN) {
                        changeDoorState(door, true);
                    } else {
                        changeDoorState(door, false);
                    }
                }
            }
        });
    }

    private void changeDoorState(Door door, boolean opened) {
        door.setOpen(opened);
        System.out.println("Door " + door.getId() + (opened ? " opened" : " closed"));
    }

    private boolean isDoorEvent(SensorEvent event) {
        return event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED;
    }

}
