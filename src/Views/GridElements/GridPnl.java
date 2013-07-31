
package Views.GridElements;

import Models.Grid.BeatsLine;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import mseq.Mseq;
/**
 *
 * @author Group 21
 * This is a graphical representation of the grid. It is a wrapper class fro Grid in the model package.
 */
public class GridPnl extends JPanel{
    private ArrayList<BeatsLine> numberingLines = Mseq.model.getGrid().getBeatsLines();//accessess grid in a static way.
    private ArrayList<NumbernigPnl> lines = new ArrayList<NumbernigPnl>();
    
    public GridPnl() {
        setOpaque(false);
        setLayout(new GridLayout(0, 1));
        
        //Adding rows which contain beats.
        for(int i=0;i<numberingLines.size();i++){  
            NumbernigPnl temp = new NumbernigPnl(numberingLines.get(i), "Tone no: "+(i+1));//adding beat lines.
            add(temp); 
            lines.add(temp);
        }
    }
    
    public ArrayList<NumbernigPnl> getNumberingPnl(){
        return lines;
    }
    
    public ArrayList<FrameLbl> getFramesInRow(int n){
        ArrayList <BeatPnl> beats = lines.get(n).getBeatsLine();
        
        ArrayList<FrameLbl> frames = new ArrayList<FrameLbl>();

            for(int i=0;i<beats.size();i++)
                for(int j =0;j < beats.get(i).getFrames().size();j++)
                    frames.add(beats.get(i).getFrames().get(j));        
                            
        return frames;
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.black);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setColor(Color.white);
        g2.drawRect(0, 0, getWidth()-1, getHeight()-1);
        setBorder(new EmptyBorder(getHeight()/10,getWidth()/50,getHeight()/10,getWidth()/50));//this border is to make grid corespond with the sounds panel on the rght
    }
    
    /**
     * resets the image of the frame.
     * @param id 
     */
    public void resetFrames(int id){
         ArrayList<FrameLbl> framesInRow = mseq.Mseq.view1.getContentPnl().getGridPanel().getFramesInRow(id);
         
         for(FrameLbl frame:framesInRow){
             frame.reset();
         }
    }
}
