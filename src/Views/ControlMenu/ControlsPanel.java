package Views.ControlMenu;


import Views.ControlMenuElements.KnobWrapper;
import Views.ControlMenuElements.MeterLabel;
import Views.Novel.MainMenuPanel.Slider;
import Views.SoundPanel.ImagePanel;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import utils.ResourceLoader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author IgIz
 */
public class ControlsPanel extends ImagePanel{
     private Image img ;
     private KnobWrapper pitch;
     private KnobWrapper tone;
     private Slider volume;
     private MeterLabel volumeMeter;
     private Logo logo = new Logo("Logo.png");
     private GridBagConstraints cons = new GridBagConstraints();
     //private SamplePlayer sp = new SamplePlayer(ac, sample);
     
     
        public ControlsPanel() {
            super(utils.ResourceLoader.loadImage("controlsBackground.png"));
            setLayout(new GridBagLayout());
            setUpConstraints();
            setUpAll();
            
            JPanel pnl = new JPanel(new GridLayout(1,1));
            pnl.setOpaque(false);
            pnl.setBorder(new EmptyBorder(20,0,logo.getHeight()/5,logo.getWidth()/10));
            pnl.add(logo);
            setConstraints(0, 0, 0.25, 1, 1, 1);
            add(pnl,cons);
            
            JPanel panel = new JPanel(new GridLayout(1,1));
            panel.setOpaque(false);
            panel.setBorder(new EmptyBorder(12, 0, 4, 0));
            panel.add(volume);
            setConstraints(1, 0, 0.5, 1, 1, 1);
            add(panel,cons);
            
            setConstraints(2, 0, 0.125, 1, 1, 1);
            JPanel panel2 = new JPanel(new GridLayout(1,1));
            panel2.setOpaque(false);
            panel2.setBorder(new EmptyBorder(12, 0, 6, 0));
            panel2.add(volumeMeter);
            add(panel2,cons);
            
            setConstraints(3, 0, 0.125, 1, 1, 1);
            add(pitch,cons);
        }
        
        /**
         * Creates all the required elements needed for the control panel such as the pitch knob,volume slider,meter label and so on.
         */
        private void setUpAll(){
            pitch = new KnobWrapper(ResourceLoader.loadImage("indicator.png"),ResourceLoader.loadImage("knob.png"),"low","high","Pitch");
            tone = new KnobWrapper(ResourceLoader.loadImage("indicator.png"),ResourceLoader.loadImage("knob.png"),"low","high","Tone");
            volume = new Slider(ResourceLoader.loadImage("slider.png"),ResourceLoader.loadImage("vol.png"),"L","H","Volume");
            volumeMeter = new MeterLabel(ResourceLoader.loadImage("meterLabel.png"),"%");
            volume.addMeter(volumeMeter);
        }
         
        
        /**
         * Method for setting the default constraings for gridbag
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
      * Explained elsewhere ,helper method for calculating gridbag constraints
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
     * The class for making an expandable logo.
     */
    class Logo extends JLabel{
        Image img;
        public Logo(String img){
            this.img = ResourceLoader.loadImage(img);
        }
        
        @Override
        public void paintComponent(Graphics g){
            Graphics2D g2 = (Graphics2D)g;
            g2.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
    
}
