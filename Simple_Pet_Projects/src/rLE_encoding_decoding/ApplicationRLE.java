package rLE_encoding_decoding;

public class ApplicationRLE {

	public static void main(String[] args) {
	
		
		StringBuilder result = new StringBuilder();
		if (args != null && args.length > 0 && args[0] != null && args[0].length() > 0) {
			char packingChar = 0;
			byte counter = 0;
			for (int i = 0; i < args[0].length(); i++){
				
				char currentChar = args[0].charAt(i);
				if (i == 0){
					packingChar = currentChar;
					counter = 1;
				} else if (counter >=9 || currentChar != packingChar ){
					result.append(packingChar);
					if (counter > 1){
						result.append(counter);
					}
					packingChar = currentChar;
					counter = 1;
				} else {
					counter++;
				}
			}
			result.append(packingChar);
			if (counter > 1)
			{
				result.append(counter);
			}
		}
		System.out.println(result);
		
		
	}
	
	
}