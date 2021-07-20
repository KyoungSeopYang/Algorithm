/*
 * 백준 5622 다이얼
 */
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args)throws IOException {
		Scanner sc=new Scanner(System.in);
		String input=sc.nextLine();
		int output =0;
		
		for(int i=0;i<input.length();i++) {
			switch(input.charAt(i)) {
			
			case 'A': case 'B': case 'C':
				output+=3;
				break;
				
			case 'D': case 'E': case 'F':
				output+=4;
				break;
				
			case 'G': case 'H': case 'I':
				output+=5;
				break;
				
			case 'J': case 'K': case 'L':
				output+=6;
				break;
				
			case 'M': case 'N': case 'O':
				output+=7;
				break;
				
			case 'P': case 'Q': case 'R': case 'S' :
				output+=8;
				break;
				
			case 'T': case 'U': case 'V':
				output+=9;
				break;
				
			case 'W': case 'X': case 'Y': case 'Z' :
				output+=10;
				break;
			}
		}
		
		System.out.println(output);
	}
}
