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
		
		for(int line=0;line<n;line++) {		
			for(int dot=0;dot<2*n-line;dot++) {
				
				if(dot==2*n-line-1) {
					sb.append(" ");
					break;
				}
				
				if(dot>=line) {
					sb.append("*");
				} else {
					sb.append(" ");
				}
			}
			
			sb.append("\n");
		}
		
		for(int line=1;line<n;line++) {		
			for(int dot=0;dot<n+line+1;dot++) {
				
				if(dot==n+line) {
					sb.append(" ");
					break;
				}
				
				if(dot>=n-line-1) {
					sb.append("*");
				} else {
					sb.append(" ");
				}
			}
			
			sb.append("\n");
		}
		
		System.out.print(sb);
		
	}
	
}