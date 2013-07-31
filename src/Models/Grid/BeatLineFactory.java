package Models.Grid;

/**
 *
 * @author Group 21
 * This factory creates lines for sounds. for example a line for Piano.
 * Line holds beats, beats hold frames.
 */
public class BeatLineFactory {
    
    private static int no;
    private static int noBeats;
    private static boolean set;
    
    
    /**
     * By default 7 beats per line
     */
    public static void setDefaultFactory(){
        set=true;
        no=0;
        noBeats=7;
    }
    
    /**
     * Set factory to any number of beats per line.
     * @param noArg start counting beats from that number.
     * @param noBeatsArg beats per line
     */
    public static void setFactory(int noArg, int noBeatsArg){
        set=true;
        no=noArg;
        noBeats=noBeatsArg;
    }    
        
    /**
     * Creates Line
     * @return 
     */
    public static BeatsLine createLine(){
        if(!set){
            set=true;
            setDefaultFactory();
        }
        return new BeatsLine(no, noBeats);
    }
}
