/*
 * ���� 11729 �ϳ��� ž �̵� ����
 * 
 * n���� ������ 1�� ��տ��� 3��������� �ű涧 �ּ� Ƚ����
 * ������ ����ϴ°�
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());

		
		sb.append((int) (Math.pow(2, n) -1)).append('\n');
		hanoi(n,1,2,3);
		System.out.print(sb);
		
	}
	
	static void hanoi(int n,int start,int mid,int to) {
		if(n==1) {
			sb.append(start + " " + to +"\n");
			return;
		}
		
		// N-1���� A���� B�� �̵�
		hanoi(n-1, start,to,mid);
		
		//1���� A���� C�� �̵�
		sb.append(start+" "+to+"\n");
		
		//N-1���� B���� C�� �̵�
		hanoi(n-1,mid,start,to);
	}
}