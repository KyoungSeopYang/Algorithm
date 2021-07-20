/*
 * M * N ũ���� ���带 8 * 8�� �߶� ü������ ���� ��ȹ�ε� ������ � ���簢���� �������̰� �������� ����̴�
 * ü������ ������ ������� ������ ��ĥ�ؾ� �Ҷ� �ٽ� ĥ�ؾ� �ϴ� ���簢���� �ּ� ������ ���ϴ� ���α׷�
 * ù° �ٿ� N�� M�� �־�����. ��° �� ���� N���� �ٿ��� ������ �� ���� ���°� �־����� B�� ������ W�� �Ͼ���̴�.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static boolean[][] board;
	public static int min=64;	//ĥ�ؾ��ϴ� �ִ� ����
	
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
		
		//���� ���������� Ž���ϹǷ� ������������ 8ĭ�� ���������� Ž���� �ʿ䰡����
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
		
		boolean TF=board[x][y]; //ù��° ĭ ��
		
		for (int i=x;i<end_x;i++) {
			for(int j=y;j<end_y;j++) {
				//ù° ĭ�̶� ���������� ++
				if(board[i][j] != TF) {
					count ++;
				}
				TF=(!TF);
			}
			
			TF=!TF;
		}
		
		count = Math.min(count, 64-count);	// ���������� ĥ�ϴ� ��찡 count���� �� ���� ���� �ִ�.
		
		min=Math.min(min, count);
	}
	
}