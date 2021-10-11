import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		
		long a=Long.parseLong(st.nextToken());
		long b=Long.parseLong(st.nextToken());
		
		long output=gcd(a,b);
		
		for(int i=0;i<output;i++) {
			sb.append(1);
		}
		
		System.out.print(sb);
		
	}
	
	public static long gcd(long a,long b) {
		while(b!=0){
			long r=a%b;
			
			a=b;
			b=r;
		}
		
		return a;
		
	}
	
}    