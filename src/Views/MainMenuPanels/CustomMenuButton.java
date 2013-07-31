package Views.MainMenuPanels;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 *Custom button it extends JLabel, because of easier handling when adding with other components with different size to one conatiner.
 * @author Group 21
 */
public class CustomMenuButton extends JLabel{
   
    private Image icon;
    /**
     * The constructor takes an image as an argument which is then used in the overridden method paintComponent. 
     * @param icon 
     */
    public CustomMenuButton(Image icon)
    {
        this.icon=icon;
        setOpaque(false);
    }
    
    @Override
   public void paintComponent(Graphics g)
   {
            Graphics2D g2d = (Graphics2D)g;
            g2d.drawImage(icon, 0, 0, this.getWidth(), this.getHeight(), this);        
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   }

}
