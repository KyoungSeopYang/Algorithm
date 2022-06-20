package com.ssafy.day0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11584kb, 80 ms
public class Main_S1_2527_직사각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 0; tc < 4; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());

			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			
			// 4개의 x값끼리, y값끼리 비교한다.
			if ((p1 == x2 || x1 == p2) && (q1 == y2 || y1 == q2)) {
				// x의 값이 같고 && y의 값이 같으면 : 점
				System.out.println("c");
			} else if ((p1 < x2 || x1 > p2) || (q1 < y2 || y1 > q2)) {
				// 왼쪽 사각형에 가장큰 x,y값과 오른쪽 사각형의 가장 작은 x,y 값을 비교
				// 오른쪽 사각형이 더 크면 공통부분이 없다
				System.out.println("d");
			} else if ((p1 == x2 || x1 == p2) || (q1 == y2 || y1 == q2)) {
				// x값만 같거나 y값만 같다
				System.out.println("b");
			} else {
				System.out.println("a");
			}
		}
	}

}
