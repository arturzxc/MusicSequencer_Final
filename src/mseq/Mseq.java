/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mseq;

import Controller.Controller;
import Models.MusicSequencer;
import Views.MainFrame;
import Views.Novel.MainFrameNovel;

/** 
 *
 * @author arturzxc
 */
public class Mseq {
        //models and views are public satic so you can access them anywhere doing that: Main.model or Main.view1
    public static MusicSequencer model;
    public static MainFrame view1;  
    public static MainFrameNovel view2;
    public static String type = "";
    private static SequencerChooser chooser;
    
    public static Controller control;
    
    public static void main(String[] args) { 
        model = new MusicSequencer();   
        chooser = new SequencerChooser();
        chooser.setResizable(true);
        chooser.setVisible(true);
        
        control = new Controller();
    }
    
    public static void createNovel(){
        view2 = new MainFrameNovel();
        type="novel";
        model.getPlayer().addObserver(control);
        chooser.setVisible(false);
    }
    
    public static void createConventional(){
        view1 = new MainFrame();
        type="conventional";
        model.getPlayer().addObserver(control);
        view1.setVisible(true);
        chooser.setVisible(false);
    }
    
    public String getType(){
        return type;
    }
}
