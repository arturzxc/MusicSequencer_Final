package Views.MainMenuPanels;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
import javax.swing.plaf.basic.BasicSliderUI;


/**
 *Slider is a Custom made slider. It is used for a volume control slider.
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
    
    /**
     * The slider is setup and a motion listener is added so that the knob returns a value when dragged.
     * @param img image of the actual slider
     * @param img2 image of the knob of the slider
     * @param ind1 index to the left of the slider
     * @param ind2 index to the right of the slider
     * @param text text under the slider
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
        

        setLayout(null);
        this.setOpaque(false);
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        Image img = this.slider;
        Image img2 = this.knob;
        
        int componentH = this.getHeight()-20;
        
        int sliderW = this.getWidth()-20;
        
        int scale = 87;
        
       int knobW = 46 *(this.getWidth()/87);
        if(knobW == 0)knobW = 46;
                
        this.knobWidth = knobW;
        
        g2.drawImage(img, 20, 20, sliderW-20, componentH-20, this);
        /**
         * If else statement checking the current position of the knob. Depending on that the components are painted according to the position.
         * When dragged, the position of the knob changes and it needs to be repainted appropriately, so it doesn't go out of bounds and it doesn't return wrong position.
         */
        if(position == 0)
            g2.drawImage(img2 , 60, 20, knobW-40, componentH-20, this);
        else
            g2.drawImage(img2,(position-(knobW/2))+20, 20, knobW-40, componentH-20, this);
            g2.setColor(Color.white);
            g2.setFont(new Font("AR CENA",Font.BOLD,(this.getHeight()+this.getWidth())/19));
            g2.drawString(ind1, 5, 20);
            g2.drawString(ind2, this.getWidth()-15, 20);
            g2.drawString(text, (this.getWidth()/2)-40, this.getHeight()-5);
        
    }
    
    public int getValue(){
        return value;
    }

    /**
     * mouseDragged calculates the position of the knob and repaints it according to it.
     * @param e 
     */
    @Override
    public void mouseDragged(MouseEvent e) {
       if(!(e.getX()+(knobWidth%2) <= (knobWidth/2))){
           if(!(e.getX()+(knobWidth%2) > this.getWidth()-(knobWidth/2))){
                float val = (float)e.getX()/this.getWidth();
                
                int temp = 0;
                if(!((int)val*100 < 25)){
                    temp = (int)val*100;
                }
                
                this.value = (int)(temp);
                position = e.getX();
                this.repaint();
           }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    
}
