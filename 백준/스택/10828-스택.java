import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		StringBuilder sb=new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<N;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
				case "push" :
					stack.push(Integer.parseInt(st.nextToken()));
					break;
				case "pop" :
					if(stack.empty()==true)	sb.append(-1).append("\n");
					else 	sb.append(stack.pop()).append("\n");
					break;
				case "size" :
					sb.append(stack.size()).append("\n");
					break;
				case "empty" :
					if(stack.empty()==true)	sb.append(1).append("\n");
					else sb.append(0).append("\n");
					break;
				case "top" :
					if(stack.empty()==true)	sb.append(-1).append("\n");
					else 	sb.append(stack.peek()).append("\n");
					break;
			}
		}
		
		System.out.print(sb);
	}
}