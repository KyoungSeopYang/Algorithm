/*
 * 백준 11650 좌표 정렬하기
 * 
 * 2차원 평면위의 점 N 개의 좌표를 x좌표의 오름차순으로 x 좌표가 같다면
 * y좌표의 오름차순으로 정렬하는 프로그램
 * 
 * Arrays.sort는 2차원 배열에 사용할수없다
 * 
 * 람다식이란!
 * (매개변수1,매개변수2) -> { 함수 내용 } 형식 
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
			
			count [i][0]=Integer.parseInt(st.nextToken());
			count [i][1]=Integer.parseInt(st.nextToken());
		}
		
		// 그래서 람다식을 활용해서 오버라이딩
		Arrays.sort(count,(e1,e2) -> {
			if(e1[0]==e2[0]) {
				return  e1[1]-e2[1];
			} else {
				return e1[0]-e2[0];
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < t; i++) {
			sb.append(count[i][0] + " " + count[i][1]).append('\n');
		}
		System.out.println(sb);
	}
}