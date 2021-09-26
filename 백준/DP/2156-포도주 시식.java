package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args)throws IOException {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		
		int[] dp=new int[num+1];
		int[] arr=new int[num+1];
		
		for(int arr_len=1;arr_len<=num;arr_len++) {
			arr[arr_len]=Integer.parseInt(br.readLine());
		}
		dp[1]=arr[1];
		
		if(num>1) {
			dp[2]=arr[1]+arr[2];
		}
		
		for(int arr_len=3;arr_len<=num;arr_len++) {
			dp[arr_len]=Math.max(dp[arr_len-1], Math.max(dp[arr_len-2]+arr[arr_len],dp[arr_len-3]+arr[arr_len-1]+arr[arr_len]));
		}
	
		System.out.println(dp[num]);
	}
}
