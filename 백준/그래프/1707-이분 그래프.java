import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		while(T--> 0) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			
			ArrayList<Integer>[] list =new ArrayList[N+1];
			int[] check=new int[N+1];
			
			for(int i=1;i<=N;i++) {
				list[i]=new ArrayList<Integer>();
			}
			
			for(int i=0;i<M;i++) {
				st=new StringTokenizer(br.readLine());
				int u=Integer.parseInt(st.nextToken());
				int v=Integer.parseInt(st.nextToken());
				
				list[u].add(v);
				list[v].add(u);
			}
					
			boolean flag=true;
			Queue<Integer> queue=new LinkedList<>();
			
			for(int i=1;i<=N;i++) {
				if(check[i]==0) {
					queue.add(i);
					check[i]=1;
					
					while(!queue.isEmpty() && flag) {
						int cur = queue.poll();
						
						for(int next : list[cur]) {
							if(check[next] ==0) {
								queue.add(next);
								check[next]=check[cur]*-1;
							} else if (check[next]==check[cur]) {
								flag=false;
								break;
							}
						}
					}
				}
			}
			if(flag) System.out.println("YES");
			else	System.out.println("NO");
		}
	}
}