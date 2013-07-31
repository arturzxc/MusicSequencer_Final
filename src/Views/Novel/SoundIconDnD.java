/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Novel;

import Models.Sound;
import Views.SoundPanelElements.SoundIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import utils.ResourceLoader;

/**
 *Class which is the SoundIcon for novel design.It implements all the methods of SoundIcon class from conventional 
 * but adds the drag and drop functionality to it to enable reuse for novel design.
 * @author IgIz
 */
public class SoundIconDnD extends SoundIcon implements DragSourceListener,DragGestureListener  {
    
    DragSource ds = DragSource.getDefaultDragSource();//Drag source listener
    private boolean hasPlayed;//Has the sound played yet
    private boolean timeline = false;//Whether it is starting point of a timeline
    private Color color;//Color of the icon
    private int yPos;
    private int xPos;
    
    
    /**
     * Constructor of the class.Takes in image,Color, and Sound objects.It acts as a extended class of 
     * SoundIcon and has all the functionalities of it.
     * @param img
     * @param c
     * @param snd 
     */
    public SoundIconDnD(Image img,Color c,Sound snd){
        super(img,snd);
        color = c;
        setPreferredSize(new Dimension(50,30));
        setSize(new Dimension(50,30));
        
        ds.createDefaultDragGestureRecognizer(this,DnDConstants.ACTION_COPY_OR_MOVE, this);
        setDoubleBuffered(true);
    }
    
    /**
     * Getter for getting the color of the icon,this enables the timeline to have 
     * different colors for each different SoundIcon it starts from.
     * @return 
     */
    public Color getColor(){
        return color;
    }
    
    /**
     * Setter for setting that the icon is the starting point of a timeline.
     * @param val 
     */
    public void setTimeline(boolean val){
        timeline = val;
    }
   

    public void dragEnter(DragSourceDragEvent dsde) {
        
    }
    
    /**
     * Private method for calculating pitch given the icons Y position on the parent panel.Returns from 0 to 100.
     * @param y
     * @return pitch
     */
    private float calculatePitch(int y){
        int highestVal = mseq.Mseq.view2.getDragPanel().getHeight();
        int digit = highestVal/100;
        float value2 = y/digit;
        
        return value2;
    }

    /**
     * Called when the draging of the icon is over.It then calculates the pitch of the icon accordingly to 
     * the icons Y position by calling calculatePitch method.The pitch is then set on he actual sound.
     * @param dsde 
     */
    public void dragOver(DragSourceDragEvent dsde) {
        dsde.getDragSourceContext().getComponent().setLocation(Constant.x, Constant.y);
        yPos = Constant.y;
        xPos = Constant.x;
        
        float value = calculatePitch(yPos);
        double pitch = ((50-value)/4.1)*-1;
        pitch = -pitch;
        getSound().setPitch((int)pitch);
    }

    public void dropActionChanged(DragSourceDragEvent dsde) {
        
    }

    public void dragExit(DragSourceEvent dse) {
        
    }

    public void dragDropEnd(DragSourceDropEvent dsde) {
        
    }
    
    /**
     * Drag and drop implementation,recognizes any drag gestures on the icon and notifies the drag listener
     * which is the panel that the icon needs to be repositioned.
     * @param dge 
     */

    public void dragGestureRecognized(DragGestureEvent dge) {
        Transferable t = new StringSelection(super.getName());
        dge.startDrag(DragSource.DefaultMoveDrop, t, this);
    }
    
    /**
     * When called if the sound has not been played it plays the sound once.
     */
    public void play(){
        if(!hasPlayed)
            getSound().play();
    }
    
    /**
     * Setter for hasPlayed,identifies whether the sound has already been played
     * @param val 
     */
    public void setHasPlayed(boolean val){
        hasPlayed = val;
    }
    
    /**
     * Getter for sound has been played.
     * @return boolean
     */
    
    public boolean getHasPlayed(){
        return hasPlayed;
    }
    
    
    /**
     * Overriden paint methd , it calls the paint from superclass to paint the original sound icon
     * but this also paints a start on the icon if it is selected as a timeline.It also resizes the icon
     * accordingly to the size of the panel it is in,dynamic resizing.
     */
    public void paint(Graphics g){
        super.paint(g);
        //Size is changed in paint so when we resize window the icons size changes too.
        setPreferredSize(new Dimension(getParent().getWidth()/10,getParent().getHeight()/14));   
        setSize(new Dimension(getParent().getWidth()/10,getParent().getHeight()/14));     
        Graphics2D g2 = (Graphics2D)g;
        setBounds(xPos, yPos,getParent().getWidth()/10 ,getParent().getHeight()/14);
        float temp = (float) (this.getHeight()/2.1);
        if(timeline)
            g2.drawImage(ResourceLoader.loadImage("star.png"),this.getWidth()/9,(int)temp , this.getWidth()/4, this.getWidth()/4, this);
    }
}
