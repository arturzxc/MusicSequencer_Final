/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.net.URL;

/**
 *
 * @author arturzxc
 */
public class Configs { 
    //This is a class to get paths. 
    //Import it to your class and you can just type IMAGE_PATH to get image path    
   public static final String IMAGE_PATH="/resources/images/";
   public static final URL SOUND_PATH=Object.class.getResource("/resources/sounds/");
   
   //you can call IMAGE_PATH after importing the class. no need for getters as its public.
   //EMAMPLE
   //new ImageIcon(getClass().getResource(Configs.IMAGE_PATH+"squareYellow.png")).getImage();
}
