package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		
		for(int i=1;i<10;i++) {
			sb.append(num +" * " +i).append(" = " +num*i).append("\n");
		}
		System.out.println(sb);
	}
}