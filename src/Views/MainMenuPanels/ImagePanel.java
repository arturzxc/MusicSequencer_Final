package Views.MainMenuPanels;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *ImagePanel is custom made in order to be added a custom image as a background to the panel.
 *In order to be painted an image, the paintComponent method is overridden.
 * @author Group 21
 */
public class ImagePanel extends JPanel {
    private ImageIcon icon;
    
    /** 
     * the Constructor takes an argument a String variable representing the path of the passed image.
     * @param img 
     */
    public ImagePanel(String img)
    {
     icon = createImageIcon(img);
    }
    @Override
    public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D)g;
            g2d.drawImage(icon.getImage(),0,0, this.getWidth(), this.getHeight(), this);  
    }
    /**
     * The following method gets the actual path of the image and if the path is valid, a new ImageIcon is returned.
     * @param path
     * @return 
     */
          protected static ImageIcon createImageIcon(String path) 
          {
            java.net.URL imgURL = Object.class.getResource(path);
            if (imgURL != null) {
                return new ImageIcon(imgURL);
            } else {
                System.err.println("Couldn't find file: " + path);
                return null;
            }
          }
 }
