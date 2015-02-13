import java.util.ArrayList;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EncoderDecoder test = new EncoderDecoder();
		String input = "sos ";
		ArrayList<ArrayList<MorsePacket>> theInput = test.encode(input);
		for (int k=0; k<theInput.size(); k++){
			for (int i=0; i<theInput.get(k).size(); i++){
				System.out.println(theInput.get(k).get(i).toString());
			}
		}
	}

}
