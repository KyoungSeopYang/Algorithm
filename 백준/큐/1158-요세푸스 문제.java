import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		
		sb.append("<");
		
		for(int i=1;i<=n;i++) {
			queue.add(i);
		}
		
		while(queue.size()!=1)
		{
			for(int i=1;i<k;i++) {
				queue.add(queue.poll());
			}
			sb.append(queue.poll()).append(", ");
		}
		
		sb.append(queue.poll()+">");
		
		System.out.println(sb);
	}
}    