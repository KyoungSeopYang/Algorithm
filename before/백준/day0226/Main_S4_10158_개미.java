package com.ssafy.day0226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S4_10158_개미 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int q = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		int T = Integer.parseInt(br.readLine());

		int x = (q + T) % (2 * W);
		int y = (p + T) % (2 * H);
		x = W - Math.abs(W - x);
		y = H - Math.abs(H - y);

		System.out.println(x + " " + y);
	}

}
