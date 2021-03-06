package main;
import Graphics.Assets;
import Input.KeyBoards;
import States.GameState;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Window extends JFrame implements Runnable{

    public static final int WIDTH = 1400, HEIGHT = 1000;
    private Canvas canvas;
    private Thread thread;
    private boolean running=false;
    private BufferStrategy bs;
    private Graphics graphics;

    private final int FPS = 60;
    private double TARGETTIME = 1000000000/FPS;
    private double delta = 0;
    private int AVERAGEFPS = FPS;

    private GameState gameState;
    private KeyBoards KeyBoards;

    public Window(){
        setTitle("Defensores supremos");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        canvas=new Canvas();
        KeyBoards = new KeyBoards();

        canvas.setPreferredSize(new Dimension(getWidth(), getHeight()));
        canvas.setMaximumSize(new Dimension(getWidth(), getHeight()));
        canvas.setMinimumSize(new Dimension(getWidth(), getHeight()));
        canvas.setFocusable(true);
        
        add(canvas);
        canvas.addKeyListener(KeyBoards);
    }

    public static void main(String[] args){
        new Window().start();
    }

    private void update(){
        KeyBoards.update();
        gameState.update();
    }

    private void update2(){
        KeyBoards.update();
        gameState.update();
    }

    private void draw(){
        bs=canvas.getBufferStrategy();

        if(bs==null){
            canvas.createBufferStrategy(3);
            return;
        }
        graphics=bs.getDrawGraphics();
        /*****************************/
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,getWidth(),getHeight());
        gameState.draw(graphics);
        graphics.drawString(""+AVERAGEFPS, 10, 20);

        /*****************************/
        graphics.dispose();
        bs.show();

    }
    private void init(){
        Assets.init();
        gameState = new GameState();
    }


    @Override
    public void run() {

        long now = 0;
        long lastTime = System.nanoTime();
        int frames = 0;
        long time = 0;
        init();
        while(running){
            now = System.nanoTime();
            delta += (now - lastTime)/TARGETTIME;
            time += (now - lastTime);
            lastTime = now;

            if(delta >= 1){
                update();
                draw();
                delta --;
                frames ++;
            }
            if(time >= 1000000000){
                AVERAGEFPS = frames;
                frames = 0;
                time = 0;
            }
        }
        stop();
    }

    private void start(){
        thread = new Thread(this);
        thread.start();
        running=true;
    }

    private void stop(){
        try {
            thread.join();
            running=false;
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
