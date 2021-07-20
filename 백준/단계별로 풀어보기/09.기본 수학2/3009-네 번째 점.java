/*
 * 백준 3009 네 번째 점
 * 세 점이 주어졌을 때 축에 평행한 직사각형을 만들기 위해 필요한 네번째 점을 구하라
 * 세 개의 x,와 y 중 쌍을 이루지않는 한개만 구하면 된다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		int a_x=Integer.parseInt(st.nextToken());
		int a_y=Integer.parseInt(st.nextToken());
		
		st= new StringTokenizer(br.readLine());
		int b_x=Integer.parseInt(st.nextToken());
		int b_y=Integer.parseInt(st.nextToken());
		
		st= new StringTokenizer(br.readLine());
		int c_x=Integer.parseInt(st.nextToken());
		int c_y=Integer.parseInt(st.nextToken());
		
		int d_x,d_y;
		
		if(a_x==b_x) d_x=c_x;
		else if (b_x==c_x) d_x=a_x;
		else d_x=b_x;
		
		if(a_y==b_y) d_y=c_y;
		else if (b_y==c_y) d_y=a_y;
		else d_y=b_y;
		
		System.out.println(d_x+" "+d_y);
	}
}