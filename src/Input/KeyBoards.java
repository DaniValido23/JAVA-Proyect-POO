package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class KeyBoards implements KeyListener {

    private boolean[]keys = new boolean[256];

    public static boolean UP,LEFT,RIGHT,DOWN,SHOOT;

    public KeyBoards(){
        UP=false;
        LEFT=false;
        RIGHT=false;
        DOWN=false;
        SHOOT=false;
    }
    public void update(){
        UP=keys[KeyEvent.VK_W];
        LEFT=keys[KeyEvent.VK_A];
        RIGHT=keys[KeyEvent.VK_D];
        DOWN=keys[KeyEvent.VK_S];
        SHOOT=keys[KeyEvent.VK_O];

    }
    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()]=true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()]=false;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
}
