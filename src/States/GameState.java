package States;
import Graphics.Assets;
import gameObjects.MovingObjects;
import gameObjects.Player;
import math.Vector2D;

import java.awt.*;
import java.util.ArrayList;


public class GameState {
    private Player player1;
    private Player player2;
    private ArrayList<MovingObjects> movingObjects = new ArrayList<MovingObjects>();


    public GameState(){
        player1=new Player(new Vector2D(100,500),new Vector2D(),5,Assets.player1,this);
        movingObjects.add(player1);
        //player2 = new Player(new Vector2D(10,10), new Vector2D(),5,Assets.player2,this);
        //movingObjects.add(player2);
    }

    public void update(){
        //player1.update();
        for(int i=0;i<movingObjects.size();i++) {
            movingObjects.get(i).update();
        }
    }

    public void update2(){
        for(int i=0;i<movingObjects.size();i++) {
            movingObjects.get(i).update();
        }
    }

    public void draw(Graphics graphics) {
        //player2.draw(graphics);
        for(int i=0; i<movingObjects.size();i++)
            movingObjects.get(i).draw(graphics);
    }

    public ArrayList<MovingObjects> getMovingObjects() {
        return movingObjects;
    }

}
