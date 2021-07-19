/*
 * 백준 2231 분해합
 * 자연수 N이 주어질때 분해합은 N과 N을 이루는 각 자리수의 합이고 어떤 자연수 M의 분해합이  N인경우 M을 N의 생성자라고 할때
 * 가장 작은 생성자를 구해내는 프로그램
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		
		int n=Integer.parseInt(br.readLine());
		
		int num=0;
		
		while(num<n) {
			
			int m=num;
			int sum=m;
			
			while(m>=1) {
				sum +=m%10;
				m/=10;
			}
			
			if (sum==n) {
				System.out.println(num);
				return;
			}
			num++;
		}
		System.out.println(0);
	}
	
}