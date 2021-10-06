import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<N;i++) {
			sb.append(solve(br.readLine())).append('\n');
		}
		
		System.out.print(sb);
	}
	
	public static String solve(String str) {
		Stack<Character> stack = new Stack<>();
		
		for(int j=0;j<str.length();j++) {
			char c=str.charAt(j);
			
			if(c=='(') {
				stack.push(c);
			}
			
			else if(stack.empty()) {
				return "NO";
			}
			else {
				stack.pop();
			}
		}
		
		if (stack.empty()) {
			return "YES";
		}
		else {
			return "NO";
		}
	}
}    