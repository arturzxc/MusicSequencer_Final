/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Novel;

import Models.Configs;
import Models.Sound;
import Views.MainMenuPanels.ImagePanel;
import Views.Novel.MainMenuPanel.MainMenu;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author ak303
 */
public class MainLayer extends JPanel{
    private MainMenu menuPanel;
    private ImagePanel pianoPanel;
    private DragDropPanel mainPanel;
    private GridBagConstraints cons;
    
    public MainLayer()
    {
        setLayout(new GridBagLayout());
        
        
        setOpaque(false);
        
        menuPanel = new MainMenu();       
        setUpConstraints();
        
        setUpConstraints(0, 0, 1, 0.15); 
        cons.gridwidth=2;
        add(menuPanel, cons);
        
        //pianoPanel = new ImagePanel(Configs.IMAGE_PATH+"pianoImageIcon.png");   
        //pianoPanel.setOpaque(false);
        //setUpConstraints(0, 1, 0.2, 0.85);
        //add(pianoPanel, cons);
        
        mainPanel = new DragDropPanel();
        mainPanel.setBackground(Color.blue);
        setUpConstraints(1, 1, 1, 0.85);
        add(mainPanel, cons);        
               
        setVisible(true);
        setOpaque(false);
        setSize(500, 500);
    
    }
    
    public DragDropPanel getDragPanel(){
        return mainPanel;
    }
    
    
    public MainMenu getMainMenu(){
        return menuPanel;
    }
    
    private void setUpConstraints()
    {
        cons =  new GridBagConstraints();
        cons.fill = GridBagConstraints.BOTH;
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.weightx = 1;
        cons.weighty = 0.1;
    }
    
    private void setUpConstraints(int gridx, int gridy, double weightx, double weighty)
    {
        cons.gridwidth = 1;
        cons.gridx = gridx;
        cons.gridy = gridy;
        cons.weightx = weightx;
        cons.weighty = weighty;        
    }
    
}
