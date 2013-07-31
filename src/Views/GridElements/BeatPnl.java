
package Views.GridElements;

import Models.Grid.Beat;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
/**
 *
 * @author Group 21
 * this panel holds frames. It is a wrapper class for Beat in the model package.
 */
public class BeatPnl extends JPanel{
    private Beat beat;//model package.
    private ArrayList<FrameLbl> frames = new ArrayList<FrameLbl>();
    
    /**
     * The beat might be the part of the time line if specified so.     
     * @param beat
     * @param isTimeLine 
     */
    public BeatPnl(Beat beat, boolean isTimeLine){
        this.beat=beat;
        
        setLayout(new GridLayout(1,0));
        setOpaque(false);
        setToolTipText("This is beat: "+beat.getNo());
        if(isTimeLine){
            for(int i=0;i<4;i++){
                add(new TimeFrameLbl());
            }
        }else{
            for(int i=0;i<beat.getFramesNo();i++){
                FrameLbl frame = new FrameLbl(beat.getFrames().get(i));
                add(frame);
                frames.add(frame);
            }
        }

    }
    
    public ArrayList<FrameLbl> getFrames(){
        return frames;
    }
    
    
    public Beat getBeat() {
        return beat;
    }
}
