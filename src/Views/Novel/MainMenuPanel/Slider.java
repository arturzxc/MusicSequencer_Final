package Views.Novel.MainMenuPanel;


import Views.ControlMenuElements.MeterLabel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicSliderUI;

/**
 *The slider is reused and tweaked to fit the dimensions of the novel design again.
 * Some dimensions are fixed so the slider fits in a smaller container.
 * It extends JLabel and implements MouseMotionListener in order to simulate sliding of the knob.
 * @author IgIz
 */
public class Slider extends JLabel implements MouseMotionListener {
   
    private final Image slider;
    private final Image knob;
    private int position;
    private int value;
    private int knobWidth;
    private String ind1;
    private String ind2;
    private String text;
    private MeterLabel meter;
    
    /**
     * Constructor takes5 arguments:
     * @param img image of the slider
     * @param img2 image of the knob
     * @param ind1 left index
     * @param ind2 right index
     * @param text text written under the slider.
     * In this case the last 3 arguments are not used, because there is no space for them.
     * They can always be added.
     */
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
        
    }
    
    @Override
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        Image img = this.slider;
        Image img2 = this.knob;
        setBorder(new EmptyBorder(40, 0, 0, 0));
        int componentH = getHeight()-10;        
        int sliderW = getWidth()-20;        
        int knobW = 46 *(getWidth()/87);
        if(knobW == 0)knobW = 46;
                
        this.knobWidth = knobW;
        /**
         * The Slider is painted on x=10, y=5, with width 20 less than the width of the parent, and height 10 less than the height of the parent.
         */
        g2.drawImage(img, 10, 5,sliderW, componentH, this);
        
    
        /**
         * The knob is drawn, again, depending on the position, so it doesn't go out of bounds when repainted.
         */
        if(position == 0)
        g2.drawImage(img2,10,5,knobW-20, componentH, this);
        else
        g2.drawImage(img2, (position-(knobW/2))+10,5,knobW-20, componentH, this);
        g2.setColor(Color.white);
        
    }
    /**
     * Returns the actual value of the volume.
     * @return 
     */
    public int getValue(){
        return value;
    }
    /**
     * Used to add a MeterLabel that is updated with the volume value.Not used in this case.
     * @param meter 
     */
    public void addMeter(MeterLabel meter){
        this.meter = meter;
    }
    /**
     * Sets the value of the volume, which is can also be passed to the MeterLabel.
     * @param n 
     */
    private void setValue(int n){
        if(n < 7)
            this.value =0;
        else if (n>95)
            this.value = 100;
        else
            this.value = n;
        
        if(meter!=null)
        this.meter.setValue(this.getValue());
      
    }
    /**
     * Implements the actual sliding, by calculating the position of the knob according to x and y of the MouseEven e.
     * The value is then passed to the model, where the volume is controlled.
     * @param e 
     */
    @Override
    public void mouseDragged(MouseEvent e) {
       if(!(e.getX()+(knobWidth%2) <= (knobWidth/2)))
       {
           if(!(e.getX()+(knobWidth%2) > this.getWidth()-(knobWidth/2))){

                float max = this.getWidth()-knobWidth;
                float realValue = e.getX()-22;
                float value2 = (float)(realValue/max)*100;
                
                if((int)value2 < 23)
                    value2 = 0;
                
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
