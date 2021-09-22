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
		 * line ���� n�̸� ��°����� n+1+i
		 * n-1-i��ŭ ������ �ְ� ����
		 * ���� �ٷ� "*"�ְ� " "�ְ� i+1��ŭ �ݺ��Ѵ�. 
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