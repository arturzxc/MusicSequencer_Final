package Views.ControlMenuElements;


import Models.Configs;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicSliderUI;
import utils.ResourceLoader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author IgIz
 */
public class Slider extends JLabel implements MouseMotionListener {
    
    private int sliderVal;
    private final Image slider;
    private final Image knob;
    private int position;
    private int value;
    private int knobWidth;
    private String ind1;
    private String ind2;
    private String text;
    private MeterLabel meter;
    
    public Slider(Image img,Image img2,String ind1,String ind2,String text){
        super();
        this.slider = img;
        this.knob = img2;
        this.addMouseMotionListener(this);
        this.position =0;
        this.value = 0;
        this.ind1 = ind1;
        this.ind2 = ind2;
        this.text = text;
        
        Dimension size = new Dimension(200,45);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(new FlowLayout());
        
    }
    /**
     * Overriden paint method to draw the slider and the knob.It also allows resizing by settings its width and height to the
     * area it is placed at.
     * @param g 
     */
    @Override
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        Image img = this.slider;
        Image img2 = this.knob;
        setBorder(new EmptyBorder(40, 0, 0, 0));
        int componentH = getHeight();
        
        int sliderW = getWidth()-20;
        
        int scale = 87;
        
        int knobW = 46 *(getWidth()/87);
        if(knobW == 0)knobW = 46;
                
        this.knobWidth = knobW;
        
        g2.drawImage(img, 20, 0,sliderW-20, componentH-20, this);
        
        if(position == 0)
        g2.drawImage(img2,20,0,knobW, componentH-20, this);
        else
        g2.drawImage(img2, (position-(knobW/2))+20,0,knobW-40, componentH-20, this);
        g2.setColor(Color.white);
        g2.setFont(new Font("AR CENA",Font.BOLD,15));
        g2.drawString(ind1, 5, 20);
        g2.drawString(ind2, this.getWidth()-14, 20);
        g2.drawString(text, (this.getWidth()/2)-40, this.getHeight()-5);
        
    }
    
    
    public int getValue(){
        return value;
    }
    /**
     * This is a method for attaching a meter label to the slider so it displays the value on
     * the meter label
     * @param meter 
     */
    public void addMeter(MeterLabel meter){
        this.meter = meter;
    }
    /**
     * Setter for volume
     * @param n 
     */
    private void setValue(int n){
        if(n < 25)
            this.value =0;
        else if (n>95)
            this.value = 100;
        else
            this.value = n;
        
        if(meter!=null)
        this.meter.setValue(this.getValue());
        //mseq.Mseq.model.getPlayer().setVolume(this.getValue());
    }
    /**
     * This is catches the mouseDragged event to calculate the new value of the slider and give slider
     * like feel for the component.It also doesn't allow the knob to escape its axes.It uses various algorithms to
     * calculate the given value inbetween 0 to 100.
     * @param e 
     */
    @Override
    public void mouseDragged(MouseEvent e) {
       if(!(e.getX()+(knobWidth%2) <= (knobWidth/2))){
           if(!(e.getX()+(knobWidth%2) > this.getWidth()-(knobWidth/2))){
                int val = (int)e.getX()/this.getWidth();
                
                int min = 47;
                float max = this.getWidth()-knobWidth;
                float realValue = e.getX()-47;
                float value2 = (float)(realValue/max)*100;
                this.setValue((int)value2);
                
                position = e.getX();
                this.repaint();
                mseq.Mseq.model.getPlayer().setVolume(value);
           }
        }
    }
    

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
