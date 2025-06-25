import javax.swing.*;
import java.awt.*;

public class Fenster extends JFrame {
    
    public Fenster()
    {
        
        setAlwaysOnTop(true);
        setTitle(" ");
        setSize(200,200);
        setIconImage(Bitch.loadmage("/rickrollicon.jpg"));
        ImageIcon gif = new ImageIcon(Bitch.loadmage("/rickroll.gif"));
        JLabel gifContainer= new JLabel(gif); 
        gifContainer.setHorizontalAlignment(JLabel.CENTER);
        gifContainer.setVerticalAlignment(JLabel.CENTER);
        gifContainer.setSize(this.getSize());
        this.getContentPane().add(gifContainer);
        setVisible(true);
    }
}