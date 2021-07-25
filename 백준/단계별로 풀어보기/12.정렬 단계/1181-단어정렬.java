/*
 * ���� 1181 �ܾ� ����
 * 
 * ���ĺ� �ҹ��ڷ� �̷���� N���� �ܾ ������ �Ʒ��� ���� ���ǿ� ���� �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * ���̰� ª�� �ͺ���
 * ���̰� ������ ���� ������
 *
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
		
		String[][] str = new String[n];
		
		for(int i=0;i<n;i++) {
			str[i]=br.readLine();
		}
		
		Arrays.sort(str,(s1,s2) -> {
			if(s1.length()==s2.length()) {
				return s1.compareTo(s2);
			}
			else {
				return s1.length()-s2.length();
			}
		});
		
		StringBuilder sb=new StringBuilder();
		sb.append(str[0]).append('\n');
		
		for(int i=1;i<n;i++) {
			//�ߺ�����
			if (!str[i].equals(str[i - 1])) {
				sb.append(str[i]).append('\n');
			}
			
		}
		
		System.out.println(sb);
	}
}