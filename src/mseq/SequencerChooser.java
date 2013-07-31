/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mseq;

import javax.swing.JFrame;
import utils.ResourceLoader;

/**
 *
 * @author ak303
 */
public class SequencerChooser extends JFrame{

    
    public SequencerChooser() {
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(600,300);
        setTitle("Please pick your sequencer");
        setIconImage(ResourceLoader.loadImage("knob.png"));
        setContentPane(new Content());

    }
    

    
}
