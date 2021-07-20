/*
 * ���� 10870 �Ǻ���ġ ��5
 * �Ǻ���ġ ���� 0�� 1�� �����ϰ� �� ���� 2��°���ʹ� �ٷ� �� �� �Ǻ���ġ ���� ���̵ȴ�
 * 0, 1, 1, 2 ,3, 5, 8, 13, 21 ...
 * 
 * n�� �־����� �� n��° �Ǻ���ġ ���� ���϶�
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