package Views.MainMenuPanels;

import mseq.Mseq;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import utils.ResourceLoader;

/**
 *MenuPanel is placed to the north of all other panels. 
 * The layout of the panel is GridBagLayout. The panel holds three JPanels that hold all the components.
 * Every JPanel holds components with same context. E.g. audioContrPnl holds the play, stop and pause buttons.
 * saveOpenPnl holds save button and open button etc.
 * Only the meter label is not added to a holder panel, but is directly added to the parent panel.
 * 
 * @author Group 21
 */

public class MenuPanel extends JPanel implements MouseListener {
    
    protected CurrentPanel currentPnl;
    
    private int bpm = 120;
    private int actualBPM = 120;
    
    private JPanel audioContrPnl;
    private JPanel saveOpenPnl;
    private JPanel toolBarPnl;
    
    private CustomMenuButton playBtn;
    private CustomMenuButton stopBtn;
    private CustomMenuButton pauseBtn;
    
    private CustomMenuButton plusBpmBtn;
    private MeterLabel bpmContrLbl;
    private CustomMenuButton minusBpmBtn;
        
    private CustomMenuButton saveBtn;
    private CustomMenuButton openProjectBtn;
    
    private CustomMenuButton soundsBtn;
    private CustomMenuButton advancedBtn;
    private CustomMenuButton simpleBtn;
    private CustomMenuButton menuBtn;   
    /**
     * The constructor sets up the MenuPanel. It takes CurrentPanel as an argument, in order to be able to replace the three panels within CurrentPanel
     * @param currentPnl 
     */
    public MenuPanel(CurrentPanel currentPnl)
    {    
        this.currentPnl=currentPnl;
        
        setLayout(new GridBagLayout());        
        GridBagConstraints constr = new GridBagConstraints();
        constr.fill = GridBagConstraints.BOTH; 
       
        //AUDIO CONTROL PANEL**************************************************  
        /**
         * CustomMenuButtons are initialised and added to the audioControlPanel, which is later added to the parent panel
         * There are mouseListeners added to each button so an action can be performed when they are pressed
         */
        audioContrPnl = new JPanel();
        audioContrPnl.setLayout(new GridLayout(0,3));         
                         
        playBtn = new CustomMenuButton(ResourceLoader.loadImage("playIcon.png"));   
        playBtn.addMouseListener(this);
        audioContrPnl.add(playBtn);
        
        stopBtn = new CustomMenuButton(ResourceLoader.loadImage("stopIcon2.png"));  
        stopBtn.addMouseListener(this);
        audioContrPnl.add(stopBtn);
        
        pauseBtn = new CustomMenuButton(ResourceLoader.loadImage("pauseIcon.png")); 
        pauseBtn.addMouseListener(this);
        audioContrPnl.add(pauseBtn);
        
  
        constr.weighty = 1;
        constr.weightx = 0.20;
        constr.gridx = 0;
        constr.gridy = 0;
        
        audioContrPnl.setOpaque(false);
        add(audioContrPnl, constr); 
         
        //BPM CONTROLS****************************************************
        /**
         * BPM control buttons are directly added to the parent panel using GridBagConstraints.
         * There added mouseListeners to all buttons so action can be performed when pressed
         */
        constr.weightx = 0.05;
        constr.gridx = 1;
        constr.gridy = 0;
        
        minusBpmBtn = new CustomMenuButton(ResourceLoader.loadImage("minusIcon.png"));
        minusBpmBtn.addMouseListener(this);
        minusBpmBtn.setOpaque(false);
        add(minusBpmBtn, constr);
        
       /**
        * MeterLabel is a custom made JLabel that visualises the actual value of BPM.
        */
        bpmContrLbl = new MeterLabel(ResourceLoader.loadImage("meterLabel.png"),"bpm");           
        constr.weightx = 0.10;
        constr.gridx = 2;
        bpmContrLbl.setValue(bpm);
        bpmContrLbl.setOpaque(false);
                
       add(bpmContrLbl, constr);
        
        plusBpmBtn = new CustomMenuButton(ResourceLoader.loadImage("plusIcon.png"));      
        plusBpmBtn.addMouseListener(this);        
        constr.weightx = 0.05;
        constr.gridx = 3;
        plusBpmBtn.setOpaque(false);
       add(plusBpmBtn, constr);        
        
         
        //SAVE OPEN PANEL ******************************************************
       /**
        * SaveOpenPnl holds the save and open buttons. It has GridLayout with empty borders around the whole panel and around the two buttons.
        * The panel is then added to the parent panel using GridBagConstraints.
        */
        saveOpenPnl = new JPanel();
        saveOpenPnl.setLayout(new GridLayout());   
        saveOpenPnl.setBorder(new EmptyBorder(2,2,2,2));
       
        
        saveBtn = new CustomMenuButton(ResourceLoader.loadImage("saveIcon.png"));    
        saveBtn.setBorder(new EmptyBorder(0,0,0,2));
        saveBtn.addMouseListener(this);
        saveOpenPnl.add(saveBtn);
         
        openProjectBtn = new CustomMenuButton(ResourceLoader.loadImage("openIcon.png"));        
        openProjectBtn.addMouseListener(this);
        openProjectBtn.setBorder(new EmptyBorder(0,2,0,0));
        saveOpenPnl.add(openProjectBtn);
        
        
        constr.weightx = 0.10;
        constr.gridx = 4;
        constr.gridy = 0;
        saveOpenPnl.setOpaque(false);
        
       add(saveOpenPnl, constr); 
        
        //TOOLBAR PANEL*********************************************************
       /**
        * ToolbarPanel holds 4 CustomMenuButtons that when pressed switch the lower panel to SoundsPanel, AdvancedPanel, MainMenuPanel and simple, where the whole panel is removed 
        * for a simpler view. The simpler view is not yet implemented because of issues of removing and re-adding CurrentPanel.
        */
        toolBarPnl = new JPanel();
        toolBarPnl.setLayout(new GridLayout());                   
           
        soundsBtn = new CustomMenuButton(ResourceLoader.loadImage("soundsIcon.png"));             
        soundsBtn.addMouseListener(this);
        toolBarPnl.add(soundsBtn);
        
        advancedBtn = new CustomMenuButton(ResourceLoader.loadImage("advancedIcon.png"));           
        advancedBtn.addMouseListener(this);
        toolBarPnl.add(advancedBtn);
           
        simpleBtn = new CustomMenuButton(ResourceLoader.loadImage("simpleIcon.png"));          
        simpleBtn.addMouseListener(this);
        toolBarPnl.add(simpleBtn);
        
        menuBtn = new CustomMenuButton(ResourceLoader.loadImage("menuIcon.png"));        
        menuBtn.addMouseListener(this);
        toolBarPnl.add(menuBtn);
        
        constr.weightx = 0.50;
        constr.gridx = 5;
        constr.gridy = 0;
        toolBarPnl.setOpaque(false);
       add(toolBarPnl, constr);

    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
      if(e.getSource() == playBtn){
         Mseq.model.getPlayer().play();
         
      }
      else if(e.getSource() == stopBtn){
        Mseq.model.getPlayer().stop();
        
      }
      else if(e.getSource() == pauseBtn){
        Mseq.model.getPlayer().pause();
        
      }
      /**
       * The following two if else statements control BPM on the MenuPanel.
       * They represent the + and - buttons that increase and decrease the bpm
       * In both else else if statements the actual value passed to the model is controlled so it doesn't go out of logical bounds.
       * The value that is passed to the meter label is also controlled so it doesn't go in negative values for example.
       */
      else if(e.getSource() == minusBpmBtn)
      {     if(bpm-1<=0){;}
            
            else{
            bpm-=1;
            Mseq.view1.getContentPnl().getTimeLine().setSpeed(bpm);
            actualBPM+=1;
            bpmContrLbl.setValue(bpm);
            Mseq.model.getPlayer().setBPM(actualBPM);}
      }
      else if(e.getSource() == plusBpmBtn)
      {       
            if(bpm+1>238){;}
            else{
            bpm+=1;
            Mseq.view1.getContentPnl().getTimeLine().setSpeed(bpm);
            actualBPM-=1;
            bpmContrLbl.setValue(bpm);
            Mseq.model.getPlayer().setBPM(actualBPM);
            }
      }       
      else if(e.getSource() == saveBtn)      
        System.out.println("save");      
      else if(e.getSource() == openProjectBtn)      
        System.out.println("open");      
      else if(e.getSource() == saveBtn)      
        System.out.println("save");   
      else if(e.getSource() == soundsBtn)      
         currentPnl.changePanel("soundsBtn");
      else if(e.getSource() == advancedBtn) {
         currentPnl.changePanel("advancedBtn");
      }     
      else if(e.getSource() == simpleBtn) {     
          System.out.println("Simple panel");
      }
      else if(e.getSource() == menuBtn)      
         currentPnl.changePanel("menuBtn");
      else;
    }

