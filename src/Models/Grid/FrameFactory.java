
package Models.Grid;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import Models.Configs;

/**
 *
 * @author arturzxc
 * This is a factory that produces frames and keep track of their numbers.
 */
public class FrameFactory {
    
    private static int no;//indicates that factory is not set yet.
    private static boolean set;
    private static String soundURL;
    private static Color color;
    private static Color hoverColor;
    private static Image normalImage;
    private static Image hoverImage;
    
    /** 
     * this will cause the factory to produce piano frames.
     * this is only a default.
     */
    public static void setProductionToPiano(){      
        no=0; //reset counter everytime a new frame is created      
        set=true;
        
        soundURL = Configs.SOUND_PATH+"PianoA.aif";
        color = new Color(100,100,100,100); //last argument is alpha
        hoverColor = new Color(200,200,200,100);
        normalImage = new ImageIcon(Object.class.getResource(Configs.IMAGE_PATH+"squareYellow.png")).getImage();
        hoverImage = new ImageIcon(Object.class.getResource(Configs.IMAGE_PATH+"squareRed.png")).getImage();
    }
    
    /**
     * creates a frame.
     * @return 
     */
    public static Frame createFrame(){
        if(!set){//if production type no set then set t piano.
            setProductionToPiano();            
        }
        no++;//increase the number of the frames created.
        return new Frame(no, soundURL, color, hoverColor, normalImage, hoverImage);
        
    }
}
