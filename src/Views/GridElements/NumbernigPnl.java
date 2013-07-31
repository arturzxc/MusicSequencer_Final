package Views.GridElements;

import Models.Grid.BeatsLine;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author Group 21
 * this is wrapper class for the BeatsLine from the model package.
 */
public class NumbernigPnl extends JPanel{        
    
    private BeatsLine numbering;
    private ArrayList<BeatPnl> beats = new ArrayList<BeatPnl>();
    
    public NumbernigPnl(BeatsLine numbering, String name) {
        this.numbering=numbering;
        
        setLayout(new GridLayout(1,7));
        setOpaque(false);
        setBorder(new EmptyBorder(5, 0, 0, 0));
        setToolTipText("This is line : "+(numbering.getNo()+1));
        
        
         // add beast to the row.
        for(int i=0;i<numbering.getBeats().size();i++){
            BeatPnl temp = new BeatPnl(numbering.getBeats().get(i),false);
            add(temp);
            beats.add(temp);
        }
    }
    
    public ArrayList<BeatPnl> getBeatsLine(){
        return beats;
    }

}
