package Views.MainMenuPanels;


import Models.SequencePlayer;
import Models.Sound;
import Views.GridElements.FrameLbl;
import Views.SoundPanelElements.SoundIcon;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;
import utils.ResourceLoader;

/**
 *SoundsPanel is one of the three panels that are held in CurrentPanel and are interchanged when one of the buttons in Toolbar JPanel.
 * The layout of the panel is GridLayout.(1 row, 5 columns)
 * It consist of 5 CustomButtons that represent the 5 different sounds that can be played on the sequencer.
 * @author Group 21
 */
public class SoundsPanel extends JLabel implements MouseListener {

    
    private CustomButton synthBtn;
    private CustomButton pianoBtn;
    private CustomButton drumsBtn;
    private CustomButton bassBtn;
    private CustomButton guitarBtn;
    private String[] icons = {"SynthSoundIcon.png","PianoSoundIcon.png","DrumsSoundIcon.png","GuitarSoundIcon.png","BassSoundIcon.png"};
    private String[] squares = {"squareRed.png","squareYellow.png","squareCyan.png","squareBrown.png","squareGreen.png"};
    
    /**
     * The buttons are directly added to the parent panel and mouseListeners are attached to them.
     */
    public SoundsPanel()
    {
              
        setLayout(new GridLayout(1,5));       
       
           synthBtn = new CustomButton(ResourceLoader.loadImage("synthIcon.png"));
            synthBtn.addMouseListener(this);
            
            add(synthBtn); 
            //*******************************************************************
           pianoBtn = new CustomButton(ResourceLoader.loadImage("pianoIcon.png"));
            pianoBtn.addMouseListener(this);
               

            add(pianoBtn);  
            //*******************************************************************

           drumsBtn = new CustomButton(ResourceLoader.loadImage("drumsIcon.png"));
            drumsBtn.addMouseListener(this);            
    
            add(drumsBtn);  

            //*******************************************************************

           bassBtn = new CustomButton(ResourceLoader.loadImage("bassIcon.png"));     
            bassBtn.addMouseListener(this);
           
   
            add(bassBtn);              
            
            //*******************************************************************

            guitarBtn = new CustomButton(ResourceLoader.loadImage("guitarIcon.png"));
            guitarBtn.addMouseListener(this);

            add(guitarBtn);       
    }

    @Override
    public void mouseClicked(MouseEvent e) {;
    }
    /**
     * MousePressed method is overridden. It consists of an if else statement checking the source of the MouseEvent.
     * If the source is matched to a button, the corresponding action is performed. i.e. adding sounds to the timeline.
     * The images of the icons and the colour squares corresponding are stored in String arrays.
     * @param e 
     */
    @Override
    public void mousePressed(MouseEvent e) {        
      String image = "";
      Sound s = null;
      String square = "";
      
      if(e.getSource() == synthBtn){
        s = mseq.Mseq.model.getPlayer().addSound("Synth");
        image = icons[0];
        square = squares[0];
      }
      else if(e.getSource() == pianoBtn){
        s = mseq.Mseq.model.getPlayer().addSound("Piano");
        image = icons[1];
        square = squares[1];
      }
      else if(e.getSource() == drumsBtn){
        s = mseq.Mseq.model.getPlayer().addSound("Drums");
        image = icons[2];
        square = squares[2];
      }
      else if(e.getSource() == bassBtn){
        s = mseq.Mseq.model.getPlayer().addSound("Bass");
        image = icons[4];
        square = squares[4];
      }
      else if(e.getSource() == guitarBtn){
       s = mseq.Mseq.model.getPlayer().addSound("Guitar");
        image = icons[3];
        square = squares[3];
      }
      if(s != null){
         ArrayList<FrameLbl> framesInRow = mseq.Mseq.view1.getContentPnl().getGridPanel().getFramesInRow(s.getID());
         
         for(FrameLbl frame:framesInRow){
             frame.setSquare(square);
         }
         
        mseq.Mseq.view1.getContentPnl().getSoundPnl().addSound(new SoundIcon(ResourceLoader.loadImage(image),s ));
      }}

    @Override
    public void mouseReleased(MouseEvent e) {;}

    @Override
    public void mouseEntered(MouseEvent e) {;}

    @Override
    public void mouseExited(MouseEvent e) {;}
    
        /** 
         * The background of the panel is set
         */
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(ResourceLoader.loadImage("backGroundPanel.png"),0, 0, this.getWidth(), this.getHeight(), this);           

    }

    /** 
     * getters of the buttons, in case they need to be accessed.
     * @return 
     */
    public CustomButton getBassBtn() {
        return bassBtn;
    }

    public CustomButton getDrumsBtn() {
        return drumsBtn;
    }

    public CustomButton getGuitarBtn() {
        return guitarBtn;
    }

    public CustomButton getPianoBtn() {
        return pianoBtn;
    }

    public CustomButton getSynthBtn() {
        return synthBtn;
    }
        
                
}
