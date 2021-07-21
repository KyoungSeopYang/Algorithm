/*
 * 백준 2750 수 정렬하기
 * N개의 수가 주어졌을때 이를 오름차순으로 정렬하는 프로그램
 * 정렬의 3가지 방법
 * 1. 버블정렬
 * 2. Arrays.sort 기본제공 메소드
 * 3. 카운팅 정렬
 * 
 * 설명 : https://st-lab.tistory.com/105
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int n= Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++)	arr[i]=Integer.parseInt(br.readLine());
	
		for(int i=0;i<n;i++) {
			int min=i;
			for(int j=i+1;j<n;j++) {
				if(arr[j]<arr[min]) min=j;
			}
			int temp = arr[i];
			arr[i]=arr[min];
			arr[min]=temp;
		}
		
		for(int i=0;i<n;i++) System.out.println(arr[i]);
		
	}
}