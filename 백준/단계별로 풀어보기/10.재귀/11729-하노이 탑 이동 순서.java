/*
 * 백준 11729 하노이 탑 이동 순서
 * 
 * n개의 원판을 1번 기둥에서 3번기둥으로 옮길때 최소 횟수와
 * 과정을 출력하는것
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
		
		// N-1개를 A에서 B로 이동
		hanoi(n-1, start,to,mid);
		
		//1개를 A에서 C로 이동
		sb.append(start+" "+to+"\n");
		
		//N-1개를 B에서 C로 이동
		hanoi(n-1,mid,start,to);
	}
}