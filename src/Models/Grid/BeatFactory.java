package Models.Grid;

/**
 *
 * @author Group 21
 * A factory that produces Beats and keeps track of their numbers.
 */
public class BeatFactory {
    private static int no;
    private static int frameNo;
    private static boolean set;
    
    
    /**
     * The default setting of the factory is 5 frames per beat.
     */
    public static void setDefaultFactory(){
        set=true;
        no=0;
        frameNo=5;
    }
    
    /**
     * This method sets the factory to produce any number of frames per beat.
     * @param noArg frames numbering will start from this number. by default it is 0
     * @param frameNoArg number of frames per beat.
     */
    public static void setFactory(int noArg, int frameNoArg){
        set=true;
        no=noArg;
        frameNo=frameNoArg;
    }
    
    /**
     * Creates beat 
     * @return beat.
     */
    
    public static Beat createBeat(){
        if(!set){
            set=true;
            setDefaultFactory();
        }
        return new Beat(no, frameNo);
    }
    
}
