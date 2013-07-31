package Views.MainMenuPanels;

import Models.Configs;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import mseq.Mseq;
import utils.ResourceLoader;

/**
 * Class AdvancedPanel builds the advanced controls panel just below the main menu.
 * AdvancedPanel appears when Advanced button is clicked on MainMenu. 
 * It consists of buttons that would perform advanced features, such as copy,
 * paste, clear, pan control...
 * The layout of this panel is GridBagLayout, so the components are placed appropriately.
 * All buttons and sliders are custom made, so they are the same as in our design.
 * @author Group 21
 */

public class AdvancedPanel extends JPanel implements MouseListener {
    
        
   private JPanel sliderPnl;  // holds pan control slider
   
    private CustomButton copyBtn; // Custom made copy button
    private CustomButton pasteBtn;
    private CustomButton clearBtn;
    
    private CustomImageIcon timerComp; // Custom made image icon that represent where timer would be placed
    private CustomImageIcon equiComp; //Custom made image icon representing the equiliser 
       
    /**
     *The constructor sets up the whole panel. It is intended to show when the button "Advanced" on MainMenu is pressed.
     *The layout of the panel is GridBagLayout. We have used this layout because it is easier when positioning objects with different size and type.
     * In this panel there is one panel holding the custom made slider. The rest of the components are directly added to the parent panel using GridBagConstraints
     */
    public AdvancedPanel() 
    {   
        
        setLayout(new GridBagLayout()); //Layout of the panel holder   
        GridBagConstraints constr = new GridBagConstraints();//
        
        constr.weightx = 0.18;
        constr.weighty = 1;
       //******************************************************************
        /**
         * The first CustomImageIcon is a visual representation of the timer.
         * It is placed to the left of all other components and it is not held in a JPanel container.
         * The component is added to the parent panel with GridBagConstraints.
         */
       timerComp = new CustomImageIcon("timerIcon.png");   
       
        constr.fill = GridBagConstraints.BOTH;         
        constr.gridx = 0;
        constr.gridy = 0;
        add(timerComp, constr);
       
       //******************************************************************
       /** 
        * The second, third and fourth components are CustomButtons added to the parent JPanel using GridBagConstraints again.
        * There are mouse listeners added to each button so an action can be performed when they are pressed.
        */
       copyBtn = new CustomButton(ResourceLoader.loadImage("copyIcon.png"));      
       constr.gridx = 1;
       constr.weightx = 0.14;
       constr.insets = new Insets(0,0,0,0);
       copyBtn.addMouseListener(this);
       add(copyBtn, constr);   
       
       
       pasteBtn = new CustomButton(ResourceLoader.loadImage("pasteIcon.png"));  
       constr.gridx = 2;
       constr.weightx = 0.14;
       pasteBtn.addMouseListener(this);
       add(pasteBtn, constr);
       
       
       clearBtn = new CustomButton(ResourceLoader.loadImage("clearIcon.png"));
       constr.gridx = 3;
       constr.weightx = 0.14;
       clearBtn.addMouseListener(this);
       add(clearBtn, constr);
      

       //*******************************************************************
       /**
        * The fifth component is a JPanel holding a custom made slider. The panel holder is initialised and the Custom slider is added.
        * Then the holder panel is added to the parent panel using GridBagConstraints.
        */
       sliderPnl = new JPanel(new GridLayout());    
       sliderPnl.setOpaque(false);
       sliderPnl.add(new Slider(ResourceLoader.loadImage("slider.png"), ResourceLoader.loadImage("vol.png"),"L","R", "PAN CONTROL"));
       
      
       constr.fill = GridBagConstraints.BOTH;
       constr.gridx = 4;  
       constr.weightx = 0.3;
       
       add(sliderPnl, constr);
       
       //*********************************************************************
       
       /**
        *The last component is a CustomImageIcon is a visual representation of how the equilizer would look 
        */
       equiComp = new CustomImageIcon("equiliserIcon.png");
       constr.fill = GridBagConstraints.BOTH;
       constr.gridx = 5;     
       constr.weightx = 0.20;
       constr.weighty = 1;
       equiComp.setOpaque(false);
       
       add(equiComp, constr);        
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {;
    }

    @Override
    public void mousePressed(MouseEvent e) {   
        if(e.getSource() == copyBtn)
         System.out.println("copy");      
      else if(e.getSource() == pasteBtn)
        System.out.println("select");
      else if(e.getSource() == clearBtn){}
        Mseq.view1.getContentPnl().getSoundPnl().clearSounds();
    }

    @Override
    public void mouseReleased(MouseEvent e) {;}

    @Override
    public void mouseEntered(MouseEvent e) {;}

    @Override
    public void mouseExited(MouseEvent e) {;}

     /**
      * The following method overrides the method painting the parent JPanel in order to be added a custom background picture.
      * @param g 
      */   
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(ResourceLoader.loadImage("backGroundPanel.png"),0, 0, this.getWidth(), this.getHeight(), this);           

    }

    /**
     * The following methods are getters of the buttons. The getters can be called from throughout the whole code so the buttons can be accessed
     * @return 
     */
    public CustomButton getClearBtn() {
        return clearBtn;
    }

    public CustomButton getCopyBtn() {
        return copyBtn;
    }

    public CustomImageIcon getEquiComp() {
        return equiComp;
    }

    public CustomButton getPasteBtn() {
        return pasteBtn;
    }

    public JPanel getSliderPnl() {
        return sliderPnl;
    }

    public CustomImageIcon getTimerComp() {
        return timerComp;
    }
    
}
