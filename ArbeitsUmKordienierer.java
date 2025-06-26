import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.*;

public class ArbeitsUmKordienierer {
    public static String programmOrdner = new File("").getAbsolutePath(); //Gibt den Pfad zu dem Ordner in dem das Java Program läuft

    public static BufferedImage loadmage(String bildPfad ) { //Pfad von Bild
        BufferedImage f1= null;
        try{
            f1=ImageIO.read(new File(programmOrdner+bildPfad));//Ziehtssich das Bild aus dem Pfad
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return f1;
    } 
}
