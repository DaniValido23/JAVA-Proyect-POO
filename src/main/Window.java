package main;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Window extends JFrame implements Runnable{

    public static final int WIDTH = 800, HEIGHT = 600;
    private Canvas canvas;
    private Thread thread;
    private boolean runnig=false;
    private BufferStrategy bs;
    private Graphics graphics;

    public Window(){
        setTitle("Defensores supremos");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        canvas=new Canvas();
        canvas.setPreferredSize(new Dimension(getWidth(), getHeight()));
        canvas.setMaximumSize(new Dimension(getWidth(), getHeight()));
        canvas.setMinimumSize(new Dimension(getWidth(), getHeight()));
        add(canvas);
        canvas.setFocusable(true);

    }

    public static void main(String[] args){
        new Window().start();
    }
    int x=0;
    private void update(){
    x++;
    }

    private void draw(){
        bs=canvas.getBufferStrategy();

        if(bs==null){
            canvas.createBufferStrategy(3);
            return;
        }
        graphics=bs.getDrawGraphics();
        /*****************************/
        graphics.clearRect(0,0,getWidth(),getHeight());
        graphics.drawRect(x,0,100,100);
        /*****************************/
        graphics.dispose();
        bs.show();

    }

    @Override
    public void run() {
        while(runnig){
            update();
            draw();
        }
        stop();
    }

    private void start(){
        thread = new Thread(this);
        thread.start();
        runnig=true;
    }

    private void stop(){
        try {
            thread.join();
            runnig=false;
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
