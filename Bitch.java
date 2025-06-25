import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.*;

public class Bitch {
    public static BufferedImage loadmage(String banana ) {
    BufferedImage f1= null;
    String userDierectory = new File("").getAbsolutePath();
        try{
            f1=ImageIO.read(new File(userDierectory+banana ) );
        }
        catch(IOException e){
            e.printStackTrace();
        }

        return f1;
    }
    
}
