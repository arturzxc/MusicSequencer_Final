package Views.ControlMenuElements;


import Models.Configs;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
import utils.ResourceLoader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author IgIz
 */
public class Knob extends JLabel implements MouseMotionListener{
    private Image img1;
    private Image img2;
    private int position;
    private int value;
    private double angle;
    private int limit;
    
    
    public Knob(Image img1,Image img2){
        this.img1 = img1;
        this.img2 = img2;
        this.value = 0;
        this.addMouseMotionListener(this);
        this.position = 0;
        this.limit = 100;
        this.angle = 2.45;
    }
    
    @Override
     public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        Image img = this.img1;
        Image img2Local = this.img2;
        //g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);
        g2.rotate(angle, this.getWidth()/2-2, this.getHeight()/2+2);
        g2.drawImage(img2Local,11,9,34,34,this);
        
    }
    
     public void setValueTo(int n){
         if(n != 0)
         this.limit = n;
     }

    @Override
    public void mouseDragged(MouseEvent e) {
        double temp = position - (e.getX()-e.getY()*3);
        double temp2 = Math.toRadians(temp);
        if(temp2 >= 0 && temp2 <=5){
            angle = temp2;
            this.value = (int)(20*angle);
            this.repaint();
            
            double pitch = ((50-value)/4.1)*-1;
            
            mseq.Mseq.model.getPlayer().setPitch((int)pitch);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
    
}
