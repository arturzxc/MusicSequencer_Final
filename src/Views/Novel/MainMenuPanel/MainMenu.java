package Views.Novel.MainMenuPanel;

import Models.Configs;
import Views.MainMenuPanels.CustomButton;
import Views.MainMenuPanels.CustomMenuButton;
import Views.MainMenuPanels.ImagePanel;
import Views.Novel.EditMenu.EditMenu;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import mseq.Mseq;
import utils.ResourceLoader;

/**
 *MainMenu panel of the novel design. 
 * The layout of the panel is GridBagLayout, because there are components with different size to be added.
 * There are play, stop, pause CustomButtons that are held in pspPnl which is then added to the parent panel.
 * PspPanel has GridLayout(1row, 3 columns).
 * Controls, edit, combine, filemenu and sounds buttons are directly added to the parent panel.
 * Bpm controls and volume slider are held in slidersHolderPnl which is then added to the parent panel.
 * SlidersHolderPnl has a GridLayout(2rows, 1column).
 * @author Group 21
 */
public class MainMenu extends JLabel implements MouseListener {
    
    private int bpm = 120;
    private int actualBPM = 120;
    
    private ImagePanel pspPnl;
    private JPanel controlsPnl;
    private JPanel slidersHolderPnl;
    private JPanel bmpMeterLabel;
    private JPanel slider2;
    
    private CustomMenuButton playBtn;
    private CustomMenuButton stopBtn;
    private CustomMenuButton pauseBtn;
    
    private CustomButton controlsBtn;
    private CustomButton editBtn;
    private CustomButton combineBtn;
    private CustomButton filemenuBtn;
    private CustomButton soundsBtn;
    
    private CustomMenuButton plusBpmBtn;
    private MeterLabel bpmContrLbl;
    private CustomMenuButton minusBpmBtn;
    
    private Slider slider;
    /**
     * The Main menu is constructed, where the layout is set and all the buttons are 
     * initialised and added to their holder panels and then to the parent panel.
     */
    public MainMenu()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();
        
        cons.fill = GridBagConstraints.BOTH;
        cons.gridx = 0;
        cons.gridy = 0;
        cons.weightx =0.2;
        cons.weighty =1;
        
        /**
         * PlayStopPausePanel.******************************************************************
         */
        pspPnl = new ImagePanel(Configs.IMAGE_PATH+"pspBackgroundNovel.png");
        pspPnl.setLayout(new GridLayout(1, 3));
        playBtn = new CustomMenuButton(ResourceLoader.loadImage("playIcon.png"));
        playBtn.addMouseListener(this);
        playBtn.setOpaque(false);
        stopBtn = new CustomMenuButton(ResourceLoader.loadImage("stopIcon.png"));
        stopBtn.addMouseListener(this);
        stopBtn.setOpaque(false);
        pauseBtn = new CustomMenuButton(ResourceLoader.loadImage("pauseIcon.png"));
        pauseBtn.addMouseListener(this);
        pauseBtn.setOpaque(false);
        
        pspPnl.add(playBtn);
        pspPnl.add(stopBtn);
        pspPnl.add(pauseBtn);
        
        
        add(pspPnl, cons);
        
        /**
         * ControlsPanel.************************************************************************
         */
         controlsPnl = new JPanel(new GridLayout(1, 5)); 
         controlsBtn = new CustomButton(ResourceLoader.loadImage("controlsNovelcon.png"));
         controlsBtn.addMouseListener(this);
         controlsBtn.setOpaque(false);

         editBtn = new CustomButton(ResourceLoader.loadImage("editNovelIcon.png"));
         editBtn.setComponentPopupMenu(new EditMenu());         
         editBtn.addMouseListener(this);
         editBtn.setOpaque(false);
         
         combineBtn = new CustomButton(ResourceLoader.loadImage("combineNovelIcon.png"));
         combineBtn.addMouseListener(this);
         combineBtn.setOpaque(false);
         filemenuBtn = new CustomButton(ResourceLoader.loadImage("fileMenuNovelIcon.png"));
         filemenuBtn.addMouseListener(this);
         filemenuBtn.setOpaque(false);
         soundsBtn = new CustomButton(ResourceLoader.loadImage("soundsNovelIcon.png"));
         soundsBtn.addMouseListener(this);
         soundsBtn.setOpaque(false);

        
         controlsPnl.add(controlsBtn);
         controlsPnl.add(editBtn);
         controlsPnl.add(combineBtn);
         controlsPnl.add(filemenuBtn);
         controlsPnl.add(soundsBtn);
         
         cons.gridx = 1;
         cons.weightx =0.6;
         
         controlsPnl.setOpaque(false);
         
         add(controlsPnl, cons);
         
         /**
          * SlidersPanel.
          * Inside slidersHolderPnl there are two other panels.
          * One holds BPM meter and it has GRidBagLayout since the elements inside are of different size.
          * The other holds slider and it has GridLayout, since it holds only one element- the slider.
          */
          slidersHolderPnl = new JPanel(new GridLayout(2, 1));

            bmpMeterLabel = new JPanel(new GridBagLayout());
            bmpMeterLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
            GridBagConstraints sliCons = new GridBagConstraints();
            sliCons.fill = GridBagConstraints.BOTH;
            sliCons.gridy = 0;
            sliCons.gridx = 0;
            sliCons.gridwidth = 1;
            sliCons.weightx = 0.25;
            sliCons.weighty = 1;            
            
