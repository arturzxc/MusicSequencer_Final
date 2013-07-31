package Views.SoundPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import utils.ResourceLoader;

/**
 *Acts like a panel ,but instead uses an image to draw its background,requires the actual image in the constructor.
 * Used widely in the project to set backgrounds to some panels
 * @author IgIz
 */
public class ImagePanel extends JLabel {
    private Image img;

    /**
     * Constructor for the imagepanel which takes in the image that has to be drawn.
     * @param img 
     */
    public ImagePanel(Image img) {
        this.img = img;
    }
    
    /**
     * Overriden paint method to paint the image on the panel according to the panels size.
     * @param g 
     */
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0,this.getWidth(),this.getHeight(),this);
    }
 }
