import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Fenster extends JFrame {
   private int pixelDistance =200; //Distanc die die Maus von dem X entfernt ist bevor teleport
   int zeit = 60; //Zeit bis Bluescreen
    
    public Fenster()
    {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //Verhindert das schliesen des Fensters
        setAlwaysOnTop(true);//Sorgt dafür das dass Fenster über allem ist
        setUndecorated(true);//sorgt dafür das Keine obere Leiste mehr existiert
        setSize(480,350);//sezt die größe
        setIconImage(ArbeitsUmKordienierer.loadmage("/rickrollicon.jpg"));//Setz ein anderes Icon
        ImageIcon gif = new ImageIcon(ArbeitsUmKordienierer.programmOrdner + "/rickroll.gif");
        JLabel gifContainer= new JLabel(gif);//Macht den Rickrollgif in das Fenster
        
        gifContainer.setHorizontalAlignment(JLabel.CENTER);
        gifContainer.setVerticalAlignment(JLabel.BOTTOM);
        gifContainer.setSize(new Dimension(getWidth(), getHeight() - 40));
        ImageIcon schliessen = new ImageIcon(ArbeitsUmKordienierer.programmOrdner + "/schliessen.png"); //Macht das schliesbuten Image
        JButton schliessenKnopf = new JButton(schliessen);
        
        schliessenKnopf.setSize(40, 40);
        schliessenKnopf.setLocation(getWidth()-45, 5);


        schliessenKnopf.addActionListener(new ActionListener() {  //Wenn man es hinkriegt denn Knopf zu drücken kommt ein weiteres Fenster
          @Override
          public void actionPerformed(ActionEvent e) {//e=sin Informationen über die Action
              new Fenster();
          }  
        });
       
        JLabel timerDisplay = new JLabel("60");//Mact den Timer
        timerDisplay.setLocation(10,10);
        timerDisplay.setFont(new Font("Arial", Font.BOLD, 24));
        timerDisplay.setSize(50, 20);
        this.getContentPane().add(timerDisplay);
        timerDisplay.setForeground(Color.BLUE);
        this.getContentPane().add(schliessenKnopf);
        this.getContentPane().add(gifContainer);
        Timer timer = new Timer(1000,new ActionListener() {//Gibt jede Sekunde eine Action
            public void actionPerformed(ActionEvent e){
                zeit--;
                
                timerDisplay.setText(Integer.toString(zeit));//setz den text vom timer
                if (zeit<=0) {                               //Führt den Bluescreen aus und Stopt den Timer
                    ((Timer) e.getSource()).stop();
                   
                    Bluescreen.dasEnde();
                }
                
            }
        });
        
        timer.start();
        setVisible(true);

        addMouseMotionListener(new MouseMotionAdapter() { //sorgt dafür das sich das Fenster weg tpt wenn die Maus zu nah kommt
            @Override
            public void mouseMoved(MouseEvent e){
                Point mausPosition = e.getLocationOnScreen();
                Point fensterPosition = getLocationOnScreen();
                Point schließenKnopf = new Point(fensterPosition.x + getWidth() - 10, fensterPosition.y + 10);
                double distance = mausPosition.distance(schließenKnopf);//Ermittelt die distance zwischen Maus und Schliesknopf

                if(distance < pixelDistance){ //Teleportiert das fenster an einen anderen Punkt
                    Dimension bildschirmGröße = Toolkit.getDefaultToolkit().getScreenSize();
                    int neueXposition = (int) (Math.random() * (bildschirmGröße.width - getWidth()));
                    int neueYposition = (int) (Math.random() * (bildschirmGröße.height - getHeight()));
                    setLocation(neueXposition, neueYposition);                }

            }  
        });



    }
}