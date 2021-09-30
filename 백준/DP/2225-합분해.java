package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int mod=1000000000;
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		long[][] dp=new long[201][201];
		
		for(int i=0;i<201;i++) {
			dp[i][0]=1;
			dp[1][i]=1;
		}
		for(int i=1;i<201;i++) {
			dp[2][i]=i+1;
		}
		for(int i=3;i<201;i++) {
			for(int j=1;j<201;j++) {
				for(int k=0;k<=j;k++) {
					dp[i][j]+=dp[i-1][j-k]%mod;
				}
			}
		}
		System.out.print(dp[K][N]%mod);
		
	}
}

