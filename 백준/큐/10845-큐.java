import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		
		LinkedList<Integer> queue =new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
			
			case "push" :
				queue.add(Integer.parseInt(st.nextToken()));
				break;
				
			case "pop" :
				if(queue.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(queue.poll()).append('\n');
				}
				break;
				
			case "size" :
				sb.append(queue.size()).append('\n');
				break;
				
			case "empty" :
				if(queue.isEmpty()) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
				break;
				
			case "front" :
				if(queue.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(queue.peekFirst()).append('\n');
				}
				break;
				
			case "back" :
				if(queue.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(queue.peekLast()).append('\n');
				}
				break;	
			}
		}
		
		System.out.println(sb);
	}
}    