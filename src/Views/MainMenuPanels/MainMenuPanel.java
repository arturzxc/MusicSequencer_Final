package Views.MainMenuPanels;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import utils.ResourceLoader;

/**
 *MainMenuPanel is one of the three panels that are held and interchanged in current panel.
 * The layout of the panel is GridLayout.
 * It holds 7 custom buttons that are evenly spreaded on the parent panel.
 * @author Group 21
 */
public class MainMenuPanel extends JPanel implements MouseListener {
    
    /**
     * the custom buttons are declared
     */
    private CustomButton saveBigIcon;
    private CustomButton newBigIcon;
    private CustomButton openBigIcon;
    private CustomButton exportBigIcon;
    private CustomButton helpBigIcon;
    private CustomButton infoBigIcon;
    private CustomButton quitBigIcon;
    

    /**
     * The constructor sets up the panel by setting layout, initialising and adding the fore-mentioned custom buttons to the parent panel.
     * There are also mouseListeners added to each button so an action can be performed
     */
    public MainMenuPanel()
    {
    
         setLayout(new GridLayout());               
         
          saveBigIcon = new CustomButton(ResourceLoader.loadImage("saveBigIcon.png"));
          saveBigIcon.addMouseListener(this);

          add(saveBigIcon); 
          
             
          newBigIcon = new CustomButton(ResourceLoader.loadImage("newIcon.png"));
          newBigIcon.addMouseListener(this);
                        
          add(newBigIcon); 
        
          openBigIcon = new CustomButton(ResourceLoader.loadImage("openBigIcon.png"));
          openBigIcon.addMouseListener(this);
                
            
          add(openBigIcon); 
          
  
          exportBigIcon = new CustomButton(ResourceLoader.loadImage("exportIcon.png"));
          exportBigIcon.addMouseListener(this);
            
          add(exportBigIcon); 
          
          //***************************************************************************  
          
          helpBigIcon = new CustomButton(ResourceLoader.loadImage("helpIcon.png"));
          helpBigIcon.addMouseListener(this);            
            
          add(helpBigIcon); 
          
          infoBigIcon = new CustomButton(ResourceLoader.loadImage("infoIcon.png"));
          infoBigIcon.addMouseListener(this);
            

          add(infoBigIcon); 
          
          
           //***************************************************************************    
          quitBigIcon = new CustomButton(ResourceLoader.loadImage("quitIcon.png"));
          quitBigIcon.addMouseListener(this);
            

          add(quitBigIcon); 
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
      if(e.getSource() == saveBigIcon)
         System.out.println("save");      
      else if(e.getSource() == newBigIcon)
        System.out.println("new");
      else if(e.getSource() == openBigIcon)
        System.out.println("open");
      else if(e.getSource() == exportBigIcon)
        System.out.println("export");
      else if(e.getSource() == helpBigIcon)
        System.out.println("help");
      else if(e.getSource() == infoBigIcon)
        System.out.println("info"); 
      else if(e.getSource() == quitBigIcon)
        System.exit(0);
    }

    @Override
    public void mousePressed(MouseEvent e) {;    }

    @Override
    public void mouseReleased(MouseEvent e) {;   }

    @Override
    public void mouseEntered(MouseEvent e) {;    }

    @Override
    public void mouseExited(MouseEvent e) {;    }
    
    
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = MenuPanel.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }}
    
    /**
     * the following method paints the background of the panel. 
     * @param g 
     */
    @Override
   public void paintComponent(Graphics g)
        {
            Graphics2D g2d = (Graphics2D)g;
            g2d.drawImage(ResourceLoader.loadImage("backGroundPanel.png"),0, 0, this.getWidth(), this.getHeight(), this);           
        
        }

    /**
     * the following getters return every button on the panel in case they're needed throughout the code.
     * @return 
     */
    public CustomButton getExportBigIcon() {
        return exportBigIcon;
    }

    public CustomButton getHelpBigIcon() {
        return helpBigIcon;
    }

    public CustomButton getInfoBigIcon() {
        return infoBigIcon;
    }

    public CustomButton getNewBigIcon() {
        return newBigIcon;
    }

    public CustomButton getOpenBigIcon() {
        return openBigIcon;
    }

    public CustomButton getQuitBigIcon() {
        return quitBigIcon;
    }

    public CustomButton getSaveBigIcon() {
        return saveBigIcon;
    }
    
}
