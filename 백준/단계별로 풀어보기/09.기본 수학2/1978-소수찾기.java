/*
 * 백준 1978 소수찾기
 * 주어진 수 N개 중에서 소수가 몇개인지 출력하는 프로그램
 * 
 * 소수를 구하는 방법은 3가지
 * 1. 2 ~ N-1까지 N과 나누었을때 나누어 떨어지는 수가 없는가?
 * 2. 2 ~ N의 제곱근까지 N과 나누었을때 나누어 떨어지는 수가 없는가?
 * 3. 2 ~ N의 제곱근까지의 배수를 찾으려는 수의 범위에서 제외하면 남는것은 소수이다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int t=Integer.parseInt(bf.readLine());
		StringTokenizer st=new StringTokenizer(bf.readLine());
		int count=0;
		
		for(int i =0;i<t;i++)
		{
			boolean isPrime = true;
			 
			int num=Integer.parseInt(st.nextToken());
			
			//1은 소수가아니다.
			if(num==1)
			{
				continue;
			}
			//Math.sqrt()는 제곱근을 구하는 함수 즉 2~제곱근까지수를 N과 나누어본다.
			for(int j=2;j<=Math.sqrt(num);j++)
			{
				//나누어떨어지는 수가 하나라도있으면 소수가아니므로 break
				if(num%j==0)
				{
					isPrime=false;
					break;
				}
			}
			if(isPrime)
				count++;
	
		}
		
		System.out.println(count);

		
	}
}
