/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Views.GridElements;

import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author Group 21
 */
public class TimeBeatPnl extends JPanel{
    
    public TimeBeatPnl(){
        setLayout(new GridLayout(1,0));
        setOpaque(false);

        //add frames to the beat.
            for(int i=0;i<4;i++){
                add(new TimeFrameLbl());
            }
    }
    
}
