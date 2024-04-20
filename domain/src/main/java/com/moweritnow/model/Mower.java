package com.moweritnow.model;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Mower implements IDevice,IEventListener {
    private static int ID;
    private State state;
    private List<OrderEnum> orders;
    private EventManager eventManager;

    @Override
    public void executeOrder(OrderEnum order) {
        switch (order) {
            case A -> moveForward();
            case D -> turnRight();
            case G -> turnLeft();
        }
    }

    @Override
    public void executeOrders() {
        for (OrderEnum order : orders) {
            if (state.isValidState(order)) {
                executeOrder(order);
            } else {
                log.warn("Order {} is not valid for {}, skipping !", order, state);
            }
        }
        update(EventType.FINISHED,ID+1);
    }

    private void turnLeft() {
        switch (state.getOrientation()) {
            case N -> state.setOrientation(OrientationEnum.W);
            case E -> state.setOrientation(OrientationEnum.N);
            case S -> state.setOrientation(OrientationEnum.E);
            case W -> state.setOrientation(OrientationEnum.S);
        }
    }

    private void turnRight() {
        switch (state.getOrientation()) {
            case N -> state.setOrientation(OrientationEnum.E);
            case E -> state.setOrientation(OrientationEnum.S);
            case S -> state.setOrientation(OrientationEnum.W);
            case W -> state.setOrientation(OrientationEnum.N);
        }
    }

    public void moveForward() {
        switch (state.getOrientation()) {
            case N -> state.getPosition().moveToNorth();
            case E -> state.getPosition().moveToEast();
            case W -> state.getPosition().moveToWest();
            case S -> state.getPosition().moveToSouth();
        }
    }

    @Override
    public void update(EventType eventType, int id) {
        eventManager.notify(EventType.FINISHED,id);
    }

    @Override
    public void manageUpdate(EventType eventType, int id) {
        if(EventType.FINISHED.equals(eventType) && (id==ID)){
            executeOrders();
        }
    }

    @Override
    public int getID() {
        return ID;
    }
}