    @Override
    public void mousePressed(MouseEvent e) {;}

    @Override
    public void mouseReleased(MouseEvent e) {;}

    @Override
    public void mouseEntered(MouseEvent e) {;}

    @Override
    public void mouseExited(MouseEvent e) {;}
    
    /**
     * The following method creates and returns an ImageIcon if the passed path points to an existing file.
     * @param path
     * @return 
     */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = MenuPanel.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    
    }
   /**
    * the following method sets a background to the holder panel
    * @param g 
    */ 
    @Override
     public void paintComponent(Graphics g)
        {
            Graphics2D g2d = (Graphics2D)g;
            g2d.drawImage(ResourceLoader.loadImage("MainMenuBackGround.png"),0, 0, this.getWidth(), this.getHeight(), this);          
        
        }
   /**
    * The following methods are getters of all the buttons so they can be accessed from where it is needed.
    * @return 
    */  
     public CustomMenuButton getPlayButton()
     {
     return playBtn;
     }

    public CustomMenuButton getAdvancedBtn() {
        return advancedBtn;
    }

    public int getBpm() {
        return bpm;
    }

    public MeterLabel getBpmContrLbl() {
        return bpmContrLbl;
    }

    public CustomMenuButton getMenuBtn() {
        return menuBtn;
    }

    public CustomMenuButton getMinusBpmBtn() {
        return minusBpmBtn;
    }

    public CustomMenuButton getOpenProjectBtn() {
        return openProjectBtn;
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

    public CustomMenuButton getSaveBtn() {
        return saveBtn;
    }
    public CustomMenuButton getSimpleBtn() {
        return simpleBtn;
    }

    public CustomMenuButton getSoundsBtn() {
        return soundsBtn;
    }

    public CustomMenuButton getStopBtn() {
        return stopBtn;
    }


}
