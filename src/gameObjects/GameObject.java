package gameObjects;

import math.Vector2D;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class GameObject {
    protected BufferedImage texture;
    protected Vector2D position;
    private double at;

    public GameObject(Vector2D position, BufferedImage texture){
        this.position = position;
        this.texture = texture;
    }

    public GameObject(Vector2D position, int texture) {
    }

    public abstract void update();

    public abstract void update2();

    public abstract void draw(Graphics graphics);

    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }
}
