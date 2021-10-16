import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] check;
	static int[] node;
	static int[] direction;
	static int count;
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		while(T-->0) {
			int N=Integer.parseInt(br.readLine());
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			check = new boolean [N+1];
			node = new int[N+1];
			direction = new int [N+1];
			count = 0;
			
			for(int i=1;i<=N;i++) {
				node[i]=i;
				direction[i]=Integer.parseInt(st.nextToken());
			}
			
			for(int i=1;i<=N;i++) {
				if(!check[i])
					dfs(i);
			}
			System.out.println(count);
		}
	}
	
	public static void dfs(int n) {
		if(!check[direction[n]]) {
			check[direction[n]]=true;
			dfs(direction[n]);
		} else {
			count +=1;
		}

	}
}