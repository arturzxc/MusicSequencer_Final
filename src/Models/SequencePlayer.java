package Models;


import Models.Sound;
import java.util.ArrayList;
import java.util.Observable;
import net.beadsproject.beads.core.*;
import net.beadsproject.beads.ugens.Clock;


/**
 * This is the model class for sequence player.It controls the sequences played by using clocks
 * and makes use of the controller class which then updates the time line accordingly to the clock
 * depending on which version of sequencer is displayed,novel or conventional.
 */

/**
 *
 * @author IgIz
 */
public class SequencePlayer extends Observable {
    private int nextID = 0;//ID for the next sounds to be added
    private SequencePlayer instance;//Holds reference to itself for use of nested beads class
    ArrayList<Sound> sequencerList = new ArrayList<Sound>();//holds all the current sounds that are added to teh sequencer
    private AudioContext ac = new AudioContext(); //Audio context
    private final Clock clock = new Clock(ac, 1200);//Clock for teh sequencer
    private int sequenceLength;// holds the number of beats that the player is allow to play
    private Sound selected = null; // reference to selected sounds for editing,initially there is no sound selected
    private int soundLimit = 6; // The limit of sounds for conventional to hold
    private int pitch = 1;//Initial pitch of the sounds.
    
    private String[] soundFiles = {"PianoA.aif","bass.aif","BassNote_Asharp.aif","snare.aif","guitar.aif"};
    int beat = 0;
    
    
    public SequencePlayer(){
        clock.getIntervalEnvelope().setValue(1760);//Initial clock speed
        sequenceLength = 6*5;
        clock.addMessageListener(
            new Bead() {  //using an anonymous class created every time the clock ticks
				public void messageReceived(Bead message) {
                                       
					 beat = clock.getInt() % instance.sequenceLength;   // turn the clock's count into a number between 0 and 15
					// on each beat, run through the List of SequencerRows and notify them
					// that the beat has changed
                                        setChanged();
                                        notifyObservers("timeLine");
					
                                        if(mseq.Mseq.type.equals("conventional")){
                                            for(Sound sound : sequencerList){
						sound.setBeat(beat);	// passing in the beat number and the audio context
                                            }
                                        }
                                        
				}
			});
        ac.out.addDependent(clock);  //add the clock as dependant so it gets computed by the audio context   
        instance = this;
    }
    
    /**
     * Return the number of sounds currently held
     * @return 
     */
    public int getNumberOfSounds(){
        return sequencerList.size()-1;
    }
    
    
    /**
     * Set the length limit for the sequencer player,currently not supported
     * @param length 
     */
    public void setLength(int n){
        this.sequenceLength = n;   
    }
    
    /**
     * Method for changing the beats per minute of the sequencer
     * @param speed
     */
    public void setBPM(int n){
        n = n*15;
        clock.getIntervalEnvelope().setValue(n);
    }
    
    /**
     * Returns whether there is a sound already selected for editing
     * @return selected
     */
    public boolean hasSelected(){
        if(selected!=null)
            return true;
        else
            return false;
    }
    
    /**
     * Sets a volume for the sequencer,if a sounds is selected for editing then it only
     * changes volume for that particular sound leaving other sounds unchanged.
     * Else it changes all sounds in the sequencer as a whole.
     * @param volume 
     */
    public void setVolume(int n){
        if(selected!=null)
            selected.changeVolume(n);
        else
            for(Sound s :sequencerList){
                s.changeVolume(n);
            }
    }
    
    /**
     * Method for selecting a sounds for editing.Passed sound will
     * be the sound that is only edited when changing volume or pitch.s
     * @param Sound sound
     */
    public void selectSound(Sound sounds){
        selected = sounds;
    }
    
    /**
     * Returns the selected sound
     * @return Sound
     */
    public Sound getSelected(){
        return selected;
    }
    
    /**
     * Method used for deselecting a sound,checks if the passed
     * sound was the selected and then deselects the sound
     * @param sounds 
     */
    public void deselectSound(Sound sounds){
        if(sounds == selected){
            selected = null;
        }
    }
    
    /**
     * Method for setting pitch,either sets the pith.
     * If no particular sound is selected for editing then sets the pitch for 
     * all sounds in the sequence else it sets the pitch for the selected sound
     * leaving others unchanged.
     * @param pitch
     */
    public void setPitch(int n){
        if(selected!=null){
            selected.setPitch(n);
        }else{
            pitch = n;
            for(Sound s :sequencerList)
                s.setPitch(n);
        }
    }
    
    
    /**
     * Method to start playing the sequencer
     */
    public void  play(){
     ac.start();
    }
    
    /**
     * Method for stopping the sequencer
     */
    public void stop(){
     ac.stop();
    }
    
    /**
     * Method for pausing the sequencer,currently does the same as stop.
     */
    public void pause(){
     ac.stop();
    }
    
    /**
     * Method for adding sounds into a sequencer,the controllers in view calls this method with parameter of
     * type of music that needs to be created.The method then creates a Sound instance according to the type
     * and returns the sound that it just created.
     * @param Type
     * @return Sound
     */
    public Sound addSound(String type){
        
        if(mseq.Mseq.type.equals("conventional"))
            if(soundLimit <= (sequencerList.size())){
                 return null;
             }
        
        String sound = "";
        if(type.equals("Piano")){
            sound = soundFiles[0];           
        }
        else if (type.equals("Bass")){
            sound = soundFiles[1];
        }
            
        else if (type.equals("Synth")){
            sound = soundFiles[2];
        }
        else if (type.equals("Guitar")){
             sound = soundFiles[4];
        }
        else if (type.equals("Drums")){
             sound = soundFiles[3];
        }
        
        Sound newSound = new Sound(sound, nextID,ac);
        sequencerList.add(newSound);
        nextID +=1;
        newSound.setPitch(pitch);
        
        return newSound;//Return new created sound
    }
    
    
    /**
     * Method for removing a sound from a sequence,the passed sound is removed from the 
     * array list of sounds and therefore is removed from the sequence as whole.
     * @param Sound
     */
    public void removeSound(Sound s){
        if(selected == s)
            selected = null;
        
       sequencerList.remove(s);
       nextID -=1;
       changeID();
       
    }
    
    /**
     * Method for getting the AudioContext used by this player.
     * @return AudioContext
     */
    public AudioContext getAudiotContext(){
        return ac;
    }
    
    /**
     * Inner method for changing around the id's of sounds when a sound is removed from a list.
     * This makes sure that sounds hold the correct ids in order to identify them
     * for timeline.
     */
    
    private void changeID(){
        int i =0;
        for(Sound s:sequencerList){
            s.setID(i);
            i++;
        }
    }
}
