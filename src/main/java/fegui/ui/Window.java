package fegui.ui;

import fegui.Component;
import fegui.ListenerHandler;
import fegui.util.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class Window extends ListenerHandler {
    private final List<Component> components = new ArrayList<>();
    private final Window parent;
    private Position position = new Position(0, 0);

    public Window() {
        this.parent = null;
    }

    public Window(Window parent) {
        this.parent = parent;
    }

    public void show() {

    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        position = new Position(x, y);
    }
}
