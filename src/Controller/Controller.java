package Controller;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Group 21
 * This class just controls the time line and tells it when to update using observer design pattern.
 */
public class Controller implements Observer {

    
    public void update(Observable o, Object arg) {
        String argu = (String)arg;
       
        if(argu.equals("timeLine")){ 
            if(mseq.Mseq.type.equals("novel")){
                mseq.Mseq.view2.getDragPanel().updateTimeLine();
            }
            else if (mseq.Mseq.type.equals("conventional")){
                mseq.Mseq.view1.getContentPnl().getTimeLine().move();
            }
        }
    }
    
}
