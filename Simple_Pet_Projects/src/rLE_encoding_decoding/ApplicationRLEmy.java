package rLE_encoding_decoding;

public class ApplicationRLEmy {

	public static void main(String[] args) {
		

		
//		char [] chars;
//		chars = args[0].toCharArray();
//		for (int i = 0; i < chars.length; i++) {
//			System.out.print(chars[i] + ", ");
//		}
//		
//		System.out.println();
		int cnt = 1;
		
		
		if (args[0].equals("")) {
			System.out.println("");
		} else if (args[0].length()==1 && !(args[0].equals(""))){
			System.out.println(args[0].charAt(0));
		} else if (args[0].length() == 2){
			if(args[0].charAt(0) != args[0].charAt(1)){
				System.out.print(args[0]);
			} else if (args[0].charAt(0) == args[0].charAt(1)){
				cnt++;
				System.out.println("" + args[0].charAt(0) + cnt);
				cnt = 1;
			} 
		} else if (args[0].length() > 2){
			String arg = "";
			for (int i = 0; i < args[0].length()-1; i++) {
				if (args[0].charAt(i) != args[0].charAt(i+1)){
					
					if (cnt > 1){
						if ((i+1) == args[0].length()-1) {
							arg += "" + args[0].charAt(i) + cnt + args[0].charAt(i+1);
						} else {
							arg += "" + args[0].charAt(i) + cnt;
							cnt = 1;
						}
					} else if ((i+1) == args[0].length()-1) {
						arg += "" + args[0].charAt(i) + args[0].charAt(i+1);
					} else {
						arg += "" + args[0].charAt(i);
					}
				
				} else if (args[0].charAt(i) == args[0].charAt(i+1)) {
					cnt++;
					if (cnt == 9){
						if ((i+2) == args[0].length()-1){
							arg += "" + args[0].charAt(i) + cnt + args[0].charAt(i+1);
							i++;
						} else {
							arg += "" + args[0].charAt(i) + cnt;
							cnt = 1;
							i++;
						}
						
					}  else if ((i+1) == args[0].length()-1) {
						arg += "" + args[0].charAt(i+1) + cnt;
					} 
				}
			}
			System.out.println(arg);
		}
		
		
//		if (args[0].length() > 2){
//			for (int i = 0; i < args[0].length()-1; i++) {
//				if (args[0].charAt(i) != args[0].charAt(i+1)){
//					
//					if (cnt > 1){
//						System.out.print("" + args[0].charAt(i) + cnt);
//						cnt = 1;
//					} else {
//						System.out.print(args[0].charAt(i));
//					}
//				
//				} else if (args[0].charAt(i) == args[0].charAt(i+1)) {
//					cnt++;
//					if (cnt == 9){
//						System.out.print("" + args[0].charAt(i+1) + cnt);
//						cnt = 1;
//						i++;
//					}
//				}
//			}
//		
//		}
//		System.out.println();
		
//		if (chars.length > 2){
//			for (int i = 0; i < chars.length-1; i++) {
//				if (chars[i] != chars[i+1]){
//					
//					if (cnt > 1){
//						System.out.print("" + chars[i] + cnt);
//						cnt = 1;
//					} else {
//						System.out.print(chars[i]);
//					}
//					
//				} else if (chars[i] == chars[i+1]) {
//					cnt++;
//					if (cnt == 9){
//						System.out.print("" + chars[i+1] + cnt);
//						cnt = 1;
//						i++;
//					}
//					
//				}
//			}
//		
//		}
//		System.out.println();
		
		
	}
		
}
