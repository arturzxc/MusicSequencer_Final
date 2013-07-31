/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Novel;

import Views.Novel.ControlsSlidingPanel.BotSlidingContentPane;
import Views.Novel.ControlsSlidingPanel.TopSlidingMainMenuPanel;
import Views.Novel.MainMenuPanel.MainMenu;
import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *
 * @author IgIz
 */
public class MainFrameNovel extends JFrame {
    
    private MainContentPnl contentPnl;
    
    public MainFrameNovel()
    {
        setLayout(new GridLayout(1, 1));
        
        contentPnl =  new MainContentPnl();
        
        this.add(contentPnl);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(640,480);        
    }  
    
    public DragDropPanel getDragPanel(){
       return contentPnl.getDragPanel();
    }

    public MainMenu getMainMenu(){
        return contentPnl.getMainMenu();
    }
    
    public BotSlidingContentPane getBotSlidingContentPane(){
        return contentPnl.getBotSlidingContentPane();
    }
    
    public TopSlidingMainMenuPanel getTopSlidingContentPane(){
        return contentPnl.getTopSlidingPane();
    }
    
    public static void main(String[] args)
    {
       MainFrameNovel f = new MainFrameNovel();
        
   
    }
    
}
