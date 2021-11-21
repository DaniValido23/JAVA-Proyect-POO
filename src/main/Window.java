package main;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Window extends JFrame implements Runnable{

    public static final int WIDTH = 800, HEIGHT = 600;
    private Canvas canvas;
    private Thread thread;
    private boolean runnig=false;
    private BufferStrategy bs;
    private Graphics graphics;

    private final int FPS = 60;
    private double TARGETTIME = 1000000000/FPS;
    private double delta = 0;
    private int AVERAGEFPS = FPS;

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
        graphics.setColor(Color.BLACK);
        graphics.drawString(""+AVERAGEFPS, 10, 10);
        /*****************************/
        graphics.dispose();
        bs.show();

    }

    @Override
    public void run() {

        long now = 0;
        long lastTime = System.nanoTime();
        int frames = 0;
        long time = 0;

        while(runnig){
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
