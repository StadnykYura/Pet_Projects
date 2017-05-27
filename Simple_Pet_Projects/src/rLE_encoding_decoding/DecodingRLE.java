package rLE_encoding_decoding;

public class DecodingRLE {

	
	public static void main(String[] args) {
		
		
		StringBuilder result = new StringBuilder();
		
		if (args != null && args.length>0 && args[0] != null && args[0].length() >0) {
			
			char previosChar = 0;
			int counter = 0;
			char [] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};			
	
			for (int i = 0; i < args[0].length(); i++) {
				
				char currentChar = args[0].charAt(i);
				
				if (i == 0){
					for (int j = 0; j < numbers.length; j++) {
						if (currentChar == numbers[j]){
							System.out.println(result);
							return;
						}
					}
					previosChar = currentChar;
				continue;
				} else if (currentChar != previosChar && counter == 0){
					for (int j = 0; j < numbers.length; j++) {
						
						if (currentChar == numbers[j]){
							counter = j;
							for (int k = 0; k < j; k++) {
								result.append(previosChar);
							}	
							previosChar = currentChar;
							break;
						}
					}
					if (counter == 0){
						result.append(previosChar);
						previosChar = currentChar;
					}
					if (i == args[0].length()-1){
						boolean exist = true;
						for (int j = 0; j < numbers.length; j++) {
							if (currentChar == numbers[j]) {
								exist = false;
							}
						}
						if (exist){
							result.append(currentChar);
						}
						
					}
				} else if (currentChar != previosChar && counter > 0){
					for (int j = 0; j < numbers.length; j++) {
						if (currentChar == numbers[j]){
							for (int j2 = 0; j2 < numbers.length; j2++) {
								if (previosChar == numbers[j2]){
									System.out.println("");
									return;
								}
							}
						}
					}
					counter = 0;
					previosChar = currentChar;
					
					if (i == args[0].length()-1){
						result.append(currentChar);
					}
				} else {
					System.out.println("");
					return;
				}
				
				
				
			}
			if (args[0].length()==1){
				result.append(args[0].charAt(0));	
			}
			
			
		}
		System.out.println(result);
		
		
	}
	
	
}
