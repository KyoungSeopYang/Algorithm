package com.ssafy.day0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S4_10845_큐 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Queue<String> queue = new LinkedList<>();
		String back = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			switch (st.nextToken()) {
			case "push":
				back = st.nextToken();
				queue.add(back);
				break;
			case "pop":
				sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
				break;
			case "size":
				sb.append(queue.size()).append("\n");
				break;
			case "empty":
				sb.append(queue.isEmpty() ? 1 : 0).append("\n");
				break;
			case "front":
				sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
				break;
			case "back":
				sb.append(queue.isEmpty() ? -1 : back).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}

}