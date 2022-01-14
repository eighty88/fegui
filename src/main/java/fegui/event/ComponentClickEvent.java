package fegui.event;

import fegui.Component;
import fegui.Event;
import fegui.event.listener.Handler;

public class ComponentClickEvent implements Event {
    private final Component component;
    private final ComponentClickHandler handler;

    public <T extends Component> ComponentClickEvent(T component) {
        this.handler = new ComponentClickHandler();
        this.component = component;
    }

    @Override
    public Handler getHandler() {
        return handler;
    }

    public Component getComponent() {
        return component;
    }

    public static class ComponentClickHandler implements Handler {}
}