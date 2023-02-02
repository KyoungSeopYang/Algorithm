package com.ssafy.day0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2564_경비원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int N = Integer.parseInt(br.readLine());
		int sum = 0;

		List<Integer> list = new ArrayList<Integer>();
		int totalsize = (W + H) * 2;

		for (int i = 0; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int position = Integer.parseInt(st.nextToken());

			if (direction == 1) {
				list.add(position);
			} else if (direction == 2) {
				list.add(W + H + (W - position));
			} else if (direction == 3) {
				list.add(2 * W + H + (H - position));
			} else if (direction == 4) {
				list.add(W + position);
			}
		}

		int me = list.get(list.size() - 1);

		for (int i = 0; i < N; i++) {
			int tmp = Math.abs(list.get(i) - me);
			sum += Math.min(tmp, totalsize - tmp);
		}

		System.out.println(sum);

	}

}
