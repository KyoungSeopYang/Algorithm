/*
 * 백준 11653 소인수분해
 * 정수 N이 주어졌을 때 소인수분해하는 프로그램
 * N의 소인수 분해결과를 한줄에 하나씩 오름차순으로 출력한다 N이 1인경우 출력하지않는다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		
		//소수는 2부터 N의 제곱근까지만 구하면됨
		for(int i=2; i<=Math.sqrt(n); i++)	{
			while(n%i==0) {
				System.out.println(i);
				n /=i;
			}
		}
		
		if(n!=1) {
			System.out.println(n);
		}
	}
}
