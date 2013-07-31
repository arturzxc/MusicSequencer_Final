/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Novel;

import Views.Novel.Constant;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import javax.swing.JPanel;

/**
 * Class for drag and drop panel,it listens for elements that are added to it for draging and droping.
 * Once draged it places them accordingly
 * @author IgIz
 */
public class SoundIconPanelDnD extends JPanel implements DropTargetListener {
 DropTarget dt;
 DragDropPanel panelToControl;
 
 /**
  * The constructor which creates this panel and makes it lsiten for drags.This is using awt drag and drop package to listen
  * for drag events and pisition elements accordingly.
  */
 private SoundIconPanelDnD() {
     dt = new DropTarget(this, DnDConstants.ACTION_COPY_OR_MOVE, this);
     setOpaque(false);
     setIgnoreRepaint(true);
     setDoubleBuffered(true);
 }
/**
  * The constructor which takes in the DragDropPanel which is where this panel is added.
  * It needs a DragDropPanel in order to control the timeline when the icon with the timeline is moved
  * this enables dynamic timeline positioning.
  * 
  * @param aThis 
  */
 public SoundIconPanelDnD(DragDropPanel aThis) {
       this();
       panelToControl = aThis;
 }
 
 public void dragEnter(DropTargetDragEvent arg0) {
 }

 public void dragExit(DropTargetEvent arg0) {
 }
/**
  * Method which is called when the drag is over,it position the element accordingly to where it was dragged.
  * @param arg0 the drag source (element that was dragged)
  */
 public void dragOver(DropTargetDragEvent arg0) {
     
       panelToControl.iconMoved();
       Constant.x = arg0.getLocation().x;
       Constant.y = arg0.getLocation().y;
       repaint();
       this.getParent().repaint();
 }

 public void drop(DropTargetDropEvent arg0) {
 }

 public void dropActionChanged(DropTargetDragEvent arg0) {
 }

}
