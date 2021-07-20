/*
 * 백준 4153 직각삼각형
 * 세변의 길이가 주어진 삼각형이 직각인지 아닌지 구분하시오
 * 입력의 마지막은 0 0 0이고 직각이면 "right" 아니라면 "wrong"를 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb= new StringBuilder();
		
		//a*a+b*b=c*c이지만 대각선이 어디인지 모르므로 세가지 경우를 따진다.
		while(true) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	int z = Integer.parseInt(st.nextToken());
			
        	if(x==0 && y==0 && z==0) break;
        	
        	if(x*x+y*y==z*z) {
        		sb.append("right").append('\n');
        	}
        	else if(y*y+z*z==x*x) {
        		sb.append("right").append('\n');
        	}
        	else if(x*x+z*z==y*y) {
        		sb.append("right").append('\n');;
        	}
        	else {
        		sb.append("wrong").append('\n');
        	}
		}
		System.out.println(sb);
	}
}