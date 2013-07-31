
package Views;

import Models.Configs;
import Views.ControlMenu.ControlsPanel;
import Views.GridElements.GridPnl;
import Views.GridElements.TimeLine;
import Views.MainMenuPanels.*;
import Views.SoundPanel.SoundPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author group 21
 * this is just a content pane of the main frame for the conventional design.
 */
public class ContentPnl extends JPanel{

    private GridBagConstraints cons;
    
    private GridPnl gridPnl;
    
    private MenuPanel menuPnl;
    private SoundPanel soundPnl;
    private CurrentPanel currentPnl;    
    private ControlsPanel controlPanel;
    private TimeLine timeLine = new TimeLine();

    public ContentPnl() {       
        
        setUpLayout();

        //gridx, gridy,
        //weightx, weighty, 
        //gridheight, gridwidth        
////////////////////////////////////////////////////////////////////////////////
        setConstraints(
                0, 0, 
                1, 0.1, 
                1, 2
                );
        setUpMenuPnl();
////////////////////////////////////////////////////////////////////////////////
        setConstraints(
                0, 1, 
                1, 0.2, 
                1, 2
                );
        setUpCurrentPnl();                
////////////////////////////////////////////////////////////////////////////////         
        setConstraints(
                0, 2, 
                0.15, 0.5, 
                1, 1
                );        
        setUpSoundPanel();
////////////////////////////////////////////////////////////////////////////////                
        setConstraints(
                1, 2, 
                0.85, 0.5, 
                1, 1
                );        
        setUpGridPnl();
////////////////////////////////////////////////////////////////////////////////                        
        setConstraints(
                0, 3, 
                1, 0.2, 
                1, 2
                );
        setUpControlPanel();
////////////////////////////////////////////////////////////////////////////////
    }

    /*
     * sets the GridBagLayout layout for this panel
     */
    private void setUpLayout(){
        setLayout(new GridBagLayout());
        cons=new GridBagConstraints();
        cons.anchor=GridBagConstraints.NORTHWEST;
        cons.fill=GridBagConstraints.BOTH;
    }
    
    /**
     * a helper method to position elements on the panel easier.
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
     * sets up menu panel
     */
    private void setUpMenuPnl(){        
        currentPnl=new CurrentPanel();
        
        menuPnl=new MenuPanel(currentPnl);        
        add(menuPnl, cons);
    }

    public SoundPanel getSoundPnl() {
        return soundPnl;
    }
    
    public GridPnl getGridPanel(){
        return gridPnl;
    }

    public void setCurrentPnl(CurrentPanel currentPnl) {
        this.currentPnl = currentPnl;
    }   
    
    
    private void setUpCurrentPnl(){
        
        add(currentPnl, cons);
    }

    /**
     * Sets up the sounds panel.  
     */
    private void setUpSoundPanel(){
        soundPnl = new SoundPanel();
        Insets original = cons.insets;
        
        cons.insets = new Insets(10,10,0,10);
        add(soundPnl, cons);
        
        cons.insets = original;
    }

    /**
     * sets up the grid and positions it in the correct place in this content panel.
     */
    private void setUpGridPnl(){
        gridPnl=new GridPnl();
        Insets original = cons.insets;
        
        cons.insets = new Insets(10,10,0,15);
        add(timeLine,cons);
        add(gridPnl, cons);
        cons.insets = original;
    }
    
    public TimeLine getTimeLine(){
        return timeLine;
    }
    
    /**
     * sets up the control panel and positions it in the correct place in this content panel.
     */
    private void setUpControlPanel(){
        controlPanel = new ControlsPanel();
        Insets original = cons.insets;
        
        cons.insets = new Insets(10,0,0,0);
        add(controlPanel, cons);
        
        cons.insets = original;
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        Image bg = new ImageIcon(getClass().getResource(Configs.IMAGE_PATH+"contenBackground.png")).getImage();
        g2d.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }





}
