package Views.Novel.ControlsSlidingPanel;

import Views.Novel.SoundsPanel;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * 
 * @author Group 21
 * This is a wrapper class for the Sounds panel. 
 * its purpose is to simulate animation of sliding up/down when clicking the sounds button.
 */
public class BotSlidingContentPane extends JPanel{
    
    private GridBagConstraints cons;
    private JPanel placeHolder=new JPanel();
    private SoundsPanel soundsPanel;    
    private boolean isUp;
    
    
    private final int DELAY=1;        
    private final double SMOOTHNES=200;   //how smooth the animation progress. the smother the slower and vice versa.
    private final double CHANGE_RATE=1;        
    private final double DIFFERENCE = 0.14;//difference between the slide nup and slide down.

    private final double TOP_MAX = 0.99;
    private final double BOT_MIN = 0.01; 
    
    private final double SMOOTHED_CHANGE_RATE=CHANGE_RATE/SMOOTHNES;
    private final double SMOOTHED_DIFFERENCE=DIFFERENCE*SMOOTHNES;
          
    //Botom panel is slided down.
    private double topSize=TOP_MAX;
    private double botSize=BOT_MIN;
    
    private int looped=0;
            
    private Timer t;
    
    public BotSlidingContentPane(){       
        setLayout(new GridBagLayout());
        setBackground(Color.green);     
        setOpaque(false);
        setUpConstraints();
        setUpAllPanels();
        
        setConstraints(0,0,1,topSize,1,1);
        add(placeHolder, cons);
        
        setConstraints(0, 1, 1, botSize, 1, 1);
        add(soundsPanel,cons);
    }
    
    /**
     * sets up all panels.
     */
    private void setUpAllPanels(){
        placeHolder = new JPanel();
        placeHolder.setOpaque(false);
        
        soundsPanel = new SoundsPanel();   
        soundsPanel.setVisible(false);
    }

    /**
     * sets up constraints to the one needed. the layout is GridBag layout.
     */
    private void setUpConstraints(){
        cons = new GridBagConstraints();
        cons.anchor=GridBagConstraints.NORTHWEST;
        cons.fill=GridBagConstraints.BOTH;
        cons.weightx=1;
        cons.weighty=1;
        cons.gridheight=1;
        cons.gridwidth=1;              
    }
    
    /**
     * This helps to set up the layout.
     * @param gridx
     * @param gridy
     * @param weightx
     * @param weighty
     * @param gridheight
     * @param gridwidth 
     */
    
    private void setConstraints(int gridx, int gridy,double weightx, double weighty, int gridheight,int gridwidth){
        cons.gridx=gridx;
        cons.gridy=gridy;
        cons.weightx=weightx;
        cons.weighty=weighty; 
        cons.gridheight=gridheight;
        cons.gridwidth=gridwidth;
    }              
    
    /**
     * Run the animation using Timer
     */
    public void slide(){
        if(!isUp){
            
            soundsPanel.setVisible(true);            
            isUp=true;
            looped=0;
            t=new Timer(DELAY, new SlideUp()); 
            t.start();
        }else{
            topSize=TOP_MAX;
            botSize=BOT_MIN; 
            isUp=false;
            slideDown();
            soundsPanel.setVisible(false);
            
        }
    }
    
    /**
     * Removes everything from the panel and adds it again with the new layout to simulate the animation.
     */
    private void slideDown(){
            removeAll();
            
            setConstraints(0,0,1,TOP_MAX,1,1);
            add(placeHolder, cons);

            setConstraints(0,1,1, BOT_MIN, 1, 1);
            add(soundsPanel,cons);     
            
            isUp=false;          
            soundsPanel.setVisible(false);
            
            this.revalidate();
            this.repaint();
    }    
            
    /**
     * Removes everything from the panel and adds it again with the new layout to simulate the animation.
     */
    class SlideUp implements ActionListener{      
        public void actionPerformed(ActionEvent e) {
            if(looped>=SMOOTHED_DIFFERENCE){
                t.stop();
                
                return;
            }
                        
            looped++;
            
            topSize-=SMOOTHED_CHANGE_RATE;
            botSize+=SMOOTHED_CHANGE_RATE;                
            
            removeAll();
            
            setConstraints(0,0,1,topSize,1,1);
            add(placeHolder, cons);

            setConstraints(0,1,1, botSize, 1, 1);
            add(soundsPanel,cons);            
            
            revalidate();
            repaint();
        }        
    }

}
