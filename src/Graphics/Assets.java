package Graphics;
import java.awt.image.BufferedImage;

public class Assets{
    public static BufferedImage player1,player2,laser1,laser2,laser3;

    public static void init(){
        player1 = Loader.ImageLoader("/UserSpace/UserSpace1.png");
        player2 = Loader.ImageLoader("/UserSpace/UserSpace2.png");
        laser1 = Loader.ImageLoader("/Lasers/Laser1.png");
        laser2 = Loader.ImageLoader("/Lasers/Laser2.png");
        laser3 = Loader.ImageLoader("/Lasers/Laser3.png");
    }
}
