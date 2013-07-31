/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Novel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.Timer;

/**
 *Ripple Timeline class which is the rippling timeline for novel design.
 * @author IgIz
 */


public class RippleTimeLine extends JPanel {
    private int size = 50;//Initial size of the ripple
    private int x = 200;//Initial x location of the ripple
    private int y = 200;//Initial y location of the ripple
    private int expander = 0;//The ammount the ripple expands by,during each clock call.
    private int counter = 0;//Counter of how many ripples,currently unused
    private int expanderIncrement = 1;
    private Color color = Color.cyan;//COlor of the ripple timeline,determined by the icon it starts from
    
    public RippleTimeLine(){
        
    }
    /**
     * Setter for X position
     * @param n 
     */
    
    public void setX(int n){
        x = n;
    }
    
    /**
     * Setter for Y position
     * @param n 
     */
   public void setY(int n){
        y = n;
   }
   
   /**
    * Getter for Y position of the timeline
    * @return 
    */
   public int getYPos(){
       return (y - expander);
   }
   
   /**
    * Getter for X position of the timeline
    * @return 
    */
   public int getXPos(){
       return (x - expander);
   }
   
   /**
    * Method for changing the initial size of the ripple
    * @param n 
    */
   public void setInitSize(int n){
       size = n;
   }
   
   /**
    * Setter for color of the timeline
    * @param c 
    */
   public void setColor(Color c){
       color = c;
   }
   
   /**
    * REset method resets the timeline back to its default size.
    */
   public void reset(){
       expander = 0;
       counter = 0;
   }
   /**
    * Method which expands the timeline producing the ripple effect
    */
   public void expand(){
       counter = 1;
       expander+=expanderIncrement;
       repaint();
   }
    
   /**
    * Method for increasing the increment of the timeline that it expands by each time expand() is called.
    * @param n 
    */
    public void changeIncreaseSpeed(int n){
        expanderIncrement=n;
    }
    
    /**
     * Method for calculating the radius of the timeline,using current size.
     * @return radius
     */
    public double getRadius(){
        double radius =  (((size+(expander*2))));
        return radius;
    }
    
    /**
     * Getter for current size of the timeline.
     * @return 
     */
    public int getCurrentSize(){
        return size+(expander*2);
    }
    
    
    /**
     * Overriden paint method which paints the circle accordingly to the current size of the timeline,producing the ripple.
     * @param g 
     */
    @Override
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(color);
        g2.setStroke(new BasicStroke( 2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if(counter>=1){
            g2.drawOval(x-(expander), y-(expander), size+(expander*2), size+(expander*2));
        }
    }
    
    /**
     * Method which returns a BufferedImage graphics representation of the timeline
     * @return image
     */
    public BufferedImage getTimeLine(){
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gs = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gs.getDefaultConfiguration();

        return gc.createCompatibleImage(size+(expander*2), size+(expander*2), Transparency.TRANSLUCENT);
    }
    
    
}
