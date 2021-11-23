package States;

import gameObjects.Player;
import Graphics.Assets;
import math.Vector2D;
import java.awt.Graphics;


public class GameState {

    private Player player1;

    public GameState(){
        player1 = new Player(new Vector2D(100, 500), Assets.player1);
    }

    public void update(){

    }

    public void draw(Graphics graphics){
        player1.draw(graphics);
    }

}
