/*
 * ���� 11650 ��ǥ �����ϱ�
 * 
 * 2���� ������� �� N ���� ��ǥ�� x��ǥ�� ������������ x ��ǥ�� ���ٸ�
 * y��ǥ�� ������������ �����ϴ� ���α׷�
 * 
 * Arrays.sort�� 2���� �迭�� ����Ҽ�����
 * 
 * ���ٽ��̶�!
 * (�Ű�����1,�Ű�����2) -> { �Լ� ���� } ���� 
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
		
		// �׷��� ���ٽ��� Ȱ���ؼ� �������̵�
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