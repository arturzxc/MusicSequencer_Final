package Views.SoundPanelElements;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *A class for representing blank spaces in the SoundPanel as illustrated in the design as rectangles with no fill
 * but grey borders.
 * @author IgIz
 */
public class BlankIcon extends JLabel {
    private Image img = new ImageIcon("src/resources/images/blankIcon.png").getImage();
    public BlankIcon(){
        
    }
    
    @Override
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(img, 0, 0 ,this.getWidth(), this.getHeight(), this);
    }
    
}
