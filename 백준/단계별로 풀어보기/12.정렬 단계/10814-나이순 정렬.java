/*
 * 백준 10814 나이순 정렬
 * 
 * 나이 순으로 정렬하되 나이가 같으면 먼저 입력된 순서대로 정렬한다
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		
		String[][] str = new String[n][2];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			str[i][0] = st.nextToken();
			str[i][1] = st.nextToken();
		}
		
		Arrays.sort(str,(s1,s2) -> {
			return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
		});
		
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<n;i++) {
			sb.append(str[i][0]).append(' ').append(str[i][1]).append('\n');
		}
		
		System.out.println(sb);
	}
}