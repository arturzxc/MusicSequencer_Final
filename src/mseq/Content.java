/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mseq;

import Views.MainMenuPanels.CustomMenuButton;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import utils.ResourceLoader;

/**
 *
 * @author ak303
 */
public class Content extends JPanel implements MouseListener{
    private GridBagConstraints cons;  
    private ConvPict convPict;
    private NovelPict novelPict;
    private CustomMenuButton convBtn;
    private CustomMenuButton novelBtn;

    public Content() {
        setLayout(new GridBagLayout()); 

        setUpConstraints();        
        initComponents();

        setConstraints(0, 0, 1, 0.8, 1, 1);
        add(convPict,cons);
        setConstraints(1, 0, 1, 0.8, 1, 1);
        add(novelPict,cons);
        setConstraints(0, 1, 1, 0.2, 1, 1);
        
        add(convBtn,cons);
        setConstraints(1, 1, 1, 0.2, 1, 1);
        add(novelBtn,cons);
    }

    private void initComponents(){        
        convPict = new ConvPict();
        novelPict = new NovelPict();

        convBtn = new CustomMenuButton(ResourceLoader.loadImage("conventionalIcon.png"));
        novelBtn = new CustomMenuButton(ResourceLoader.loadImage("novelIcon.png"));
        
        convBtn.addMouseListener(this);
        novelBtn.addMouseListener(this);
    }   
    
    private void setUpConstraints(){    
        cons=new GridBagConstraints();
        cons.insets=new Insets(5, 5, 5, 5);
        cons.anchor=GridBagConstraints.NORTHWEST;
        cons.fill=GridBagConstraints.BOTH;
        cons.weightx=1;
        cons.weighty=1;
        cons.gridheight=1;
        cons.gridwidth=1;              
    }
    
    private void setConstraints(int gridx, int gridy,double weightx, double weighty, int gridheight,int gridwidth){
        cons.gridx=gridx;
        cons.gridy=gridy;
        cons.weightx=weightx;
        cons.weighty=weighty; 
        cons.gridheight=gridheight;
        cons.gridwidth=gridwidth;
    }


    public void mouseClicked(MouseEvent e) {
        //
    }

    public void mousePressed(MouseEvent e) {
        if(e.getSource()==convBtn){
            Mseq.createConventional();
        }
        if(e.getSource()==novelBtn){
            Mseq.createNovel();
        }
    }

    public void mouseReleased(MouseEvent e) {
        //
    }

    public void mouseEntered(MouseEvent e) {
        //
    }

    public void mouseExited(MouseEvent e) {
        //
    }

    
    /*
     * This is a label that draws the picture representing conventional design
     */
    class ConvPict extends JLabel{

        
        @Override
        public void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D)g;
            g2d.drawImage(ResourceLoader.loadImage("design2.png"),0,0,getWidth(),getHeight(),this);
        }
    }
    
    /*
     * This is a label that draws the picture representing novel design
     */
    class NovelPict extends JLabel{

        
        @Override
        public void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D)g;
            g2d.drawImage(ResourceLoader.loadImage("novel.png"),0,0,getWidth(),getHeight(),this);
        }
    }
}