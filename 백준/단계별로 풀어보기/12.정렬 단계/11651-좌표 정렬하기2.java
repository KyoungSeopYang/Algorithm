/*
 * 백준 11651 좌표 정렬하기2
 * 2차원 평면 위의 점 N개가 주어질때 y좌표의 오름차순으로 y좌표가 같다면 x좌표의 오름차순으로 정렬
 * 
 * 11650 코드에서 x와 y좌표의 위치를 뒤집어서 입력받으면된다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t= Integer.parseInt(br.readLine());
		
		int [][] count=new int[t][2];
		
		for(int i=0;i<t;i++) {
			st=new StringTokenizer(br.readLine());
			
			count [i][1]=Integer.parseInt(st.nextToken());
			count [i][0]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(count,(e1,e2) -> {
			if(e1[0]==e2[0]) {
				return  e1[1]-e2[1];
			} else {
				return e1[0]-e2[0];
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < t; i++) {
			sb.append(count[i][1] + " " + count[i][0]).append('\n');
		}
		System.out.println(sb);
	}
}