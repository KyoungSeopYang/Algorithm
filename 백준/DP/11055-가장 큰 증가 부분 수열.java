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
		
		dp[0]=seq[0];
		for(int i=1;i<N;i++) {
			for(int j=0;j<i;j++) {
				if(seq[i]>seq[j] && dp[i]<dp[j]) {
					dp[i]=dp[j];
				}
			}
			dp[i]+=seq[i];
		}
		
		int result=0;
		
		for(int i=0;i<N;i++) {
			result=Math.max(result, dp[i]);
		}
		System.out.println(result);
	}
}
