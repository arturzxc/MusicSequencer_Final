package Views.SoundPanel;


import Views.SoundPanelElements.AddSoundButton;
import Views.SoundPanelElements.SoundIcon;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import utils.ResourceLoader;

/**
 *The class which holds the SoundIcons in the panel in conventional design.
 * @author IgIz
 */
public class SoundPanel extends ImagePanel{
    SoundPanelGrid sounds = new SoundPanelGrid(new AddSoundButton(ResourceLoader.loadImage("addButton.png")));
    
    public SoundPanel(){
        super(ResourceLoader.loadImage("soundPanelBackground_1.png"));
        this.setLayout(null);
        sounds.setOpaque(false);
        this.setLayout(new GridLayout(1,1));
        this.setBorder(new EmptyBorder(25,5,20,5));
        this.add(sounds);
    }
    /**
     * Method for adding a SoundIcon the the SoundPanel
     * @param sound 
     */
    public void addSound(SoundIcon sound){
        sounds.addSound(sound);
        this.revalidate();
        this.repaint();
    }
    
    /**
     * Method for removing one SoundIcon,takes in the sound as an argument.
     * @param sound 
     */
    public void removeSound(SoundIcon sound){
        sounds.removeSound(sound);
        this.revalidate();
        this.repaint();
    }
    /**
     * Method for clearing all the SoundIcons in the panel by removing.
     */
    public void clearSounds(){
       
        sounds.clearSounds();
        revalidate();
        repaint();
    }
    
    /**
     * Getter for soundpanel
     * @return 
     */
    public SoundPanelGrid getSoundPanel(){
        return sounds;
    }
    
}
