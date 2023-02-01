package com.ssafy.day0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// sysout : 2032ms , StringBuilder : 228ms
public class Main_S3_15649_N과M {

	static boolean[] visit;
	static int[] select;
	static int N,M;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		visit = new boolean[N+1];
		select = new int[M];
		
		for (int i = 1; i <=N; i++) {
			visit[i]=true;
			select[0] = i;
			solve(1);
			visit[i] =false;
		}
		System.out.println(sb);
	}
	private static void solve(int cnt) {
		
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(select[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if(!visit[i]) {
				visit[i] =true;
				select[cnt] = i;
				solve(cnt+1);
				visit[i] = false;
			}
		}
		
	}

}
