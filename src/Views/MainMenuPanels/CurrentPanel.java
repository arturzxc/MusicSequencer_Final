package Views.MainMenuPanels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *Current panel is a holder of three panels that are to be painted over each other on the same place.
 * The three panels are AdvancedPanel, SoundsPanel, MainMenuPanel. 
 * @author Group 21
 */
public class CurrentPanel extends JPanel {
    
        private AdvancedPanel advancedPnl;
        private SoundsPanel soundsPnl;
        private MainMenuPanel mainMenuPnl;
        
        /**
         * The constructor sets up the CurrentPanel that extends JPanel, initialises the three panels and adds the first one that 
         * will be painted when launching the program.
         */
        public CurrentPanel()
        {       
            setLayout(new GridLayout(1,1));
            advancedPnl = new AdvancedPanel();
            soundsPnl = new SoundsPanel();
            mainMenuPnl =  new MainMenuPanel();

            
           add(new SoundsPanel());   
           
        }
        /**
         * the following method replaces the panels when the corresponding buttons in MainMenu are pressed.
         * The buttons are represented with the passed String btn variable.
         * @param btn 
         */
        public void changePanel(String btn)
    {   
          this.removeAll();
        
          if(btn.equalsIgnoreCase("soundsBtn"))
             this.add(soundsPnl);      
          else if(btn.equalsIgnoreCase("advancedBtn"))
             this.add(advancedPnl);
          else if(btn.equalsIgnoreCase("menuBtn"))
             this.add( mainMenuPnl);    
          
          revalidate();
          repaint();           

      }

}
