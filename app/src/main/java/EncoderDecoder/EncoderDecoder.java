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
		ArrayList<ArrayList<MorsePacket>> sentence = new ArrayList();
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
		String sentence="";
		for (int k = 0; k<input.size(); k++){
			String s = morseTable.get(input.get(k));
			if (!s.equals(null)){
				//System.out.println(s);
				sentence=sentence+s;
			}
		}
		
		return sentence;
	}
	
	private boolean isAlphaNumeric(String s){
	    String pattern= "^[a-zA-Z0-9 ]*$";
	        if(s.matches(pattern)){
	            return true;
	        }
	        return false;   
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}





