import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Fenster extends JFrame {
   private int pixelDistance =200; 
    
    public Fenster()
    {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setTitle(" ");
        setUndecorated(true);
        setSize(480,350);
        setIconImage(Bitch.loadmage("/rickrollicon.jpg"));
        String userDirectory = new java.io.File("").getAbsolutePath();
        ImageIcon gif = new ImageIcon(userDirectory + "/rickroll.gif");
        JLabel gifContainer= new JLabel(gif); 
        gifContainer.setHorizontalAlignment(JLabel.CENTER);
        gifContainer.setVerticalAlignment(JLabel.BOTTOM);
        gifContainer.setSize(new Dimension(getWidth(), getHeight() - 40));
        ImageIcon schliessen = new ImageIcon(userDirectory + "/schliessen.png");
        JButton schliessenKnopf = new JButton();
        schliessenKnopf.addActionListener(new ActionListener() {  //Wenn man ehinkriegt denn Knopf zu drücken kommt ein weiteres Fenster
          @Override
          public void actionPerformed(ActionEvent e) {
              new Fenster();
          }  
        });
        schliessenKnopf.setIcon(schliessen);
        schliessenKnopf.setSize(40, 40);
        schliessenKnopf.setLocation(getWidth()-45, 5);
        this.getContentPane().add(schliessenKnopf);
        this.getContentPane().add(gifContainer);
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e){
                Point mausPosition = e.getLocationOnScreen();
                Point fensterPosition = getLocationOnScreen();
                Point schließenKnopf = new Point(fensterPosition.x + getWidth() - 10, fensterPosition.y + 10);
                double distance = mausPosition.distance(schließenKnopf);

                if(distance < pixelDistance){
                    Dimension bildschirmGröße = Toolkit.getDefaultToolkit().getScreenSize();
                    int neueXposition = (int) (Math.random() * (bildschirmGröße.width - getWidth()));
                    int neueYposition = (int) (Math.random() * (bildschirmGröße.height - getHeight()));
                    setLocation(neueXposition, neueYposition);                }

            }  
        });
        
        setVisible(true);

    }
}