
package Views.GridElements;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import utils.ResourceLoader;

/**
 *This is the timeline class for conventional design.
 * @author group_21
 */
public class TimeLine extends JPanel{
    private int x = 10;
    private int y =0;
    private JLabel img;
    private Timeline timeLine = new Timeline();
    private int speed = 1;
    private int beat = 0;
    private int totalBeats = 6*5;
    Timer tm;
    
    /**
     * The constructor for the timeline,sets initial height and width of it.Also uses a timer.
     */
    public TimeLine(){
        setLayout(null);        
        timeLine.setBounds(x, y, 4,this.getHeight());
        add(timeLine);
        tm = new Timer(speed, new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                move();
            }
            
        });
        
        setOpaque(false);
        this.repaint();
    }
    
    /**
     * Setting the speed of the timeline
     * @param n 
     */
    public void setSpeed(int n){
       speed+=n;
    }
    /**
     * Method which moved the timeline fowards
     */
    public void move(){
        x+=mseq.Mseq.view1.getContentPnl().getGridPanel().getNumberingPnl().get(0).getBeatsLine().get(0).getFrames().get(0).getWidth();
        timeLine.setBounds(x, y, 4, this.getHeight());
        timeLine.repaint();
        if(this.getWidth()-20 <= x)
          x=10+mseq.Mseq.view1.getContentPnl().getGridPanel().getNumberingPnl().get(0).getBeatsLine().get(0).getFrames().get(0).getWidth();
    }

    /**
     * The class for painting the timeline.
     */
    class Timeline extends JLabel
    {
        public void paintComponent(Graphics g)
        {
            Graphics2D g2d = (Graphics2D)g;
            g2d.drawImage(ResourceLoader.loadImage("timeLine.png"),0,0, this);
        
        }
    
    }
    
}
