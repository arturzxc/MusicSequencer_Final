/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Novel;

import Views.MainMenuPanels.ImagePanel;
import Views.Novel.EditMenu.EditMenu;
import Views.SoundPanelElements.SoundIcon;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.*;

/**
 *Drag and drop panel for draging around icons on the novel design.It consits of SoundIconDnD panel which
 * listens for drags and positions icons accordingly,RippleTimeline which displays the timeline and an ImagePanel which 
 * is the background image of the panel.
 * @author IgIz
 */
public class DragDropPanel extends JLayeredPane{
     private SoundIconPanelDnD ddPanel;//Panel on which the soundicons are positioned,listens for drag events.
     private RippleTimeLine timeLine;//Timeline panel
     private ImagePanel background = new ImagePanel("/resources/images/novelDragBackground.png");//Background panel   
     private EditMenu editMenu;//Edit menu
     
     private ArrayList<SoundIconDnD> sounds = new ArrayList<SoundIconDnD>();//ArrayList of SoundIconDnD
     private SoundIconDnD startFrom;//Icon from which the timeline starts from
     public boolean timelineOn = false;//Boolean for checking whether the timeline is on
     public boolean isSet = true;//Method for checking if the timeline is actually set
     
    public DragDropPanel(){
        //Construting the panels
        setLayout(new OverlayLayout(this));
        timeLine = new RippleTimeLine();
        ddPanel = new SoundIconPanelDnD(this);        
        editMenu = new EditMenu();
        
        //Adding the panels into the current panel
        add(background,0,0);
        add(timeLine,1,1);
        timeLine.setOpaque(false);
        add(ddPanel,2,2);
        ddPanel.setOpaque(false);
        setDoubleBuffered(true);
        //Setting popup edit menu
        setComponentPopupMenu(editMenu);
        
    }
    
    /**
     * Method which is called every time the timeline is expanded by the controller.
     * It checks whether the current size and position of the timeline has hit any sound icons
     * and if so it plays them if they haven't been played already
     */
    public void clearSounds(){
      for(int i=0;i<sounds.size();i++){
           removeSound(sounds.get(i));
      }
      revalidate();
      repaint();
    }
    
    public void checkSoundHit(){
        for(SoundIconDnD icon:sounds){
            if(!icon.getHasPlayed())
                if(intersects(icon)){
                    icon.play();
                    icon.setHasPlayed(true);
                }
        }
    }
    
    /**
     * Method for selecting the position where the timeline starts from.It is called from the
     * edit menu when the user presses a start.The method check which of the icons is selected
     * indicated by the yellow border around it.Then it sets the timeline on that icon.If no icon is selected it does 
     * not do anything.
     */
    public void selectTimeline(){
        for(SoundIconDnD icon:sounds)
            if(icon.getSelected()){
                
             if(startFrom !=null){
                 startFrom.setTimeline(false);
             }
             
             startFrom.repaint();//Repaint the old timeline icon to remove the start frrom it.
             startFrom = icon;
             icon.setTimeline(true);
             timeLine.setX(startFrom.getX()-(startFrom.getWidth()/16));
             timeLine.setY(startFrom.getY()-(startFrom.getHeight()/3));
             timeLine.setColor(icon.getColor());//Change color of the timeline to the color of the icon
             icon.repaint();//repaint the new timeline icon to add the star to it.
             break;//break out once the selected icon was found.
        }
    }
    
    /**
     * Called by SoundIconDnD every time an icon is moved,this enabled dynamic moving of the timeline
     * even when it is playing.It recalculates the new co-ordinates of th tmeline.
     */
    public void iconMoved(){
       timeLine.setX(startFrom.getX()-(startFrom.getWidth()/16));
       timeLine.setY(startFrom.getY()-(startFrom.getHeight()/3));
    }
    
