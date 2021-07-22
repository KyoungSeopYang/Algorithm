/*
 * ���� 11651 ��ǥ �����ϱ�2
 * 2���� ��� ���� �� N���� �־����� y��ǥ�� ������������ y��ǥ�� ���ٸ� x��ǥ�� ������������ ����
 * 
 * 11650 �ڵ忡�� x�� y��ǥ�� ��ġ�� ����� �Է¹�����ȴ�.
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