package gameObjects;
import Graphics.Assets;
import Input.KeyBoards;
import States.GameState;
import math.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Player extends MovingObjects{
    private Vector2D heading;
    private Vector2D aceleration;
    private final double ACC=0.10;
    private GameState gameState;
    private long time,lastime;
    public Player(Vector2D position, Vector2D velocity, double maxvel, BufferedImage texture, GameState gameState) {
        super(position, velocity,maxvel, texture);
        this.gameState =gameState;
        heading = new Vector2D(0,1);
        aceleration = new Vector2D();
        time=0;
        lastime=System.currentTimeMillis();
    }

    @Override
    public void update() {
        time +=System.currentTimeMillis()-lastime;
        lastime=System.currentTimeMillis();
        if(KeyBoards.RIGHT)
            position.setX(position.getX()+3);
        if(KeyBoards.LEFT)
            position.setX(position.getX()-3);
        if(KeyBoards.UP) {
            position.setY(position.getY() - 3);
            //aceleration = heading.scale(ACC);
        }/*else{
            if(velocity.getMagnituded()!=0)
                aceleration=(velocity.scale(-1).normalize()).scale(ACC);
        }*/
        if(KeyBoards.DOWN) {
            position.setY(position.getY() + 3);
            //aceleration = heading.scale(ACC);
        }

        if(KeyBoards.SHOOT && time>100) {
            gameState.getMovingObjects().add(0,new Lasers(getCenter().add(heading.scale(texture.getHeight())), heading, 5, 0, Assets.laser1

            ));
        time = 0;
        }

        if(position.getX()<=0)
            position.setX(0);

        if(position.getX()>=1200)
            position.setX(1200);

        if(position.getY()>=775)
            position.setY(775);

        if(position.getY()<=0)
            position.setY(0);

        velocity = velocity.add(aceleration);
        velocity.limit(maxvel);
        heading=heading.setDireccion(texture.getHeight()-50.17865432);
        position=position.add(velocity);
    }

    @Override
    public void update2() {
        time +=System.currentTimeMillis()-lastime;
        lastime=System.currentTimeMillis();
        if(KeyBoards.RIGHT)
            position.setX(position.getX()+3);
        if(KeyBoards.LEFT)
            position.setX(position.getX()-3);
        if(KeyBoards.UP) {
            position.setY(position.getY() - 3);
            //aceleration = heading.scale(ACC);
        }/*else{
            if(velocity.getMagnituded()!=0)
                aceleration=(velocity.scale(-1).normalize()).scale(ACC);
        }*/
        if(KeyBoards.DOWN) {
            position.setY(position.getY() + 3);
            //aceleration = heading.scale(ACC);
        }

        if(KeyBoards.SHOOT && time>100) {
            gameState.getMovingObjects().add(0,new Lasers(getCenter().add(heading.scale(texture.getHeight())), heading, 5, 0, Assets.laser1

            ));
            time = 0;
        }

        if(position.getX()<=0)
            position.setX(0);

        if(position.getX()>=1200)
            position.setX(1200);

        if(position.getY()>=775)
            position.setY(775);

        if(position.getY()<=0)
            position.setY(0);

        velocity = velocity.add(aceleration);
        velocity.limit(maxvel);
        heading=heading.setDireccion(texture.getHeight()-50.17865432);
        position=position.add(velocity);
    }

    public Vector2D getCenter(){
        return new Vector2D(position.getX()+ texture.getWidth()-120, position.getY()+ texture.getHeight()-65);
    }


    @Override
    public void draw(Graphics graphics) {
        //graphics.drawImage(texture, (int)position.getX(), (int)(position.getY(),null); //checar si se elimina
        Graphics2D g2d = (Graphics2D)graphics;
        at = AffineTransform.getTranslateInstance(position.getX(),position.getY());
        at2 = AffineTransform.getTranslateInstance(position.getX(),position.getY());
        at.rotate(angle,Assets.player1.getWidth()/2,Assets.player1.getHeight()/2);
        at2.rotate(angle,Assets.player2.getWidth(),Assets.player2.getHeight());
        g2d.drawImage(Assets.player1,at,null);
        g2d.drawImage(Assets.player2,at2,null);

    }

}
