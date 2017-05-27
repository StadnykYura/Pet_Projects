package rLE_encoding_decoding;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo {

	
	public static void main(String[] args) {
	
		ApplicationRLEmy.main(new String [] {"Hhhhhhhhhhhhhheeeellooooo"});
		ApplicationRLEmy.main(new String [] {""});
		ApplicationRLEmy.main(new String [] {"ababasd adsadasd Adad"});
		ApplicationRLEmy.main(new String [] {"CCappucinnoooooooooo"});
		ApplicationRLEmy.main(new String [] {"Hhhhhhhhhhhhhheeeellllo"});
		
		ApplicationRLE.main(new String [] {"Hhhhhhhhhhhhhheeeellooooo"});
		ApplicationRLE.main(new String [] {""});
		ApplicationRLE.main(new String [] {"ababasd adsadasd Adad"});
		ApplicationRLE.main(new String [] {"CCappucinnoooooooooo"});
		ApplicationRLE.main(new String [] {"Hhhhhhhhhhhhhheeeellllo"});
		System.out.println();
		
		DecodingRLE.main(new String [] {"Hh9h4e4l2o5"});
		DecodingRLE.main(new String [] {""});
		DecodingRLE.main(new String [] {"5Hh9h4e4l2o5"});
		DecodingRLE.main(new String [] {"HHh9hh4e4l2o5"});
		DecodingRLE.main(new String [] {"Hh99h4e4l2o5"});
		DecodingRLE.main(new String [] {"h"});
		DecodingRLE.main(new String [] {"h2"});
		DecodingRLE.main(new String [] {"h3"});
		DecodingRLE.main(new String [] {"h4"});
		DecodingRLE.main(new String [] {"h5"});
		DecodingRLE.main(new String [] {"h6"});
		DecodingRLE.main(new String [] {"h7"});
		DecodingRLE.main(new String [] {"h8"});
		DecodingRLE.main(new String [] {"h9"});
		DecodingRLE.main(new String [] {"h9h"});
		DecodingRLE.main(new String [] {"h9h2"});
		DecodingRLE.main(new String [] {"h9h3"});
		DecodingRLE.main(new String [] {"h2ef"});
		DecodingRLE.main(new String [] {"hh"});
		DecodingRLE.main(new String [] {"Hh90helo"});
		DecodingRLE.main(new String [] {"123"});
		DecodingRLE.main(new String [] {"9f4t5"});
		DecodingRLE.main(new String [] {"f3k2z"});
		DecodingRLE.main(new String [] {"-=="});
		DecodingRLE.main(new String [] {"-=2"});
		DecodingRLE.main(new String [] {"h22"});
		DecodingRLE.main(new String [] {"h2h2"});
		DecodingRLE.main(new String [] {"h2h23"});
	
		
		char a = '9';
		char b = '0';
		int quant = a - b;
		System.out.println(quant);
		System.out.println((int)a);
		System.out.println((int)b);
		System.out.println((int)a - (int)b);
		System.out.println(b);
		b += 6;
		System.out.println(b);
		char c = 0;
		System.out.println(c);
		c += 72;
		System.out.println(c);
		System.out.println((char)(c+1));
		char arr [] = new char [2];
		System.out.println(1);
		System.out.println(arr[0]);
		arr[0] = 0;
		for (int i = 0; i < 72; i++) {
			arr[0]++;
		}
		
		System.out.println(arr[0]);
		
		arr[0] = c;
		arr[1] = c;
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
		
		String stri = new String(arr);
		System.out.println(stri);
		
		StringBuilder sb = new StringBuilder();
		sb.append(arr[0]);
		sb.append(arr[1]);
		System.out.println(sb);
		
		arr[0] +=1;
		System.out.println(arr[0]);
		arr[0]++;
		System.out.println(arr[0]);
		
		Scanner sc = new Scanner(System.in);
		
		arr[0] = (char)sc.nextInt();
		System.out.println(arr[0]);
		
		  ArrayList<Integer> queue = new ArrayList<Integer>();
		  queue.add(10);
		  
		  int s = queue.remove(queue.size()-1);
		  System.out.println(s);
	}
	
	
}
