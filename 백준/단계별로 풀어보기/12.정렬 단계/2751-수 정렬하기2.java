/*
 * 백준 2751 수 정렬하기2
 * N개의 수가 주어졌을때 이를 오름차순으로 정렬하는 프로그램
 * 
 * 정리 : https://st-lab.tistory.com/106
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int n= Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++)	arr[i]=Integer.parseInt(br.readLine());
	
		Arrays.sort(arr);
		
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<n;i++) {
			sb.append(arr[i]).append("\n");
		}
		
		System.out.print(sb);
	}
}