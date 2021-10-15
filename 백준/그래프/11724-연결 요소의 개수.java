import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] list;
	static boolean[] check;
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int count=0;
		
		list =new ArrayList[N+1];
		
		for(int i=1;i<=N;i++) {
			list[i]=new ArrayList<Integer>();
		}
		
		check=new boolean[N+1];
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			
			list[u].add(v);
			list[v].add(u);
		}
				
		for(int i=1;i<=N;i++) {
			
			if(!check[i]) {
				dfs(i);
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	public static void dfs(int x) {
		if(check[x]) return;
		
		check[x]=true;
		
		for(int y:list[x]) {
			if(!check[y]) dfs(y);
		}
	}
}