    /**
     * Method for calculating whether the icon and the timeline have intersected.
     * @param icon
     * @return 
     */
    public boolean intersects(SoundIconDnD icon){
        
        int xFrom = timeLine.getXPos();
        int xTo = timeLine.getXPos() + timeLine.getCurrentSize();
        int yFrom = timeLine.getYPos();
        int yTo = timeLine.getYPos() + timeLine.getCurrentSize();
        
        int iconx = icon.getX();
        int icony = icon.getY();
        
        if(icon.getX() < timeLine.getXPos()+(timeLine.getCurrentSize()/2))
            iconx+=icon.getWidth()/1.5;
        else
            iconx+=icon.getWidth()/3;
        
        if(xFrom <= iconx && xTo >= iconx)
            if(yFrom <= icony && yTo >= icony)
                return true;
            else
                return false;
        else
            return false;
    }
    
    /**
     * Method for expanding the timeline,
     */
    public void updateTimeLine(){
        if(startFrom == null)
            return;
        
        System.out.println("THe timeline Y pos is "+timeLine.getYPos()+" the x pos is "+timeLine.getXPos());
        System.out.println("this widtrh"+getWidth()+" get height"+getHeight());
        
        
        System.out.println("Math abz x"+(Math.abs(timeLine.getXPos())));
        
        System.out.println("Math abz y"+(Math.abs(timeLine.getYPos())+startFrom.getY()));
        
        if(startFrom.getX() > getWidth()/2){
           if(timeLine.getYPos() <= -100 && timeLine.getXPos() <= -100 ){
            timeLine.reset();
            
            for(SoundIconDnD ic : sounds){
               ic.setHasPlayed(false);
            }
           }
        }else{
            if(((Math.abs(timeLine.getYPos())+startFrom.getY()) >= getHeight())&& ((Math.abs(timeLine.getXPos())+startFrom.getX()) >= getWidth())){
                timeLine.reset();
                for(SoundIconDnD ic : sounds){
                    ic.setHasPlayed(false);
                }   
            }
        }
        
            
        timeLine.expand();
        checkSoundHit();
    }
    
    public void addSound(SoundIconDnD icon){
            sounds.add(icon);
            ddPanel.add(icon);
        
            if(sounds.size() == 1){
                startFrom = sounds.get(0);
                startFrom.setTimeline(true);
                timeLine.setColor(sounds.get(0).getColor());
            }
        
            repaint();
    }
    
    public void removeSound(SoundIcon icon){
        sounds.remove(icon);
        ddPanel.remove(icon);
        
        if(startFrom == icon){
            startFrom =null;
            if(sounds.size()>=1){
                sounds.get(0).setTimeline(true);
                startFrom = sounds.get(0);
                timeLine.setColor(sounds.get(0).getColor());
                timeLine.setX(startFrom.getX()-(startFrom.getWidth()/16));
                timeLine.setY(startFrom.getY()-(startFrom.getHeight()/3));
            }else{
                stopTimeLine();
                timeLine.reset();
            }
        }
        repaint();
    }
    
    public void startTimeline(){        
        
        if(startFrom == null || timelineOn == true)
            return;
        
        timeLine.setX(startFrom.getX()-(startFrom.getWidth()/16));
        timeLine.setY(startFrom.getY()-(startFrom.getHeight()/3));
        timelineOn = true;
    }
    
    public void setStartFrom(SoundIconDnD icon){
        startFrom = icon;
    }
    
    public void clearIcons(){
        startFrom = null;
        sounds = new ArrayList<SoundIconDnD>();
        removeAll();
        repaint();
    }
    
    /**
     * 
     */
    public void stopTimeLine(){
        for(SoundIconDnD icon:sounds)
            if(icon.getHasPlayed())
               icon.setHasPlayed(false);
        
        timelineOn = false;
        timeLine.reset();
        timeLine.repaint();
    }
    
    public void pauseTimeLine(){
        timelineOn = false;
        timeLine.repaint();
    }
    
    public void setEditMenu()
    {
        if(isSet){   
       
           isSet=true;    
           editMenu.setVisible(false);
           editMenu.revalidate();
           editMenu.repaint();
        }
        else{
           editMenu.setVisible(true);
           editMenu.revalidate();
           editMenu.repaint();
           isSet=true;
        }
    }
}
