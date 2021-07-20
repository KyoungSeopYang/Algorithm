/*
 * 백준 2775 부녀회장이 될테야
 * 아파트의 a층의 b호에는 a-1층의 b호까지의 거주민들의 합이 거주한다.
 * 이때 k층에 n호에는 몇명이 사는지 출력하라 
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int t=Integer.parseInt(bf.readLine());
		//k와 n 은 15보다 작으므로 최고크기의 배열을 미리 생성해두자
		int[][] room= new int[15][15];
		
		for(int i = 0; i < 15; i++) {
			//i층 1호는 1이고 0층 i호는 i이다
			room[i][1] = 1;	// i층 1호
			room[0][i] = i;	// 0층 i호
		}
		for(int i = 1; i < 15; i ++) {	// 1층부터 14층까지
			 
			for(int j = 2; j < 15; j++) {	// 2호부터 14호까지
				//i층 j호 거주민 == i층 j-1호 거주민 + i-1호 j층 거주민 
				room[i][j] = room[i][j - 1] + room[i - 1][j];
				
			}
		}
	
		//테스트 케이스만큼 반복
		for(int i=1;i<=t;i++)
		{	
			int k=Integer.parseInt(bf.readLine());
			int n=Integer.parseInt(bf.readLine());
			System.out.println(room[k][n]);
		}
	}
}
