/*
 * 백준 1002 터렛
 * 
 * 터렛 두개의 좌표 (x1,y1), (x2,y2)와 각 터렛과 마린의 위치 r1,r2가 주어졌을때 마린이 있을수 있는 경우의수
 * 복잡해보이지만 사실은 (x1,y1), (x2,y2)의 중심점과 r1,r2의 반지름을 가지는 원 두개의
 * 접점의 갯수를 출력하는 프로그램
 * 
 * 원의 상태는 내접,외접, 외부에서 만나지않음,내부에서 만나지않음, 같음, 두 개의 접점이 존재 하는경우로 나뉜다
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		int t=Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
		
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());
			int r1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			int r2=Integer.parseInt(st.nextToken());
			//두 원의 중점사이 거리
			int distance_pow= (int)(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
			
			//두 원이 같을때
			if(x1==x2 && y1==y2 && r1==r2) {
				sb.append(-1).append("\n");
			}
			// 두 원이 외부에서 접하지않을때
			else if(distance_pow>Math.pow(r1+r2, 2)) {
				sb.append(0).append("\n");
			}
			// 두 원이 내부에서 접하지 않을때
			else if(distance_pow<Math.pow(r1-r2, 2)) {
				sb.append(0).append("\n");
			}
			// 두 원이 외접할 때 
			else if(distance_pow==Math.pow(r1+r2, 2)) {
				sb.append(1).append("\n");
			}
			// 두 원이 내접할 때
			else if(distance_pow==Math.pow(r1-r2, 2)) {
				sb.append(1).append("\n");
			}
			
			else {
				sb.append(2).append("\n");
			}
		}
		
		System.out.println(sb);
		
	}
}