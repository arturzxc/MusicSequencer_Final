package Views.SoundPanel;


import Views.GridElements.FrameLbl;
import Views.SoundPanelElements.AddSoundButton;
import Views.SoundPanelElements.BlankIcon;
import Views.SoundPanelElements.SoundIcon;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *This is a class used by SoundPanel which grids out the SoundIcons in the SoundPanel
 * @author IgIz
 */
public class SoundPanelGrid extends JPanel{
    private ArrayList<SoundIcon> sounds;
    private int count;
    private AddSoundButton btn;
    private int emptyCount = 5;
    
    /**
     * Constructor for SoundGrid ,this class holds all the sounds in the side panel as icons on 
     * a conventional design.It requires a AddSoundButton which is the button displayed as + on the
     * grid
     * @param AddSoundButton
     */
    public SoundPanelGrid(AddSoundButton btn){
        this.btn = btn;
        sounds = new ArrayList<SoundIcon>();
        this.setLayout(new GridLayout(6,1));
        this.count = 0;
        
        this.add(btn);
        
        for(int i=1;i<6;i++){
         this.add(new BlankIcon());   
        }
    }
    
    /**
     * Method for adding SoundIcons into the grid.It removes all current elements and re-adds them again
     * any empty spaces are replaced by empty button which is just a label with a border.
     * @param SoundIcon
     */
    public void addSound(SoundIcon icon){
        if(count == 6){
            return;
        }
        this.removeAll();
        sounds.add(icon);
        count++;
        for(SoundIcon s:sounds)
            this.add(s);
        if(count != 6)
            this.add(btn);
        
        for(int i=0;i<emptyCount-sounds.size();i++)
            this.add(new BlankIcon());
        this.repaint();
    }
    
    /**
     * Method for clearing all the sounds inside 
     */
    public void clearSounds(){
        for(int i =0;i< sounds.size();i++){
            sounds.get(i).getSound().remove();
            removeSound(sounds.get(i));
         }
    }
    
    /**
     * Method for removing a SoundIcon from the grid in the SoundsPanel,this is called by removeSound method in the SoundPanel class in this apckage
     * The method clears all currently added SoundIcons and re-adds them again to so they are in order.Also clears any
     * frames that the SoundIcon was attached to and shifts other SoundIcon frames up.This method is only used in conventional design
     * @param icon 
     */
    public void removeSound(SoundIcon icon){
            
        int soundsNo = mseq.Mseq.model.getPlayer().getNumberOfSounds();
        
        if(icon.getSound().getID() < soundsNo){
            for(int j = icon.getSound().getID();j<soundsNo;j++){
           ArrayList<FrameLbl> soundFrames =  mseq.Mseq.view1.getContentPnl().getGridPanel().getFramesInRow(j);
           ArrayList<FrameLbl> other = mseq.Mseq.view1.getContentPnl().getGridPanel().getFramesInRow(j+1);
           //Clear all the frames in the row and add any frames of the sound that was shifted up
           for(int i =0;i<other.size();i++){
               soundFrames.get(i).reset();
               soundFrames.get(i).setSquare(other.get(i).getSquare());
               soundFrames.get(i).setOn(other.get(i).getOn());
               other.get(i).reset();
           }
         }
        }else{
            ArrayList<FrameLbl> soundFrames =  mseq.Mseq.view1.getContentPnl().getGridPanel().getFramesInRow(icon.getSound().getID());
            
            for(FrameLbl lbl:soundFrames){
                lbl.reset();
            }
        }
            
        //Remove all soundIcons and repaint them again    
        this.removeAll();
        sounds.remove(icon);
        for(SoundIcon s:sounds)
            this.add(s);
        this.add(btn);
        
        for(int i=0;i<emptyCount-sounds.size();i++)
            this.add(new BlankIcon());
        
        this.repaint();
        count--;
        this.repaint();
    }
    
}
