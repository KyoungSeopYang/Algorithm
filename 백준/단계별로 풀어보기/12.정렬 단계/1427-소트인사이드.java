/*
 * ���� 1427 ��Ʈ�λ��̵�
 * ���� N�� �� �ڸ����� ������������ �����Ұ�
 * N�� 1,000,000,000 ���� �۰ų� ���� �ڿ���
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	//ī���� ���� ���
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int n= Integer.parseInt(br.readLine());
		int [] count=new int[10];
		
		while(n != 0) {
			count[n%10]++;
			n/=10;
		}
		
		for(int i=9;i>=0;i--) {
			while(count[i]-- > 0) {
				System.out.print(i);
			}
		}
	}
}