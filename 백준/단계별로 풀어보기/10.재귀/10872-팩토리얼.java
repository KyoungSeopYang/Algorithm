/*
 * 백준 10872 팩토리얼
 * 
 * 정수 N이 주어졌을때 N!을 출력하는 프로그램
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int factorial(int n) {
		if(n<=1) return 1;
		return n*factorial(n-1);
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		System.out.println(factorial(n));
		
	}
}