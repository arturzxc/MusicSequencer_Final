
package Models;

import Models.Grid.Grid;

/**
 *
 * @author Group 21
 */
public class MusicSequencer { //THIS IS THE ROOT OF THE MODEL!! IT WILL BE PASSED TO THE VIEW! You should be able to get anything from here!
    private Grid grid;
    private SequencePlayer player;
    private int numberOfBeats;
    private int conventionalLimit = 6;

    /**
     * creates Grid and music sequencer.
     * also sets the total number of beats.
     */
    public MusicSequencer() {
        grid = new Grid(6, 6,5);
        numberOfBeats = 6*5;
        player = new SequencePlayer();
    }
    
    public int getConventionalLimit(){
        return conventionalLimit;
    } 
    
    public SequencePlayer getPlayer(){
        return player;
    }

    public int getNumberOfBeats(){
        return numberOfBeats;
    }
    
    public Grid getGrid() {
        return grid;
    }
    
    
}
