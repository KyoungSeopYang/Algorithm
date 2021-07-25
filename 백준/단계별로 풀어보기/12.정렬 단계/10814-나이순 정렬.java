/*
 * ���� 10814 ���̼� ����
 * 
 * ���� ������ �����ϵ� ���̰� ������ ���� �Էµ� ������� �����Ѵ�
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