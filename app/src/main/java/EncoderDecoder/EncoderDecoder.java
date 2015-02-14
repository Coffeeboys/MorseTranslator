package EncoderDecoder;

import java.util.*;

public class EncoderDecoder {

	private final HashMap<String, ArrayList<MorsePacket>> alphaTable = ConversionTableMaker.makeAlphaTable();
	//conversion table from alpha to MorsePacket
	private final HashMap<ArrayList<MorsePacket>, String> morseTable = ConversionTableMaker.makeMorseTable();
	//conversion table from MorsePackets to alphabet
	
	//input: string
	//returns an ArrayList of ArrayList of MorsePackets
	public ArrayList<ArrayList<MorsePacket>> encode(String input){
		ArrayList<ArrayList<MorsePacket>> sentence = new ArrayList<ArrayList<MorsePacket>>();
		input = input.toLowerCase();
		for (int k = 0; k<input.length(); k++){
			String s = input.substring(k, k+1);
			if (isAlphaNumeric(s)){
				sentence.add(alphaTable.get(s));
			}
		}
		return sentence;
	}
	
	//input: Arraylist of Arraylist of MorsePackets
	//returns: String
	public String decode(ArrayList<ArrayList<MorsePacket>> input){
	/*	String sentence="";
		//for (int k = 0; k<input.size(); k++){
		for (ArrayList<MorsePacket> k: input) {
			//String s = morseTable.get(input.get(k));
			String s = morseTable.get(k);
			System.out.println(s);
			//System.out.println(input.get(k));
			if (!s.equals(null)){
				System.out.println(s);
				sentence=sentence+s;
			}
		}
		
		return sentence;*/
		

            for (ArrayList<MorsePacket> p: ConversionTableMaker.packetList) {
                if (input.get(0).size() == p.size() ) {
                    for (int i = 0; i < input.get(0).size(); ++i) {
                        if (input.get(0).get(i).getState() != p.get(i).getState() &&
                                input.get(0).get(i).getDuration() != p.get(i).getDuration()) {
                            //System.out.println(morseTable.get(ConversionTableMaker.s));
                            break;
                        }
                    }

            }
			//if (input.get(0).get(i).getState() != ConversionTableMaker.s.get(i).getState() ||
				//	input.get(0).get(i).getDuration() != ConversionTableMaker.s.get(i).getDuration()) {
//			if (input.get(0).get(i).getState() != true &&
//				input.get(0).get(i).getDuration() != 1) {
//				//System.out.println(morseTable.get(ConversionTableMaker.s));
//				break;
//			}
			System.out.println(morseTable.get(ConversionTableMaker.s));
			
			return morseTable.get(ConversionTableMaker.s);
		}
		
		/*String sentence = "";
		for (int k = 0; k<input.size(); k++){
			for (int i = 0; i<input.get(k).size(); i++){
				
				
				MorsePacket in = input.get(k).get(i);
				
				//s
				if (in.getState()==true && in.getDuration()==1){
					//dot
				}
				if (in.getState()==true && in.getDuration()==0){
					//
				}
			}
			
		}*/
		
		
	
		
		
		
		
		
		return null;
	}
	
	private boolean isAlphaNumeric(String s){
	    String pattern= "^[a-zA-Z0-9 ]*$";
	        if(s.matches(pattern)){
	            return true;
	        }
	        return false;   
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}





