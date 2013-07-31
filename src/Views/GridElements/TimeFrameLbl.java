/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Views.GridElements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Group 21
 */
public class TimeFrameLbl extends JLabel implements MouseListener{
    private Image image;    
    private Color strokeColor;
    
    public TimeFrameLbl() {
        addMouseListener(this);
        image= new ImageIcon(getClass().getResource("/resources/images/squareRed.png")).getImage();;
        strokeColor=null; 
    }

    
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(image, 0, 0, getWidth(), getHeight(),this);        
        
        g2d.setColor(strokeColor);
        g2d.drawRect(0, 0, this.getWidth(), this.getHeight());
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        
        strokeColor=Color.white;
        repaint();
    }

    public void mouseExited(MouseEvent e) {     
        strokeColor=null;
        repaint();
    }

}
