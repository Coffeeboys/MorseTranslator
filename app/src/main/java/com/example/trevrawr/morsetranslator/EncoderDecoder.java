import java.util.*;

public class EncoderDecoder {
	private final MorsePacket dot = new MorsePacket(true, 1);
	private final MorsePacket dash = new MorsePacket(true, 3);
	private final MorsePacket space = new MorsePacket(false, 6);//note: only 6, because adding 1
																//to each letter
	private final MorsePacket spaceBC = new MorsePacket(false, 3);//space between characters
	private final MorsePacket spaceBSC = new MorsePacket(false, 1);//space between same characters
	private HashMap<String, ArrayList<MorsePacket>> conversionTable = makeConversionTable();//conversion table
	
	
	//input: string
	//returns an ArrayList of ArrayList of MorsePackets
	public ArrayList<ArrayList<MorsePacket>> encode(String input){
		ArrayList<ArrayList<MorsePacket>> sentence = new ArrayList();
		input = input.toLowerCase();
		for (int k = 0; k<input.length(); k++){
			String s = input.substring(k, k+1);
			if (isAlphaNumeric(s)){
				sentence.add(conversionTable.get(s));
			}
		}
		return sentence;
	}
	
	private boolean isAlphaNumeric(String s){
	    String pattern= "^[a-zA-Z0-9]*$";
	        if(s.matches(pattern)){
	            return true;
	        }
	        return false;   
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private HashMap<String, ArrayList<MorsePacket>> makeConversionTable(){
		int capacity = 50;
		HashMap<String, ArrayList<MorsePacket>> conversionTable = new HashMap(capacity);
		
		//a
		ArrayList<MorsePacket> a = new ArrayList();
		a.add(dot);
		a.add(spaceBSC);
		a.add(dash);
		a.add(spaceBSC);
		a.add(spaceBC);//space between characters
		conversionTable.put("a", a);
		
		//s
		ArrayList<MorsePacket> s = new ArrayList();
		s.add(dot);
		s.add(spaceBSC);
		s.add(dot);
		s.add(spaceBSC);
		s.add(dot);
		s.add(spaceBC);//space between characters
		conversionTable.put("s", s);
		
		//o
		ArrayList<MorsePacket> o = new ArrayList();
		o.add(dash);
		o.add(spaceBSC);
		o.add(dash);
		o.add(spaceBSC);
		o.add(dash);
		o.add(spaceBC);
		conversionTable.put("o", o);
		
		//space
		ArrayList<MorsePacket> spaceX = new ArrayList();
		spaceX.add(space);
		conversionTable.put(" ", spaceX);
		
		return conversionTable;
	}
	
}





