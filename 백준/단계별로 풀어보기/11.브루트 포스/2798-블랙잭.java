/*
 * 백준 2798 블랙잭
 * N장의 카드가 주어졌을때 세 장의 합이 m을 넘지않으면서 가장 가까운 합을 구하라
 * 첫째 줄에 카드의 개수 N과 M이 주어진다.
 * 둘째 줄에는 카드에 쓰여있는 숫자가 차례로 주어진다.
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