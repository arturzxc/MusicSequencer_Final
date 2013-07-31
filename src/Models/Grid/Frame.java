
package Models.Grid;

import java.awt.Color;
import java.awt.Image;

/**
 *
 * @author arturzxc
 * A beat consists of Frames.
 * A frame is a representation of a sound
 */
public class Frame {
    
    private int no;
    private String soundURL;
    private Color color;
    private Color hoverColor;
    private Image normalImage;///image for the wrapper class in views. The wrapper of frame will have to acces the property
    private Image hoverImage;
    private boolean on;
    
    public Frame(int no, String soundURL, Color color, Color hoverColor, Image normalImage, Image hoverImage) {
        this.no = no;
        this.soundURL = soundURL;
        this.color = color;
        this.hoverColor = hoverColor;
        this.normalImage = normalImage;
        this.hoverImage = hoverImage;
    }

    public Color getColor() {
        return color;
    }

    public boolean isOn() {
        return on;
    }

    /**
     * if this is on the sound will be played when the time line is on it.
     * @param on 
     */
    public void setOn(boolean on) {
        this.on = on;
    }

    public Color getHoverColor() {
        return hoverColor;
    }

    public Image getHoverImage() {
        return hoverImage;
    }

    public int getNo() {
        return no;
    }

    public Image getNormalImage() {
        return normalImage;
    }

    public String getSoundURL() {
        return soundURL;
    }

    
}
