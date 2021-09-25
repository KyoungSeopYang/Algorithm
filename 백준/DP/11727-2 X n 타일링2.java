package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	/*
	 * dp(n)=dp(n-1) + 2*dp(n-2)
	 * n-1의 경우의 수에 2 X 1 타일을 붙이는경우 + n-2의 경우의 수에 2 X 2블럭 이랑 1 X 2 블럭 두개를 붙이는 경우의 수
	 */
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		int[] dp=new int[n+2];
		
		dp[1]=1;
		dp[2]=3;
		
		for(int i=3;i<=n;i++){
			dp[i]=(dp[i-1]+2*dp[i-2])%10007;
		}
		
		System.out.print(dp[n]);
	}
	
}
