import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] list;
	static int N;
	static boolean check[];
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int start=Integer.parseInt(st.nextToken());
		
		list=new ArrayList[N+1];
	
		for(int i=1;i<=N;i++) {
			list[i]=new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {	
			st= new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			
			list[u].add(v);
			list[v].add(u);
		}
		
		for (int i = 1; i < N + 1; i++) {
            Collections.sort(list[i]);
        }
		
		check=new boolean[N+1];
		dfs(start);
		System.out.println();
		
		check=new boolean[N+1];
		bfs(start);
		System.out.println();
    }
	
	public static void dfs(int x) {
		if (check[x]) return;
		
		check[x]=true;
		System.out.print(x+" ");
		for(int y:list[x]) {
			if(!check[y]) dfs(y);
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue =new LinkedList<Integer>();
		queue.add(start);
		check[start]=true;
		
		while(!queue.isEmpty()) {
			int x=queue.poll();
			System.out.print(x+" ");
			for(int y:list[x]) {
				if(!check[y]) {
					check[y]=true;
					queue.add(y);
				}
			}
		}
	}
}