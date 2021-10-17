import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] list;
	static boolean[] visited;
	static boolean[] finished;
	static int count;
	
	public static void main(String[] args)throws IOException {
	
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		while(T-->0) {
			count=0;
			int N=Integer.parseInt(br.readLine());
			
			list=new int[N+1];
			visited = new boolean[N+1];
			finished = new boolean[N+1];
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			for(int i=1;i<=N;i++) {
				list[i]=Integer.parseInt(st.nextToken());
			}
			
			for(int i=1;i<=N;i++) {
				dfs(i);
			}
			
			System.out.println(N-count);
			
		}	
	}
	
	static void dfs(int n) {
		if(visited[n]) return;
		
		visited[n] = true;
		int next = list[n];
		
		if(!visited[next])
			dfs(next);
		else {
			if(!finished[next]) {
				count++;
				for(int i=next;i !=n;i=list[i])
					count++;
			}
		}
		
		finished[n]=true;
	}
}