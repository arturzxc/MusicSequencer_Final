package Views.ControlMenuElements;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import utils.ResourceLoader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author IgIz
 */
public class KnobWrapper extends JLabel {
    private Knob knob;
    private String ind1;
    private String ind2;
    private String text;
    
    public KnobWrapper(Image img1,Image img2,String ind1,String ind2,String text){
        this.knob = new Knob(img1,img2); 
        this.ind1 = ind1;
        this.ind2 = ind2;
        this.text = text;
        this.setLayout(null);
        Dimension size = new Dimension(120, 80);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        knob.setBounds(15,8,60,48);
        this.add(knob);
        this.setOpaque(false);
        this.repaint();
    }
    
    @Override
    public void paintComponent(Graphics g2){
        Graphics2D g = (Graphics2D)g2;
        g2.setColor(Color.white);
        g2.setFont(new Font("AR CENA",Font.BOLD,16));
        g2.drawString(text, 75, 35);
        g2.setFont(new Font("AR CENA",Font.BOLD,10));
        g2.drawString(ind1, 5, 65);
        g2.drawString(ind2, 63, 65);
        this.repaint();
    }
    
}
