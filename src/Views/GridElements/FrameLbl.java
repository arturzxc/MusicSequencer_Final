
package Views.GridElements;

import Models.Grid.Frame;
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
 * This is wrapper class for the Frame in the model package.
 */
public class FrameLbl extends JLabel implements MouseListener{
    private Image image;    
    private Color strokeColor;
    private Frame frame;
    private String square = "";
    private boolean isActive = false;
    
    public FrameLbl(Frame frame) {
        this.frame = frame;
        addMouseListener(this);
        image= null;
        strokeColor=Color.white; 
    }

    /**
     * paints the image of the frame. Frame label has 2 images. On to represent being active and one inactive.
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(image, 0, 0, getWidth(), getHeight(),this);        
        
        g2d.setColor(strokeColor);
        g2d.drawRect(0, 0, this.getWidth(), this.getHeight());
         
    }
    
    public void setStroke(Color str){
        strokeColor = str;
        repaint();
    }
    
    public void setSquare(String str){
        square = str;
        isActive = true;
    }
    
    public void reset(){
        isActive = false;
        square = "";
        image = null;
        frame.setOn(false);
    }
    
    /**
     * if on the it will play when the time line is over it.
     * @param val 
     */
    public void setOn(boolean val){
        frame.setOn(val);
        isActive = val;
        if(val && (!(square.trim().equals(("")))))
            image = new ImageIcon(getClass().getResource("/resources/images/"+square)).getImage();
        
        repaint();
        
    }
    
    public boolean getOn(){
        return frame.isOn();
    }

    
    public void setImage(String st){
        square = st;
        repaint();
    }
    
    public String getSquare(){
        return square;
    }
    
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * When pressed it will change the image to indicate being active.
     * If pressed again it will change the image back to the former one.
     * @param e 
     */
    public void mousePressed(MouseEvent e) {
        if(!frame.isOn() && isActive){
            image = new ImageIcon(getClass().getResource("/resources/images/"+square)).getImage();
            frame.setOn(true);
        }else{
            image= null;
            frame.setOn(false);
            frame.setOn(false);
        }
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        
        strokeColor=Color.GREEN;
        repaint();
    }

    public void mouseExited(MouseEvent e) {     
        strokeColor=Color.white;
        repaint();
    }

}
