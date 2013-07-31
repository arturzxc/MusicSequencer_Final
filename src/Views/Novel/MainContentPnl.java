/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package Views.Novel;


import Views.Novel.ControlsSlidingPanel.BotSlidingContentPane;
import Views.Novel.ControlsSlidingPanel.TopSlidingMainMenuPanel;
import Views.Novel.MainMenuPanel.MainMenu;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

/**
 *
 * @author Group 21
 */
public class MainContentPnl extends JLayeredPane {
    private MainLayer mainLayer;
    private BotSlidingContentPane botSlidingPane;
    private TopSlidingMainMenuPanel topSlidingPane;

    public MainContentPnl() {
        setLayout(new OverlayLayout(this));
        add(botSlidingPane = new BotSlidingContentPane(),0);
        add(topSlidingPane = new TopSlidingMainMenuPanel(),1);
        add(mainLayer = new MainLayer(),2);                        
    }

    public BotSlidingContentPane getBotSlidingPane() {
        return botSlidingPane;
    }
    
    
    public DragDropPanel getDragPanel(){
        return mainLayer.getDragPanel();
    }
    
    public MainMenu getMainMenu(){
        return mainLayer.getMainMenu();
    }
    
    public BotSlidingContentPane getBotSlidingContentPane(){
        return botSlidingPane;
    }

    public TopSlidingMainMenuPanel getTopSlidingPane() {
        return topSlidingPane;
    }
    

}
