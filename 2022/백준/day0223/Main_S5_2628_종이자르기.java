package com.ssafy.day0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_S5_2628_종이자르기 {

	static ArrayList<Integer> width = new ArrayList<>();
	static ArrayList<Integer> height = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		width.add(Integer.parseInt(st.nextToken()));
		height.add(Integer.parseInt(st.nextToken()));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int spot = Integer.parseInt(st.nextToken());

			if (dir == 0) { // 가로로 자른다;
				int idx;
				for (idx = 0; spot - height.get(idx) > 0; idx++) {
					spot -= height.get(idx);
				}
				int tmp = height.remove(idx);
				height.add(idx, tmp - spot);
				height.add(idx, spot);
			} else {
				int idx;
				for (idx = 0; spot - width.get(idx) > 0; idx++) {
					spot -= width.get(idx);
				}
				int tmp = width.remove(idx);
				width.add(idx, tmp - spot);
				width.add(idx, spot);
			}
		}

		int max = -1;
		for (int i = 0; i < height.size(); i++) {
			int hei = height.get(i);
			for (int j = 0; j < width.size(); j++) {
				int wid = width.get(j);
				max = Math.max(max, hei * wid);
			}
		}
		System.out.println(max);

	}

}
