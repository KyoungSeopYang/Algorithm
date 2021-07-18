/*
 * ���� 2798 ����
 * N���� ī�尡 �־������� �� ���� ���� m�� ���������鼭 ���� ����� ���� ���϶�
 * ù° �ٿ� ī���� ���� N�� M�� �־�����.
 * ��° �ٿ��� ī�忡 �����ִ� ���ڰ� ���ʷ� �־�����.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		st= new StringTokenizer(br.readLine());
		
		int[] arr=new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int output=0;
		
		for(int i=0; i<n-2;i++) {
			
			for(int j=i+1;j<n-1;j++) {
				
				for(int k=j+1;k<n;k++) {
					int temp=arr[i]+arr[j]+arr[k];
					
					if(m==temp) {
						System.out.println(temp);
						return;
					}
					
					if(temp>output && temp<m) {
						output=temp;
					}
					
				}
			}
		}
		
		System.out.println(output);
		
	}
	
}