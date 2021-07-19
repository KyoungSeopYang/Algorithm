/*
 * ���� 2231 ������
 * �ڿ��� N�� �־����� �������� N�� N�� �̷�� �� �ڸ����� ���̰� � �ڿ��� M�� ��������  N�ΰ�� M�� N�� �����ڶ�� �Ҷ�
 * ���� ���� �����ڸ� ���س��� ���α׷�
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		
		int n=Integer.parseInt(br.readLine());
		
		int num=0;
		
		while(num<n) {
			
			int m=num;
			int sum=m;
			
			while(m>=1) {
				sum +=m%10;
				m/=10;
			}
			
			if (sum==n) {
				System.out.println(num);
				return;
			}
			num++;
		}
		System.out.println(0);
	}
	
}