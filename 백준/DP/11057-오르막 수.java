package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args)throws IOException {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		long[][] dp=new long[n+1][10];
		
		for(int i=0;i<10;i++) {
			dp[1][i]=1;
		}
		
		for(int i=2;i<=n;i++){
			long result = 0;
			
			for(int j=0;j<10;j++) {
				result +=dp[i-1][j]%10007;
			}
			
			for(int j=0;j<10;j++) {
				if(j==0) {
					dp[i][0]=result%10007;
				}
				else {
					result -= dp[i-1][j-1];
					dp[i][j]=result%10007;
				}
			}		
		}
		
		long result = 0;
		for(int j=0;j<10;j++) {
			result +=dp[n][j]%10007;
		}
		
		System.out.println(result%10007);
	}
}
