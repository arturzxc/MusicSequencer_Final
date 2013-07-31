package Views.Novel.MainMenuPanel;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * MeterLabel is reused and tweaked so it fits the dimensions of the novel design. 
 * An image that is set to background is passed. Then a string representing the BPM is drawn on top of the background.
 * @author Group 21
 */
public class MeterLabel extends JLabel {
    private Image img;   
    private String text;
    private String id;
    
    
      public MeterLabel (Image img,String id){
          this.img = img;
          this.id = id;
          this.text = "";
      }
      
      public void setValue(int n){
          text = Integer.toString(n)+" "+id;
          this.repaint();
      }
    /**
     * Overridden paint method that paints the MeterLabel and a String on top of it.  
     * @param g 
     */
    @Override
      public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        Image img = this.img;
        g2.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("AR CENA",Font.BOLD,(this.getWidth()+this.getHeight())/9)); //a certain font is set depending on the size of the parent panel.
        g2.drawString(text, (int)((float)this.getWidth()/6), (int)((float)this.getHeight()/1.5));//the string is drawn inside, again depending on the size of the parent panel
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);        
    }
      
}
