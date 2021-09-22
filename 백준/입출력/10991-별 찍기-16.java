package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		/*
		 * line 수가 n이면 출력갯수는 n+1+i
		 * n-1-i만큼 공백을 넣고 시작
		 * 그후 바로 "*"넣고 " "넣고를 i+1만큼 반복한다. 
		 */
		for(int i=0;i<n;i++) {	
			
			for(int t=0;t<n-1-i;t++) {
				sb.append(" ");
			}
			
			for(int j=0;j<i+1;j++) {
				sb.append("*").append(" ");
			}
			
			sb.append("\n");
		}
		
		System.out.print(sb);
		
	}
	
}