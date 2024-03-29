package fegui;

import fegui.event.listener.EventHandler;
import fegui.event.listener.Listener;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

public abstract class ListenerHandler {
    private final HashMap<String, Listener> listeners = new HashMap<>();

    public void addListener(Listener listener) {
        addListener(listener, UUID.randomUUID().toString().substring(0, 8));
    }

    public void addListener(Listener listener, String name) {
        listeners.put(name, listener);
    }

    public void removeListener(String name) {
        listeners.remove(name);
    }

    public void clearListeners() {
        listeners.clear();
    }

    public void postEvent(Event event) {
        listeners.values().forEach(listener ->
                Arrays.stream(listener.getClass().getDeclaredMethods())
                        .filter(method -> method.getAnnotation(EventHandler.class) != null)
                        .filter(method -> method.getParameterTypes()[0].getName().equals(event.getClass().getName()))
                        .forEach(method -> {
                            try {
                                method.invoke(event);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }));
    }
}
