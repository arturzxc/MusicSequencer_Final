package Views.Novel;


import Views.MainMenuPanels.*;
import Models.SequencePlayer;
import Models.Sound;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import mseq.Mseq;
import utils.ResourceLoader;


/**
 *
 * @author Group 21
 */
public class SoundsPanel extends JLabel implements MouseListener {

    private CustomButton synthBtn;
    private CustomButton pianoBtn;
    private CustomButton drumsBtn;
    private CustomButton bassBtn;
    private CustomButton guitarBtn;
    private String[] icons = {"SynthSoundIcon.png","PianoSoundIcon.png","DrumsSoundIcon.png","GuitarSoundIcon.png","BassSoundIcon.png"};
    
    
    public SoundsPanel()
    {
      this.setBorder(new EmptyBorder(25, 0, 0, 0));
        setLayout(new GridLayout(0,5));       
       
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
            
    addMouseListener(new MouseAdapter() 
        {
            public void mousePressed(MouseEvent e)
                {
                   int width = getWidth();
                   int height = getHeight();

                   int mX = e.getX();
                   int mY = e.getY();

                   if( mX>width-width/15 && mY<height/3)  
                     Mseq.view2.getBotSlidingContentPane().slide();                  
                }
        }
                );
            
            
    }

    @Override
    public void mouseClicked(MouseEvent e) {    ;
    }
    
        protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = MenuPanel.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    
    }
        
    public void paintComponent(Graphics g)
    {
     Graphics2D g2d = (Graphics2D)g;
     g2d.drawImage(ResourceLoader.loadImage("novelSoundsPanel.png"),0, 0, this.getWidth(), this.getHeight(), this);     
     }

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

    public void mousePressed(MouseEvent e) {String image = "";
      Sound s = null;
      Color color = null;
      
      if(e.getSource() == synthBtn){
        s = mseq.Mseq.model.getPlayer().addSound("Synth");
        image = icons[0];
        color = Color.RED;
      }
      else if(e.getSource() == pianoBtn){
        s = mseq.Mseq.model.getPlayer().addSound("Piano");
        image = icons[1];
        color = Color.YELLOW;
      }
      else if(e.getSource() == drumsBtn){
        s = mseq.Mseq.model.getPlayer().addSound("Drums");
        image = icons[2];
        color = Color.CYAN;
      }
      else if(e.getSource() == bassBtn){
        s = mseq.Mseq.model.getPlayer().addSound("Bass");
        image = icons[4];
        color = Color.GREEN;
      }
      else if(e.getSource() == guitarBtn){
       s = mseq.Mseq.model.getPlayer().addSound("Guitar");
        image = icons[3];
        color = Color.gray;
      }
    
      mseq.Mseq.view2.getDragPanel().addSound(new SoundIconDnD(ResourceLoader.loadImage(image),color,s));
    }

    public void mouseReleased(MouseEvent e) {;
    }

    public void mouseEntered(MouseEvent e) {;
    }

    public void mouseExited(MouseEvent e) {;
    }
        
                
}
