/*
 * ���� 2775 �γ�ȸ���� ���׾�
 * ����Ʈ�� a���� bȣ���� a-1���� bȣ������ ���ֹε��� ���� �����Ѵ�.
 * �̶� k���� nȣ���� ����� ����� ����϶� 
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int t=Integer.parseInt(bf.readLine());
		//k�� n �� 15���� �����Ƿ� �ְ�ũ���� �迭�� �̸� �����ص���
		int[][] room= new int[15][15];
		
		for(int i = 0; i < 15; i++) {
			//i�� 1ȣ�� 1�̰� 0�� iȣ�� i�̴�
			room[i][1] = 1;	// i�� 1ȣ
			room[0][i] = i;	// 0�� iȣ
		}
		for(int i = 1; i < 15; i ++) {	// 1������ 14������
			 
			for(int j = 2; j < 15; j++) {	// 2ȣ���� 14ȣ����
				//i�� jȣ ���ֹ� == i�� j-1ȣ ���ֹ� + i-1ȣ j�� ���ֹ� 
				room[i][j] = room[i][j - 1] + room[i - 1][j];
				
			}
		}
	
		//�׽�Ʈ ���̽���ŭ �ݺ�
		for(int i=1;i<=t;i++)
		{	
			int k=Integer.parseInt(bf.readLine());
			int n=Integer.parseInt(bf.readLine());
			System.out.println(room[k][n]);
		}
	}
}
