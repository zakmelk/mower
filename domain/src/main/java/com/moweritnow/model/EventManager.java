package com.moweritnow.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    Map<EventType, List<IEventListener>> listeners = new HashMap<>();

    public EventManager(EventType... operations) {
        for (EventType operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(EventType eventType, IEventListener listener) {
        List<IEventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(EventType eventType, IEventListener listener) {
        List<IEventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(EventType eventType, int id) {
        List<IEventListener> users = listeners.get(eventType);
        users.stream().filter(u -> u.getID() == id).forEach(u -> u.manageUpdate(eventType, id));
    }
}
