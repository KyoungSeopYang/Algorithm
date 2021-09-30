package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args)throws IOException {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String N=br.readLine();
		int mod= 1000000;
		long[] dp= new long[N.length()+1];
		
		dp[0]=1;
		dp[1]=1;
		
		if(N.charAt(0)=='0') {
			System.out.println(0);
			return;
		}
		
		for(int i=1;i<N.length();i++) {
			char val = N.charAt(i-1);
			if(N.charAt(i)>='1' && N.charAt(i)<='9') {
				dp[i+1]+=dp[i];
				dp[i+1]%=mod;
			}
			if(!(val=='0' || val>'2' || (val=='2' && N.charAt(i)>'6'))) {
				//두글자가 될수 있다면
				dp[i+1] +=dp[i-1];
				dp[i+1]%=mod;
			}
			dp[i+1] %=mod;
		}
		System.out.println(dp[N.length()]%mod);
		
	}
}

