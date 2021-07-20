/*
 * M * N 크기의 보드를 8 * 8로 잘라 체스판을 만들 계획인데 보드의 어떤 정사각형은 검은색이고 나머지는 흰색이다
 * 체스판을 검은색 흰색으로 번갈아 색칠해야 할때 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램
 * 첫째 줄에 N과 M이 주어진다. 둘째 줄 부터 N개의 줄에는 보드의 각 행의 상태가 주어진다 B는 검은색 W는 하얀색이다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static boolean[][] board;
	public static int min=64;	//칠해야하는 최대 개수
	
	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int n= Integer.parseInt(st.nextToken());
		int m= Integer.parseInt(st.nextToken());
		
		board=new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			String str= br.readLine();
			for(int j=0;j<m;j++) {
				if(str.charAt(j)=='W') board[i][j]=true;
				else if(str.charAt(j)=='B') board[i][j]=false;
			}
		}
		
		//좌측 위에서부터 탐색하므로 우측에서부터 8칸이 되지않으면 탐색할 필요가없다
		int n_row=n-7;
		int m_col=m-7;
		
		for(int i=0; i<n_row;i++) {
			for(int j=0;j<m_col;j++) {
				find(i,j);
			}
		}
		System.out.println(min);
	}
	
	public static void find(int x, int y) {
		int end_x=x+8;
		int end_y=y+8;
		int count=0;
		
		boolean TF=board[x][y]; //첫번째 칸 색
		
		for (int i=x;i<end_x;i++) {
			for(int j=y;j<end_y;j++) {
				//첫째 칸이랑 같지않으면 ++
				if(board[i][j] != TF) {
					count ++;
				}
				TF=(!TF);
			}
			
			TF=!TF;
		}
		
		count = Math.min(count, 64-count);	// 시작지점도 칠하는 경우가 count값이 더 작을 수도 있다.
		
		min=Math.min(min, count);
	}
	
}