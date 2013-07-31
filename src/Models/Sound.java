/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Models.Grid.Frame;
import java.util.ArrayList;
import net.beadsproject.beads.core.AudioContext;
import net.beadsproject.beads.data.Sample;
import net.beadsproject.beads.data.SampleManager;
import net.beadsproject.beads.ugens.Envelope;
import net.beadsproject.beads.ugens.Gain;
import net.beadsproject.beads.ugens.SamplePlayer;

/**
 *Class which represents a sound in the sequencer.It has method for muting,playering,chanigng pitch,volume 
 * of the selected sound.This is the model of the SoundIcons.
 * @author group_21
 */
public class Sound {
    private int id;//ID of the sound
    private ArrayList<Frame> frames;//Holds array list of its frames which represent beats.Only used for conventional design.
    private String sound = "";
    private float pitch = 1;
    private int tone;
    private float volume;
    private float originalVolume;
    private float gain = (float)1;
    private boolean muted;
    private AudioContext ac;
    
    /**
     * The constructor for the sound clas,takes in the filepath of the sound and the audiocontext passed from
     * sequence player.
     * @param sound
     * @param n
     * @param ac 
     */
    public Sound(String sound,int n,AudioContext ac){
        id = n;
        
        if(mseq.Mseq.type.equals("conventional"))
             frames = mseq.Mseq.model.getGrid().getFramesInRow(id);
        
        this.sound = sound;
        this.ac = ac;
        
    }
    /**
     * This method is used by conventional design to reset the frames by reseting its frame
     * 
     */
    public void resetFrames(){
        frames = mseq.Mseq.model.getGrid().getFramesInRow(id);
    }
    
     public void setBeat(int beat){
			/* This method is called from the Clock message listener at the start of each beat.
			*/
                        if(muted)
                            return;
                        
			if(frames.get(beat).isOn()){  // if the box is selected then play a sound 
			// get the currently selected sound file, and add the folder path to it,
			// note use of the File.separator to ensure platform independence.
                            
				String soundFile = Configs.SOUND_PATH+this.sound;  
                               
				//load the sound
					// in Beads the first time a sound is loaded it gets stored into memory, so you may
					// hear a click or a pause the first time, but after that it should be fine.
                                
				Sample selectedSample = SampleManager.sample(soundFile);                                
                                
				// create a sample player
				SamplePlayer samplePlayer = new SamplePlayer(ac,selectedSample);
				
				// set to kill on end, so when the sample finished
				// the sample player is removed from the audio context (to free up CPU resources)
				samplePlayer.setKillOnEnd(true);  
                                samplePlayer.getPitchEnvelope().setValue(pitch);
				//scale the volume with a Gain, and use the value from the volume slider
				Gain gainControl = new Gain(ac, 1, new Envelope(ac, this.gain ));
				// add the sample player to the gain's input
				gainControl.addInput(samplePlayer);
				
                
                                gainControl.setKillListener(samplePlayer); 
                
				// add the gain to the audio context's output
				ac.out.addInput(gainControl);
            }
    }
     
     
    /**
      * This method is for changing the volume of the sound,it needs an argument from 0-100
      * @param vol 
      */
    public void changeVolume(int vol){
        
        this.volume = vol;
        this.gain = volume/100;
    }
    
    /**
     * This method puts the sound volume to 0 to give impression of muting the sound.
     */
    public void muteSound(){
        this.originalVolume = this.volume;
        this.volume = 0;
        this.gain = this.volume;
        this.muted = true;
    }
    
    /**
     * This method plays the sound when called.It creates a sample player using the path provided initialy at the constructor
     * 
     */
    public void play(){
        String soundFile = Configs.SOUND_PATH+this.sound;  
        Sample selectedSample = SampleManager.sample(soundFile);
	SamplePlayer samplePlayer = new SamplePlayer(ac,selectedSample);
        samplePlayer.getPitchEnvelope().setValue(pitch);
	Gain gainControl = new Gain(ac, 1, new Envelope(ac, this.gain ));
	gainControl.addInput(samplePlayer);
        gainControl.setKillListener(samplePlayer); 
	ac.out.addInput(gainControl);
        
    }
    
    /**
     * Method for un-muting the sound,it un-mutes it by changing the volume back to its original volume when
     * the sound was muted.
     */
    public void unmuteSound(){
        this.volume = this.originalVolume;
        this.gain = this.volume/100;
        this.muted = false;
        System.out.println("Unmutingw with val "+originalVolume);
    }
    
    /**
     * Method for setting the ID of the sound
     * @param id
     */
    public void setID(int n){
        id = n;
        if(mseq.Mseq.type.equals("conventional"))
        frames = mseq.Mseq.model.getGrid().getFramesInRow(id);
    }
    
    /**
     * Method for getting the current ID of the sound.
     * @return id of the sound
     */
    public int getID(){
        return id;
    }
    
    /**
     * 
     * @param pitch number from -12 to 12
     */
    public void setPitch(int n){
      
        pitch = PitchRatioCalculator.semitoneRatio(98, n);
    }
    
    /**
     * This method remove the sound from the player when called.
     */
    public void remove(){
        mseq.Mseq.model.getPlayer().removeSound(this);
    }
}
