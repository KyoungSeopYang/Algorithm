import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int M=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		
		boolean[] isPrime=new boolean[N+1];
		
		isPrime[0]=isPrime[1]=true;
		
		for(int i=2;i<=Math.sqrt(isPrime.length);i++) {
			if(isPrime[i]) continue;
			for(int j=i*i;j<isPrime.length;j+=i) {
				isPrime[j]=true;
			}
		}
		
		for(int i=M;i<=N;i++) {
			if(!isPrime[i]) sb.append(i).append('\n');
		}
		
		System.out.print(sb);
		
	}	
}    