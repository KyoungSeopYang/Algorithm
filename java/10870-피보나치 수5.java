/*
 * 백준 10870 피보나치 수5
 * 피보나치 수는 0과 1로 시작하고 그 다음 2번째부터는 바로 앞 두 피보나치 수의 합이된다
 * 0, 1, 1, 2 ,3, 5, 8, 13, 21 ...
 * 
 * n이 주어졌을 때 n번째 피보나치 수를 구하라
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int fibonacci(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
		
		return fibonacci(n-1)+fibonacci(n-2);
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		System.out.println(fibonacci(n));
		
	}
}