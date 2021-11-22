package Graphics;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets{
    public static BufferedImage player1;

    public static void init(){
        player1 =Loader.ImageLoader("/UserSpace/UserSpace1.png");
        player1.getScaledInstance(100,100,Image.SCALE_SMOOTH);

    }
}
