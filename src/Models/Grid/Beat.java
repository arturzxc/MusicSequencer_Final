package Models.Grid;

import java.util.ArrayList;

/**
 *
 * @author Group 21
 * 
 * This class holds frames. Frames are added using a factory to 
 */
public class Beat {
    private ArrayList<Frame> frames;
    
    private int no;
    private int framesNo; //initial no of frames.

    
    /**
     * Default constructor
     * @param no every beat has a number.
     * @param framesNo this is the number of frames that the beat should contain
     */
    public Beat(int no, int framesNo) {
        frames = new ArrayList<Frame>();
        this.no=no;
        this.framesNo = framesNo;
        
        addInitFrames();
    }

    /**
     * Adds frames produced by the Frames factory.
     */
    private void addInitFrames(){
        for(int i=0;i<framesNo;i++){
            frames.add(FrameFactory.createFrame());
        }
    }

    /**
     * Gets all the frames from a beat
     * @return  ArrayList of Frames
     */
    public ArrayList<Frame> getFrames() {
        return frames;
    }

    /**
     * Get number of frames by size of the array list of frames.
     * @return 
     */
    public int getFramesNo() {
        return frames.size();
    }

    /**
     * Get the number of a beat.
     * @return 
     */
    public int getNo() {
        return no;
    }
    
    
    
}
