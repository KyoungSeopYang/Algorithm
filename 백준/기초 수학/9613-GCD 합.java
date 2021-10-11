import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int T=Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			int N=Integer.parseInt(st.nextToken());
			int[] arr=new int[N];
			
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			long sum=0;
			
			for(int i=0;i<N;i++) {
				for(int j=i;j<N;j++) {
					if (i!=j) {
						sum+=gcd(arr[i],arr[j]);
					}
				}
			}
			sb.append(sum).append('\n');
		}
		System.out.print(sb);
	}
	
	public static int gcd(int a,int b) {
		while(b!=0){
			int r=a%b;
			
			a=b;
			b=r;
		}
		
		return a;
		
	}
	
}    