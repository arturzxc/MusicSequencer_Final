package Models;

/*
class containing static methods to generate sample playback ratios for the transposition
of musical sounds.

methods accept an initial sample pitch and a positive or negative transposition increment, 
either in cents or semitones

e.g., to find the sample playback ratio to transpose a  sample recorded at middle A (440 hz) 
upwards in pitch by a fith (7 semitones or 700 cents) we would use

PitchRatioCalculator.centRatio(440, 700);   // for cents

or

PitchRatioCalculator(semitoneRatio(440, 7);   // for semitones
using cents allows us to work in microtones

Internal calculations in Double form, then cast to Float for compatibility with the
Beads audio library


Code by Robin Fencott, based on calculations from
http://www.birdsoft.demon.co.uk/music/samplert.htm


*/

class PitchRatioCalculator {
	public static float centRatio(double initialSamplePitch, double centIncrement){
		
		double ratio;
		double targetPitch;
		
		targetPitch = initialSamplePitch * Math.pow(2.0, (centIncrement / 1200.0 ));
		ratio = targetPitch / initialSamplePitch;		
		return (float)ratio;
	}

	public static float semitoneRatio(double initialSamplePitch, double semitoneIncrement){
		return centRatio(initialSamplePitch, semitoneIncrement*100);	
	}		
}