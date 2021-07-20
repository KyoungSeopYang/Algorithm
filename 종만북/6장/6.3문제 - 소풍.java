/*
 * 종만북 155p 6.3 문제:소풍
 * 각 학생들의 쌍에 대해 서로 친구인지 여부가 주어질대 학생들을 짝 지을수 있는 경우의 수를 구하라
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static boolean[][] pair;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int t=Integer.parseInt(br.readLine());
		
		for (int i=0;i<t;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//학생의 수
			n=Integer.parseInt(st.nextToken());
			//친구 쌍의 수
			int m=Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			pair = new boolean[10][10];
			
			for(int j=0;j<m;j++) {
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				
				pair[a][b]=true;
				pair[b][a]=true;
			}
			
			System.out.println(SerchFriends(new boolean[n]));
			
		}
	}
	
	//taken[n]은 n번째 학생이 짝을 찾았으면 true 아니면 false
	public static int SerchFriends(boolean[] taken) {
		//남은 학생들 중 가장 번호가 빠른 학생
		int firstFree=-1;
		
		for(int i=0; i<n;i++) {
			if(!taken[i]) {
				firstFree=i;
				break;
			}
		}
		
		//모든 학생이 짝을 찾았다
		if(firstFree==-1) return 1;
		int ret =0;
		
		//i번째 학생이 짝을 못찾았고 firstFree학생과 i 학생이 친구라면
		for(int i=0;i<n;i++) {
			if(!taken[i] && pair[firstFree][i]) {
				taken[i]=taken[firstFree]=true;
				ret +=SerchFriends(taken);
				taken[i]=taken[firstFree]=fals e;	
			}
		}

		return ret;
	}
	
}