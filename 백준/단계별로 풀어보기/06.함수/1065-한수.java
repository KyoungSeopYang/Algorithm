//백준 1065 한수
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		
		System.out.println(hansu(in.nextInt()));
		in.close();
	}
	
	public static int hansu(int num)
	{
		int cnt=0;
		
		//100보다 작은수는 모두 한수이다.
		if (num<100)
		{
			return num;
		}
		else {
			cnt =99;
			
			for(int i=100;i<=num;i++)
			{
				//각 자릿수 값 구하기
				int hun= i/100;
				int ten=(i/10)%10;
				int one=i%10;
				
				//각 자릿수가 등차수열인가?
				if(hun-ten==ten-one)
				{
					cnt++;
				}
			}
		}
		return cnt;
	}

}
