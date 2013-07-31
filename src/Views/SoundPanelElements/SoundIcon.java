package Views.SoundPanelElements;

import Models.Sound;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/*
 * The class for wrapping the sound.This is a view representation of sound in the sequencer known as SoundIcon
 */

/**
 *
 * @author group_21
 */
public class SoundIcon extends JLabel {
    private Image img;
    private SoundIcon instance;
    private Sound sound;
    private JMenuItem mute = new JMenuItem("Mute");
    private JMenuItem remove = new JMenuItem("Remove");
    private boolean selected = false;
    
    private boolean muted;
    private JPopupMenu popup = new JPopupMenu();
    
    /**
     * Default constructor,attaches remove and mute popup menu to the icon as-well as wraps the given sound
     * 
     * @param img
     * @param snd 
     */
    
    public SoundIcon(Image img,Sound snd){
         this.sound = snd;
         this.img = img;
         this.muted = false;
         
         int id = sound.getID();
        
         
         popup.add(mute);
         popup.add(remove);
         
         ActionListener al = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
             if(e.getSource() == mute){
                 System.out.println("Muting sound");
                if(muted == false){
                    ((JMenuItem)e.getSource()).setText("Un-mute");
                    muted = true;
                    sound.muteSound();
                    instance.repaint();
                }
                else{
                       muted = false;
                       ((JMenuItem)e.getSource()).setText("Mute");
                       sound.unmuteSound();
                       instance.repaint();
                    }
             }
             else if (e.getSource() == remove){
                 if(mseq.Mseq.type.equals(("conventional"))){
                      mseq.Mseq.view1.getContentPnl().getSoundPnl().removeSound(instance);
                 }
                 else{
                     mseq.Mseq.view2.getDragPanel().removeSound(instance);
                 }
                 sound.remove();
             }
        }};
         instance = this;
         mute.addActionListener(al);
         remove.addActionListener(al);
         this.addMouseListener(new PopupListener());    
    }
    /**
     * Getter for the sound it holds
     * @return 
     */
    public Sound getSound(){
        return sound;
    }
    /**
     * Getter for whether this icon is selected
     * @return 
     */
    public boolean getSelected(){
        return selected;
    }
    /**
     * Paint method for the SoundIcon which draws the image according to the size it needs to be,also displays its state
     * in terms of on or off.
     * @param g 
     */
    @Override
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;        
        g2.setFont(new Font("AR CENA",Font.BOLD,((getWidth()/6)+(getHeight()/6))));
        
        g2.drawImage(img, 0, 0 ,this.getWidth(), this.getHeight(), this);
        if(muted){
            g2.setColor(Color.RED);
            g2.drawString("Off", (int)(getWidth()/4), (int)(getHeight()/2));
        }else{
            g2.setColor(Color.GREEN);
            g2.drawString("On", (int)(getWidth()/4), (int)(getHeight()/2));
        }
        
        if(selected){
            g2.setColor(Color.yellow);
            g2.setStroke(new BasicStroke( 6, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
            g2.drawRect(0, 0, this.getWidth(), this.getHeight());
        }
    }
    /**
     * Class for creating right click popup on the SoundIcon,it checks whether the click was right click
     * and it then checks whether a sound is selected if not the it selects this sound by drawing a border around it.
     */
    class PopupListener extends MouseAdapter {
        @Override
    public void mousePressed(MouseEvent e) {
            maybeShowPopup(e);
            if(SwingUtilities.isLeftMouseButton(e)){
                if(!mseq.Mseq.model.getPlayer().hasSelected())
                {
                    if(selected == false)
                    {
                        mseq.Mseq.model.getPlayer().selectSound(sound);
                        selected = true;
                        repaint();
                     }
                }
                else
                {
                    if(mseq.Mseq.model.getPlayer().getSelected() == sound)
                    {
                        selected = false;
                        repaint();
                        mseq.Mseq.model.getPlayer().deselectSound(sound);
                      }
                }
                
            }
    }

        @Override
    public void mouseReleased(MouseEvent e) {
            maybeShowPopup(e);
    }
        /**
         * Method which checks if the popup was triggered,if so displays the right click pop-up
         * @param e 
         */
    private void maybeShowPopup(MouseEvent e) {
      if (e.isPopupTrigger()){
        popup.show(e.getComponent(),e.getX(),e.getY());
        return;
      }
    }
  }
    
}
