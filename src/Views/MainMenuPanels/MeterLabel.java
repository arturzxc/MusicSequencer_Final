package Views.MainMenuPanels;


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
 * 
 * @author IgIz
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
    
    @Override
      public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;        
        g2.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("AR CENA",Font.BOLD,(this.getWidth()+this.getHeight())/9));
        g2.drawString(text, (int)((float)this.getWidth()/6), (int)((float)this.getHeight()/1.5));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);        
    }
      
}
