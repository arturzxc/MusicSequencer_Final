package Views.ControlMenuElements;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import utils.ResourceLoader;

/*
 * The class for volume meter label which given a right value displays the percentage of the volume.
 */

/**
 *
 * @author IgIz
 */
public class MeterLabel extends JLabel {
    private Image img;   
    private String text;
    private String id;
    /**
     *Construtor for the class , takes in the image of the meter and the id. 
     */
      public MeterLabel (Image img,String id){
          this.img = img;
          this.id = id;
          this.text = "";
          
          
        Dimension size = new Dimension(80,40);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
        setOpaque(false);
      }
      /**
       * The setter method for setting the value for the meter to display.
       * @param n 
       */
      public void setValue(int n){
          text = Integer.toString(n)+" "+id;
          this.repaint();
      }
      
      /**
       * Method for painting the meter label
       * @param g 
       */
    
    @Override
      public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;        
        g2.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("AR CENA",Font.BOLD,(this.getWidth()+this.getHeight())/7));
        g2.drawString(text, (int)((float)this.getWidth()/4.5), (int)((float)this.getHeight()/1.5));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        
    }
}
