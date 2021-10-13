import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		//N! 의 2,5 승수, (n-m)! 승수 m!승수
		
		long count5=five_n(N)-five_n(N-M)-five_n(M);
		long count2=two_n(N)-two_n(N-M)-two_n(M);
		
		System.out.println(Math.min(count5, count2));
	}
	
	static long five_n(long num) {
		int count=0;
		
		while(num>=5) {
			count +=num/5;
			num/=5;
		}
		return count;
	}
	
	static long two_n(long num) {
		int count=0;
		
		while(num>=2) {
			count +=num/2;
			num/=2;
		}
		return count;
	}
}     