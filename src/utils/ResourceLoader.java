/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author arturzxc
 */
public class ResourceLoader {
    
    private static final String IMAGE_PATH = "/resources/images/";
    
    public static Image loadImage(String str){        
        Image img = new ImageIcon(Object.class.getResource(IMAGE_PATH+str)).getImage();
        return img;
    }
    
}
