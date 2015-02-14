package EncoderDecoder;

public class MorsePacket {
	public static final int TIME_UNIT=500;
	private int duration;
	private boolean state;
	
	//first param: the state of the morse, on/off
	//second param: the multiple of the TIME_UNIT
	public MorsePacket(boolean a, int b){
		duration = b*TIME_UNIT;
		state = a;
	}
	//first param: the state of the morse, on/off
	//second param: the multiple of the TIME_UNIT
	//third param: the new TIME_UNIT
	public MorsePacket(boolean a, int b, int c){
		duration = b*c;
		state = a;
	}
	public int getDuration(){
		return duration;
	}
	public boolean getState(){
		return state;
	}
	public String toString(){
		return "Duration is: " +duration+" State is: "+state;
	}
}
