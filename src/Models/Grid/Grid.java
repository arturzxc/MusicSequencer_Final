
package Models.Grid;

import java.util.ArrayList;

/**
 *
 * @author Group 21
 * Grid hold all the lines, beats and frames. 
 */
public class Grid {
    private ArrayList<BeatsLine> beatsLines = new ArrayList<BeatsLine>();//lines of beats.
    
    private int noBeatLines;
    private int noBeats;
    private int noFrames;

    /**
     * default constructor of the Grid.
     * @param noBeatLines
     * @param noBeats
     * @param noFrames 
     */
    public Grid(int noBeatLines, int noBeats, int noFrames) {
        this.noBeatLines = noBeatLines;
        this.noBeats = noBeats;
        this.noFrames = noFrames;
        setFactories();
        addInitBeatLines();
    }   
    
    /**
     * set factories for the production types. by default frame factory will produce piano frames.
     */
    private void setFactories(){
        BeatLineFactory.setFactory(0, noBeats);
        BeatFactory.setFactory(0, noFrames);
        FrameFactory.setProductionToPiano();        
    }
    
    /**
     * Adds initial lines of beats.
     */
    private void addInitBeatLines(){
        for(int i=0;i<noBeatLines;i++){
            beatsLines.add(new BeatsLine(i, noBeats));
        }
    }
    
    public ArrayList<BeatsLine> getBeatsLines() {
        return beatsLines;
    }

    public int getNoBeatLines() {
        return noBeatLines;
    }

    public int getNoBeats() {
        return noBeats;
    }

    public int getNoFrames() {
        return noFrames;
    }
    
    /**
     * Gets all the frames from the row. This is useful when playing sounds as we don't care about the beats.
     * @param n
     * @return 
     */
    public ArrayList<Frame> getFramesInRow(int n){
        BeatsLine beats = beatsLines.get(n);
        ArrayList<Frame> frames = new ArrayList<Frame>();

            for(int j=0;j<beats.getBeats().size();j++)
                for(int g =0;g<beats.getBeats().get(j).getFrames().size();g++){
                    frames.add(beats.getBeats().get(j).getFrames().get(g));
                }
        
        return frames;
    }
    
    
}
