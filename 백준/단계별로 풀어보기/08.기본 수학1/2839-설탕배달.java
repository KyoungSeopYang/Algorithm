/*
 * 백준 2839 설탕배달
 * 설탕 N킬로그램을 입력받으면 5와 3키로그램 봉투로 나눠 배달할때 최소한의 봉토수를 출력
 * 나누어떨어지지않으면 -1 출력
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(bf.readLine());
		int output=0;
		
		
		while(n>0)
		{
			//5의 배수면 5킬로그램으로 나눠서 가져가는게 최소값이고
			if(n%5==0) {
				output +=n/5;
				break;
			} //그렇지 않다면 3키로그램 한봉지를 챙기자
			else {
				n-=3;
				output++;
			}
		
		}
		
		if(n<0)
			System.out.println(-1);
		else
			System.out.println(output);
		
	}
}
