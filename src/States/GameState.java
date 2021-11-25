package States;
import java.awt.Graphics;

import gameObjects.GameObject;
import gameObjects.MovingObjects;
import gameObjects.Player;
import Graphics.Assets;
import math.Vector2D;
import java.awt.Graphics;
import java.util.ArrayList;


public class GameState {
    private Player player1;
    private ArrayList<MovingObjects> movingObjects = new ArrayList<MovingObjects>();

    public GameState(){
        player1=new Player(new Vector2D(100,500),new Vector2D(),5,Assets.player1,this);
        movingObjects.add(player1);
    }

    public void update(){
        //player1.update();
        for(int i=0;i<movingObjects.size();i++) {
            movingObjects.get(i).update();
        }
    }

    public void draw(Graphics graphics) {
        //player1.draw(graphics);
        for(int i=0; i<movingObjects.size();i++)
            movingObjects.get(i).draw(graphics);
    }

    public ArrayList<MovingObjects> getMovingObjects() {
        return movingObjects;
    }

}
