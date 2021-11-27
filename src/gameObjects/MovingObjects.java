package gameObjects;

import math.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public abstract class MovingObjects extends GameObject{
    protected  Vector2D velocity;
    protected AffineTransform at;
    protected AffineTransform at2;
    protected double angle;
    protected double maxvel;
    public MovingObjects(Vector2D position,Vector2D velocity,double maxvel, BufferedImage texture) {
        super(position, texture);
        this.velocity =velocity;
        this.maxvel=maxvel;
        angle=0;
    }

    @Override
    public void update() {

    }

    @Override
    public void update2() {

    }

    @Override
    public void draw(Graphics graphics) {

    }
}
