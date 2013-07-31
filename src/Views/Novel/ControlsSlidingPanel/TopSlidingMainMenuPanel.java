
package Views.Novel.ControlsSlidingPanel;

import Views.MainMenuPanels.MainMenuPanel;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JPanel;

/**
 *
 * @author Group 21
 * 
 * This is a wrapper class for the control panel. 
 * its purpose is to simulate animation of sliding up/down when clicking the controlls button.
 */
public class TopSlidingMainMenuPanel  extends JPanel{
    
    private GridBagConstraints cons;
    private JPanel placeHolderTop=new JPanel();
    private JPanel placeHolderBot=new JPanel();
    private MainMenuPanel mainMenuPanel;    
    private boolean isDown;
    
    
    private final int DELAY=1;        
    private final double SMOOTHNES=200;   
    private final double CHANGE_RATE=1;        
    private final double DIFFERENCE = 0.14;

    
    private final double TOP_MAX = 0.13;
    private final double MID_MIN = 0.01;
    private final double BOT_MAX = 0.86; 
    
    private final double SMOOTHED_CHANGE_RATE=CHANGE_RATE/SMOOTHNES;
    private final double SMOOTHED_DIFFERENCE=DIFFERENCE*SMOOTHNES;
          
    //Botom panel is slided down.
    
    private double midSize=MID_MIN;
    private double botSize=BOT_MAX;
    
    private int looped=0;
            
    private Timer t;

    /**
     * Default constructor.
     */
    public TopSlidingMainMenuPanel(){
        setLayout(new GridBagLayout());
        setBackground(Color.green);     
        setOpaque(false);
        setUpConstraints();
        setUpAllPanels();
        
        setConstraints(0,0,1,TOP_MAX,1,1);
        add(placeHolderTop, cons);
        
        setConstraints(0, 1, 1, MID_MIN, 1, 1);
        add(mainMenuPanel,cons);
        
        setConstraints(0, 2, 1, BOT_MAX, 1, 1);
        add(placeHolderBot,cons);
        
    }
    
    /**
     * Set up constraints
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
     * Helper method for setting up the layout.
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
     * set up all panels
     */
    private void setUpAllPanels(){
        placeHolderTop = new JPanel();
        placeHolderTop.setOpaque(false);
        
        mainMenuPanel = new MainMenuPanel();
        mainMenuPanel.setVisible(false);
        
        placeHolderBot = new JPanel();
        placeHolderBot.setOpaque(false);        
    }
    
    /**
     * Run the animation using Timer
     */
    public void slide(){
        if(!isDown){            
            mainMenuPanel.setVisible(true);            
            isDown=true;
            looped=0;
            t=new Timer(DELAY, new SlideDown()); 
            t.start();
        }else{
            midSize=MID_MIN;
            botSize=BOT_MAX; 
            isDown=false;
            slideUp();
            mainMenuPanel.setVisible(false);
            
        }
    }
    
    /**
     * Removes everything from the panel and adds it again with the new layout to simulate the animation.
     */
    private void slideUp(){
        removeAll();
            
        setConstraints(0,0,1,TOP_MAX,1,1);
        add(placeHolderTop, cons);
        
        setConstraints(0, 1, 1, MID_MIN, 1, 1);
        add(mainMenuPanel,cons);
        
        setConstraints(0, 2, 1, BOT_MAX, 1, 1);
        add(placeHolderBot,cons);  
            
        isDown=false;          
        mainMenuPanel.setVisible(false);

        this.revalidate();
        this.repaint();
    }  
    
    
    /**
     * Removes everything from the panel and adds it again with the new layout to simulate the animation.
     */
    class SlideDown implements ActionListener{      
        public void actionPerformed(ActionEvent e) {
            if(looped>=SMOOTHED_DIFFERENCE){
                t.stop();                
                return;
            }
                        
            looped++;
            
            midSize+=SMOOTHED_CHANGE_RATE;
            botSize-=SMOOTHED_CHANGE_RATE;                
            
            removeAll();
            
            setConstraints(0,0,1,TOP_MAX,1,1);
            add(placeHolderTop, cons);

            setConstraints(0, 1, 1, midSize, 1, 1);
            add(mainMenuPanel,cons);

            setConstraints(0, 2, 1, botSize, 1, 1);
            add(placeHolderBot,cons);            
            
            revalidate();
            repaint();
        }        
    }
        
}