            minusBpmBtn = new CustomMenuButton(ResourceLoader.loadImage("minusIcon.png"));
            minusBpmBtn.addMouseListener(this);
            minusBpmBtn.setOpaque(false); 
            bmpMeterLabel.add(minusBpmBtn,sliCons);

            bpmContrLbl = new MeterLabel(ResourceLoader.loadImage("meterLabel.png"),"bpm");               
            bpmContrLbl.setValue(bpm);
            bpmContrLbl.setOpaque(false);
            sliCons.gridx = 1;
            sliCons.gridwidth =1;
            sliCons.weightx = 0.50;            
            bmpMeterLabel.add(bpmContrLbl,sliCons);

            plusBpmBtn = new CustomMenuButton(ResourceLoader.loadImage("plusIcon.png"));      
            plusBpmBtn.addMouseListener(this);
            plusBpmBtn.setOpaque(false);
            sliCons.gridx = 2;
            sliCons.gridwidth = 1;
            sliCons.weightx = 0.25;
            bmpMeterLabel.add(plusBpmBtn, sliCons);
        
            
            slider = new Slider(ResourceLoader.loadImage("slider.png"), ResourceLoader.loadImage("vol.png"), "", "", "");
            slider2 = new JPanel(new GridLayout(1,1)); 
            slider2.setOpaque(false);
            slider2.add(slider);
             
            bmpMeterLabel.setOpaque(false);
            slidersHolderPnl.add(bmpMeterLabel);
            slider2.setOpaque(false);
            slidersHolderPnl.add(slider2);             
            slidersHolderPnl.setOpaque(false);
            
            
            cons.gridx = 2;
            cons.weightx =0.2;
         
            add(slidersHolderPnl, cons);           
            setOpaque(false);
    
    }

    /**
     * Overridden MouseListener methods.
     * Currently only MouseClicked is used.
     * When clicked each button performs an action. E.g. play, stop or pause the sound.
     * @param e 
     */
    public void mouseClicked(MouseEvent e) {;
    }

    public void mousePressed(MouseEvent e) {
             if(e.getSource() == playBtn){
         mseq.Mseq.view2.getDragPanel().startTimeline();
         Mseq.model.getPlayer().play();
      }
      else if(e.getSource() == stopBtn){
         mseq.Mseq.view2.getDragPanel().stopTimeLine();
         Mseq.model.getPlayer().stop();
      }
      else if(e.getSource() == pauseBtn){
         mseq.Mseq.view2.getDragPanel().pauseTimeLine();
         Mseq.model.getPlayer().stop();
      }
      /**
       * The following two if else statements control BPM on the MenuPanel.
       * They represent the + and - buttons that increase and decrease the bpm
       * In both else else if statements the actual value passed to the model is controlled so it doesn't go out of logical bounds.
       * The value that is passed to the meter label is also controlled so it doesn't go in negative values for example.
       */
      else if(e.getSource() == minusBpmBtn)
      {    
            if(bpm-1<=0){;}            
            else{         
            bpm-=1;
            actualBPM+=1;
            bpmContrLbl.setValue(bpm);
            Mseq.model.getPlayer().setBPM(actualBPM);
            }
      }
      else if(e.getSource() == plusBpmBtn)
      {     
            if(bpm+1>238){;}
            else{          
            bpm+=1;
            actualBPM-=1;
            bpmContrLbl.setValue(bpm);
            Mseq.model.getPlayer().setBPM(actualBPM);
            }
      }       
      else if(e.getSource() == controlsBtn)      
        System.out.println("constrols");      
      else if(e.getSource() == editBtn){
            try {
                //Popup menu can only be displayed on right click of mouse therefore we simulate left click using Robot class.
                Robot robot = new Robot();
                // RIGHT CLICK
                robot.mousePress(InputEvent.BUTTON3_MASK);
                robot.mouseRelease(InputEvent.BUTTON3_MASK);
            } catch (Exception exe) {
                System.out.println("error=" + exe);
            }
      }               
      else if(e.getSource() == combineBtn)      
        System.out.println("combine");   
      else if(e.getSource() == filemenuBtn){
          Mseq.view2.getTopSlidingContentPane().slide();
      }             
      else if(e.getSource() == soundsBtn)      
       Mseq.view2.getBotSlidingContentPane().slide();
      else;       
    }

    public void mouseReleased(MouseEvent e) {;
    }

    public void mouseEntered(MouseEvent e) {;
    }

    public void mouseExited(MouseEvent e) {;
    }
    /**
     * The background of the panel is painted.
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(ResourceLoader.loadImage("novelBackgroundMainMenuPanel.png"),0, 0, this.getWidth(), this.getHeight(), this);           

    }
    
    /** 
     * Public getters that return all the buttons in case needed in the Model. 
     * @return 
     */

    public CustomButton getCombineBtn() {
        return combineBtn;
    }

    public CustomButton getControlsBtn() {
        return controlsBtn;
    }

    public CustomButton getEditBtn() {
        return editBtn;
    }

    public CustomButton getFilemenuBtn() {
        return filemenuBtn;
    }

    public CustomMenuButton getMinusBpmBtn() {
        return minusBpmBtn;
    }

    public CustomMenuButton getPauseBtn() {
        return pauseBtn;
    }

    public CustomMenuButton getPlayBtn() {
        return playBtn;
    }

    public CustomMenuButton getPlusBpmBtn() {
        return plusBpmBtn;
    }

    public CustomButton getSoundsBtn() {
        return soundsBtn;
    }

    public CustomMenuButton getStopBtn() {
        return stopBtn;
    }
    
}
