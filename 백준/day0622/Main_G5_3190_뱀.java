package com.ssafy.day0622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_G5_3190_뱀 {
	
	static class Pair {
		int x,y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N,K,L;
	static int[][] map;
	static Queue<Pair> snake = new LinkedList<>();
	static List<Pair> Dirs = new ArrayList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
	
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[x][y] = 1;
		}
		
		L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int t= Integer.parseInt(st.nextToken());
			String d = st.nextToken();
			int dir = d.equals("D")? 1:-1;
			
			Dirs.add(new Pair(t,dir));
		}
		
		int time = 0,turn=0;
		map[1][1]=-1;
		Pair head = new Pair(1,1);
		int dir=0;
		snake.add(head);
		
		while(true) {
			time++;
			
			int nx = head.x+dx[dir];
			int ny = head.y+dy[dir];
			
			if(nx<=0 || N < nx || N < ny || ny<= 0 || map[nx][ny]== -1)
				break;
			
			if(map[nx][ny] != 1) {
				Pair tail = snake.poll();
				map[tail.x][tail.y]=0;
			}
			
			head = new Pair(nx,ny);
			snake.add(head);
			map[nx][ny]=-1;
			
			if(turn < L && Dirs.get(turn).x == time) {
				dir= (dir+Dirs.get(turn).y) % 4;
				dir = dir == -1 ? 3 : dir;
				turn++;
			}
		}
		System.out.println(time);
	}
}
