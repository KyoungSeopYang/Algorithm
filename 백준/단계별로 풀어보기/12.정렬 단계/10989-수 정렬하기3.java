/*
 * 백준 10989 수 정렬하기3
 * N개의 수가 주어졌을때 오름차순으로 정렬하는 프로그램
 * 
 * 카운팅 정렬 방식을 사용했다
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args)throws IOException {
		// 수의 범위(0 ~ 10000) 사실상 0 은 제외
		int[] cnt=new int[10001];
				
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int n= Integer.parseInt(br.readLine());
		
		for (int i=0; i<n;i++) {
			// 해당 인덱스 값을 1증가
			cnt[Integer.parseInt(br.readLine())]++;
		}
		
		br.close();
		
		StringBuilder sb=new StringBuilder();
		
		for(int i=1;i<10001;i++) {
			//i 값이 개수가 0이 될때까지 출력 (빈도수를 의미)
			while(cnt[i]>0) {
				sb.append(i).append('\n');
				cnt[i]--;
			}
		}
		System.out.println(sb);
	}
}