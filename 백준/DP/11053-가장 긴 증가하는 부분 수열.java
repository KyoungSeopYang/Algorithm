package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int[] seq= new int[N];
		int[] dp= new int[N];
		
		for(int i=0;i<N;i++) {
			seq[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			dp[i]=1;
			
			//j번째 원소가 i번째 원소보다 작은 수이면서 i번째 dp가 j번째 dp+1보다 값이 작은경우
			for(int j=0;j<i;j++) {
				if(seq[j]<seq[i] && dp[i]<dp[j]+1) {
					dp[i]=dp[j]+1;
				}
			}
		}
		
		int max=-1;
		for(int i=0;i<N;i++) {
			max=dp[i]>max ? dp[i]:max;
		}
		System.out.println(max);
		
	}
}
