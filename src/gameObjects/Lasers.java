package gameObjects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import math.Vector2D;
import java.awt.image.BufferedImage;

public class Lasers extends MovingObjects{

    public Lasers(Vector2D position, Vector2D velocity, double maxvel,double angle, BufferedImage texture) {
        super(position, velocity, maxvel, texture);
        this.velocity = velocity.scale(maxvel);
        this.angle=angle;
    }

    @Override
    public void update() {
        position=position.add(velocity);
    }

    public void draw(Graphics g){
        Graphics2D g2=(Graphics2D)g;
        at = AffineTransform.getTranslateInstance(position.getX()-texture.getWidth()/2, position.getY());
        at.rotate(angle,texture.getWidth()/2,0);
         g2.drawImage(texture,at,null);
    }
}