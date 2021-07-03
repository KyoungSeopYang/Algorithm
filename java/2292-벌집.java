/*
 * 백준 2292 벌집
 * 육각형의 벌집에서 중앙의 방 1부터 시작해서 이웃하는 방에 돌아가며 1씩 증가하는 번호를 매긴다
 * 숫자 N이 주어졌을때 벌집의 중앙부터 N번 방까지의 최소 경로(시작과 끝 포함)를 출력하라
 * 즉 N번방이 몇번째 겹에 있는지 알아내면 되고 N==1인 경우는 예외로 잡는다
 */
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args)throws IOException {
		Scanner sc=new Scanner(System.in);
		int n = in.nextInt();
		
		//몇번째 겹인지
		int round=1;
		// 해당 겹의 최소방번호
		int room=2;
		
		//n==1은 예외처리
		if(n==1)
			System.out.print(1);
		else {
			//N이 몇번째 겹에 있는지 알기위한 코드
			while(room<=n)
			{
				//최소 방번호를 증가시키고
				room=room+(6*round);
				// 현재의 겹도 증가시킨다.
				round++;
			}
			
			System.out.print(round);
		}
			
	}
}
