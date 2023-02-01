package com.ssafy.day0309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_1697_숨바꼭질 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int size = 100001;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(N);
		int [] cache = new int[size];

		while (!queue.isEmpty()) {
			int x = queue.poll();	// 현재 위치 좌표
			
			if(x == K) {
				System.out.println(cache[K]);
				break;
			}
			
			if(x+1 < size && cache[x+1] == 0) {	// +1 만큼 움직일 수 있나?
				queue.offer(x+1);
				cache[x+1] = cache[x]+1;
			} 
			if(x-1 >= 0 && cache[x-1] == 0) { // -1 만큼 움직일 수 있나?
				queue.offer(x-1);
				cache[x-1] = cache[x]+1;
			}
			
			if(x*2 < size && cache[x*2] ==0) { // *2 만큼 움직일 수 있나?
				queue.offer(x*2);
				cache[x*2] = cache[x]+1;
			}
		}
	}

}
