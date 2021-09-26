package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int test_case=Integer.parseInt(br.readLine());
		
		for(int test_num=0;test_num<test_case;test_num++) {
			
			int input_num=Integer.parseInt(br.readLine());
			
			long[][] dp=new long[2][input_num+1];
			int[][] score_arr=new int[2][input_num+1];
			
			for(int column=0;column<2;column++) {
				StringTokenizer st=new StringTokenizer(br.readLine());	
				
				for(int row=0;row<input_num;row++) {
					score_arr[column][row]=Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][0]=score_arr[0][0];
			dp[1][0]=score_arr[1][0];
			dp[0][1]=dp[1][0]+score_arr[0][1];
			dp[1][1]=dp[0][0]+score_arr[1][1];
			
			for(int row=2;row<=input_num;row++) {
				dp[0][row]=Math.max(dp[1][row-1],dp[1][row-2]) + score_arr[0][row];
				dp[1][row]=Math.max(dp[0][row-1],dp[0][row-2]) + score_arr[1][row];
			}
			
			System.out.println(Math.max(dp[0][input_num], dp[1][input_num]));
			
		}	
	
	}
}
