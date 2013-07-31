package Views.MainMenuPanels;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import utils.ResourceLoader;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

/**
 *CustomImageIcon extends JLabel and overrides paintComponent method in order to set the size of the painted image.
 * @author Group 21
 */
public class CustomImageIcon extends JLabel {


    private Image icon;
    
    public CustomImageIcon(String img)
    {
     icon = ResourceLoader.loadImage(img);
     setOpaque(false);
    }
    
    public CustomImageIcon(Image img)
    {
    this.icon=img;
    setOpaque(false);
    
    }
    /**The overridden paintComponent method takes Graphics g as an argument.
     * New dimensions are calculated and passed to the drawImage method that is called on the g2d variable. 
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D)g;
            double temp1 = (float)this.getWidth()/1.5;
            double temp2 = this.getHeight()/1.5;
                    
            int fin1 = (int)temp1;
            int fin2 = (int)temp2;
            g2d.drawImage(icon, this.getWidth()/6, this.getHeight()/6, fin1, fin2, this);  
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

 }
 
