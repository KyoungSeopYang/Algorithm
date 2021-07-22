/*
 * 백준 1427 소트인사이드
 * 숫자 N의 각 자리수를 내림차순으로 정렬할것
 * N은 1,000,000,000 보다 작거나 같은 자연수
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	//카운팅 정렬 방식
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