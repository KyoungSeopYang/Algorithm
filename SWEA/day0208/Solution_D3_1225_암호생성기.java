package com.ssafy.day0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_1225_암호생성기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<Integer> queue = new LinkedList<Integer>();

			for (int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			int i = 1;
			
			while (true) {
				int target = queue.poll() - i;

				if (target <= 0) {
					queue.offer(0);
					break;
				}
				queue.offer(target);

				i = i == 5 ? 1 : i + 1;
			}
			
			sb.append("#"+tc+" ");
			for (int num : queue) {
				sb.append(num+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
