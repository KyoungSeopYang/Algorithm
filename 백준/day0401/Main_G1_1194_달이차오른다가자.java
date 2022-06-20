package com.ssafy.day0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G1_1194_달이차오른다가자 {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, M;
	static char[][] map;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][1<<6];

		Pos start = null;
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '0') {
					start = new Pos(i, j, 0,0);
				}
			}
		}
		bfs(start);

	}

	private static void bfs(Pos start) {

		Queue<Pos> queue = new LinkedList<>();
		queue.offer(start);
		visited[start.x][start.y][start.key]  = true;

		while (!queue.isEmpty()) {
			Pos cur = queue.poll();
			
			if(map[cur.x][cur.y] =='1') {
				System.out.println(cur.count);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x +dx[i];
				int ny = cur.y +dy[i];
				int count = cur.count;
				int key = cur.key;
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] =='#')
					continue;
				
				if(map[nx][ny] >= 'a' && map[nx][ny] <='f') {
					key = key |  (1 << map[nx][ny]-'a');
				} else if(map[nx][ny] >= 'A' && map[nx][ny] <='F') {
					if( (key & (1 << map[nx][ny]-'A')) == 0) {
						continue;
					}
				}
				
				if(!visited[nx][ny][key]) {
					visited[nx][ny][key] = true;
					queue.offer(new Pos(nx,ny,key,count+1));
				}
			}
		}
		
		System.out.println(-1);
	}

	static class Pos {
		int x, y, key,count;

		public Pos(int x, int y, int keys,int count) {
			this.x = x;
			this.y = y;
			this.key = keys;
			this.count = count;
		}
	}

}
