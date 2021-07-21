/*
 * 백준 1436 영화감독 숌
 * 
 * 정수 N이 주어졌을때 666이 적어도 3개이상 들어가는 수 중에서 N번째 수를 출력하는것.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int n= Integer.parseInt(br.readLine());
		
		int num=666;
		int count =1;
		
		while(count != n) {
			num++;
			if(String.valueOf(num).contains("666")) {
				count++;
			}
		}
		
		System.out.println(num);
	}
}