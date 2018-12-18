package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

public class HallDoorEventProcessor implements EventProcessor {

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (event.getType() != DOOR_CLOSED) return;
        smartHome.executeAction(object -> {
            if (object instanceof Room) {
                Room room = (Room) object;
                if (room.getName().equals("hall")) {
                    // выполняем дейстие для входной двери
                    room.executeAction(roomObject -> {
                        if (roomObject instanceof Door) {
                            Door door = (Door) roomObject;
                            if (door.getId().equals(event.getObjectId())) {
                                door.setOpen(false);
                                smartHome.switchOffLights();
                            }
                        }
                    });
                }
            }
        });
    }
}
