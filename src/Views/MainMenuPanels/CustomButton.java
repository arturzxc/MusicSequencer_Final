package Views.MainMenuPanels;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 *CustomButton is a JLabel that has overridden paintComponent method on order to paint, the passed Image, with preferred size.
 * @author Group 21
 */
public class CustomButton extends JLabel{
   
    private Image icon;
    
    public CustomButton(Image icon)
    {
        this.icon=icon;
         setOpaque(false);
    }
   /**
    * The overridden paintComponent method that recalculates preferred size when painting the passed Image.
    * @param g 
    */ 
    @Override
   public void paintComponent(Graphics g)
   {
            float fWidth = (float)(this.getWidth()/1.5);
            int width = (int)fWidth;
            
            float fHeight =(float)(this.getHeight()/1.5);
            int height = (int)fHeight;
       
            Graphics2D g2d = (Graphics2D)g;
            g2d.drawImage(icon, this.getWidth()/4, this.getHeight()/5, width, height , this);        
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   }

}
