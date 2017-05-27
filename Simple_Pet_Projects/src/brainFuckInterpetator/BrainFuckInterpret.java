package brainFuckInterpetator;

import java.util.Scanner;

public class BrainFuckInterpret {

	public static void main(String[] args) {

		StringBuilder result = new StringBuilder();

		if (args != null && args[0] != null && args[0].length() > 0) {
			int counterCurrentChar = 0;
			
			char arrChar [] = new char[args[0].length()];
			Scanner sc = new Scanner(System.in);
			for (int i = 0; i < args[0].length(); i++) {

				char currentChar = args[0].charAt(i);

				switch (currentChar) {
				case '>':
					counterCurrentChar++; 
					break;
				case '<':
					counterCurrentChar--;
					break;
				case '+':
					arrChar[counterCurrentChar]++;
					break;
				case '-':
					arrChar[counterCurrentChar]--;
					break;
				case '.':
					result.append(arrChar[counterCurrentChar]);
					//System.out.print(arrChar[counter]);
					break;
				case ',':
					System.out.println("Write down a number from 0 to 65536");
					arrChar[counterCurrentChar] = (char)sc.nextInt();
					break;
				case '[':
						int count1 = 1;
					if (arrChar[counterCurrentChar] == 0){
						int j1 = i+1;
						for (; j1 < args[0].length(); j1++) {
							if (args[0].charAt(j1) == '[') {
								count1++;
							} else if (args[0].charAt(j1) == ']') {
								count1--;
							} else if (count1 == 0) {
								break;
							}
						}
						i = j1;
					} else {
						break;
					}
					break;
					
				case ']':
					int count2 = 1;
					if (arrChar[counterCurrentChar] != 0){
						int j2 = i-1;
						for (; j2 > 0; j2--) {
							if(args[0].charAt(j2) == ']') {
								count2++;
							} else if (args[0].charAt(j2) == '['){
								count2--;
							} else if (count2 == 0){
								break;
							}
						}
						i = j2;
					} else {
						break;
					}
					break;
				default:
					break;
				}

			}

		}
		System.out.println(result);

	}
}
