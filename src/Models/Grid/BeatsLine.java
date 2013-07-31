
package Models.Grid;

import java.util.ArrayList;

/**
 *
 * @author Group 21
 */
public class BeatsLine {
    private ArrayList<Beat> beats = new ArrayList<Beat>();
    private int no;
    private int noBeats;    //initial no of beats.
    
    /**
     * Default constructor.
     * @param no number of this line
     * @param noBeats initial no of beats.
     */
    public BeatsLine(int no, int noBeats) {
        this.no = no;
        this.noBeats = noBeats;
        
         addInitBeats();
    }
    
    /**
     * adds initial beats to this line
     */
    private void addInitBeats(){
        for(int i=0;i<noBeats;i++){
            beats.add(BeatFactory.createBeat());
        }
    }
 
    public int getNoBeats(){
        return beats.size();
    }

    public ArrayList<Beat> getBeats() {
        return beats;
    }

    public int getNo() {
        return no;
    }        
    
}
