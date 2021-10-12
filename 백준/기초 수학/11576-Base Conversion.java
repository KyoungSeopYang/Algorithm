import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		 Scanner scanner = new Scanner(System.in);

	        Stack<Integer> result = new Stack<>();

	        int A = scanner.nextInt();
	        int B = scanner.nextInt();
	        int aLength = scanner.nextInt();

	        int demical = 0;
	        for (int i=aLength-1; i>=0; i--) {
	            int number = scanner.nextInt();
	            int multi = (int)Math.pow(A, i);
	            demical += (number * multi);
	        }

	        while (demical != 0) {
	            result.push(demical%B);
	            demical = demical/B;
	        }

	        int resultSize = result.size();
	        for (int i=0; i<resultSize; i++) {
	            if(i == resultSize-1) {
	                System.out.print(result.pop());
	            } else {
	                System.out.print(result.pop() + " ");
	            }
	        }
	    }
	}