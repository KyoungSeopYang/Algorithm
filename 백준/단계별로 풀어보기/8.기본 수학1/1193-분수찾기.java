/*
 * 백준 1193 분수찾기
 * 이와 같이 나열된 분수들을 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> … 과 같은 지그재그 순서로 
 * 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.X가 주어졌을 때, X번째 분수를 구하는 프로그램
 * 
 * t= 분모 +분자
 * 대각선 배열의 수 = t-1
 * t가 홀수면 대각선 위부터 t가 짝수면 대각선 아래부터 읽는다.
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(bf.readLine());
		
		int t=2,sum=1;
		
		//n번째 분수가 해당하는 대각선 열까지의 t값과 분수의 합 값을 구한다.
		while(sum<n)
		{
			sum+=t;
			t++;
		}
		//짝수 홀수인지 판단
		if(t%2==0)
		{
			//sum-n이 대각선 끝점부터 n번째 까지의 거리이므로 분자와 분모값을 구할수 있다.
			System.out.println((1+(sum-n))+"/"+(t-1-(sum-n)));
		}else
		{
			System.out.println((t-1-(sum-n))+"/"+(1+(sum-n)));
		}
		
	}
}
