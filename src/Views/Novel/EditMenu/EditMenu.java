package Views.Novel.EditMenu;

import Views.MainMenuPanels.CustomButton;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import mseq.Mseq;
import utils.ResourceLoader;

/**
 *EditMenu appears on a right click on the DragNDrop Panel or when pressing the edit menu icon on MainMenu Panel.
 * The JPopupMenu has GridLayout(1row, 4 columns)
 * From the panel, the star button is implemented as well as clear button.
 * The star button determines where to start the time line.
 * When the time line is determined the same star is painted on the sound icon.
 * The clear Button clears the sound icons from the dragNdrop panel so new ones can be added.
 * There is also an active area of the top right corner.If the left mouse button is pressed when the coordinates of the mouse
 * pointer are inside the active area, the edit menu disappears.
 * @author Group 21
 */
public class EditMenu extends JPopupMenu implements MouseListener {

    private CustomButton starBtn;
    private CustomButton copyBtn;
    private CustomButton pasteBtn;
    private CustomButton clearBtn;    
    
    /** 
     * The EditMenu panel is constructed here. 
     * The buttons are added to the panels and MouseListeners are attached to each button.
     */
    public EditMenu()    
    {
        setLayout(new GridLayout(1, 4));     
        setPreferredSize(new Dimension(200,125));
        starBtn = new CustomButton(ResourceLoader.loadImage("starIcon.png"));
        starBtn.addMouseListener(this);
        copyBtn = new CustomButton(ResourceLoader.loadImage("copyIcon.png"));
        copyBtn.addMouseListener(this);
        pasteBtn = new CustomButton(ResourceLoader.loadImage("pasteIcon.png"));
        pasteBtn.addMouseListener(this);
        clearBtn = new CustomButton(ResourceLoader.loadImage("clearIcon.png"));
        clearBtn.addMouseListener(this);

        add(starBtn);
        add(copyBtn);
        add(pasteBtn);
        add(clearBtn);

        setBorder(new EmptyBorder(50, 20, 20, 30));

        addMouseListener(new MouseAdapter() 
        {
            public void mousePressed(MouseEvent e)
                {
                   int width = getWidth();
                   int height = getHeight();

                   int mX = e.getX();
                   int mY = e.getY();
                   /**
                    * The active area is within 8th of the width of the panel and 5th of the height of the menu.
                    * If inside, setEditMenu() is called in Model which setsPopupMenu to false and the edit menu disappears.
                    */
                   if( mX>width-width/8 && mY<height/5)               
                     Mseq.view2.getDragPanel().setEditMenu();
                }
        }
                );
    
    
    }
    
    public CustomButton getClearBtn() {
        return clearBtn;
    }

    public CustomButton getCopyBtn() {
        return copyBtn;
    }

    public CustomButton getPasteBtn() {
        return pasteBtn;
    }

    public CustomButton getStarBtn() {
        return starBtn;
    }
    
    /**
     * The MouseListener's methods are overridden.
     * Only mousePressed is used since it looks more responsive than mouseClicked for example.
     * 
     * @param e 
     */
    public void mouseClicked(MouseEvent e) {;
    }

    public void mousePressed(MouseEvent e) {       
        /**
         * When the star button is pressed, two methods are called within the view.
         * The highlighted icon is set as the start of the time line and the popupmenu disappears when calling the second method.
         */
      if(e.getSource() == starBtn){
          Mseq.view2.getDragPanel().selectTimeline();
          Mseq.view2.getDragPanel().setEditMenu();
      }
      else if(e.getSource() == copyBtn){
          System.out.println("COPY");
      }
      else if(e.getSource() == pasteBtn){
          System.out.println("PASTE");
      }
      /**
       * All sounds are cleared from the dragNdrop panel.
       */
       else if(e.getSource() == clearBtn){
          Mseq.view2.getDragPanel().clearSounds();
      }
       else ;
    }

    public void mouseReleased(MouseEvent e) {;
    }

    public void mouseEntered(MouseEvent e) {;
        

    }

    public void mouseExited(MouseEvent e) {;
    }
    /**
     * The background of the menu is painted.
     * @param g 
     */
    @Override
   public void paintComponent(Graphics g)
        {
            Graphics2D g2d = (Graphics2D)g;
            g2d.drawImage(ResourceLoader.loadImage("editMenuBackground.png"),0, 0, this.getWidth(), this.getHeight(), this);           
        
        }
    
}
