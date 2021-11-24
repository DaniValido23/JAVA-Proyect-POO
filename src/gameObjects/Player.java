package gameObjects;

import Input.KeyBoards;
import math.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject{

    public Player(Vector2D position, BufferedImage texture){
        super(position, texture);
    }

    @Override
    public void update() {
        if(KeyBoards.RIGHT)
            position.setX(position.getX()+2);
        if(KeyBoards.LEFT)
            position.setX(position.getX()-2);
        if(KeyBoards.UP)
            position.setY(position.getY()-2);
        if(KeyBoards.DOWN)
            position.setY(position.getY()+2);

    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(texture, (int) position.getX(), (int) position.getY(), null);
    }
}
