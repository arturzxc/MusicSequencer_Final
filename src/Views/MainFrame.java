/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Views;

import javax.swing.JFrame;
import Models.Configs;
import javax.swing.ImageIcon;
/**
 *
 * @author Group 21
 * Main Frame of the program.
 */
public class MainFrame extends JFrame{
            
    private ContentPnl contentPnl;
    

    public MainFrame(){
        super("MSEQ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640,480);  
        setIconImage(new ImageIcon(Object.class.getResource(Configs.IMAGE_PATH+"design2.png")).getImage());
        setUpContentPane();        
    }

    private void setUpContentPane(){
        contentPnl=new ContentPnl();
        setContentPane(contentPnl);
    }

    public ContentPnl getContentPnl() {
        return contentPnl;
    }
    
    

}
