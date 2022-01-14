package fegui;

import fegui.util.Position;

public abstract class Component extends ListenerHandler implements ComponentBase {
    private Position position = new Position(0, 0);

    public Component() {
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        position = new Position(x, y);
    }
}