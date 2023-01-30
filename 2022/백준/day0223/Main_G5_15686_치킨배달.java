package com.ssafy.day0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 치킨집과 집을 따로 배열에 저장하고
 * 조합을 통해서 M개의 치킨집을 선정한다
 * M개의 치킨집이 선정되면 집 배열에서 하나씩 뽑아서
 * 선정된 M개의 치킨집 중 가장 가까운 치킨집과의 거리를 sum 변수에 더하고
 * 모든 집 배열을 순회하면 min 변수와 sum 변수중 더 작은 값을 min 변수에 대입
 * sysout(min)
 */
public class Main_G5_15686_치킨배달 {

	static int N,M , min =Integer.MAX_VALUE;
	static ArrayList<Pos> houses,chickens;
	static Pos[] select;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		
		houses = new ArrayList<>(2*N);
		chickens = new ArrayList<>(13);
		select = new Pos[M];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				String tmp =st.nextToken();
				if(tmp.equals("1")) {
					houses.add(new Pos(i,j));
				} else if(tmp.equals("2")) {
					chickens.add(new Pos(i,j));
				}
			}
		}
		solve(0,0);
		System.out.println(min);
	}
	
	static void solve(int start,int cnt) {
		
		if(cnt == M) {
			int sum = 0;
			for (int i = 0; i < houses.size(); i++) {
				int len = Integer.MAX_VALUE;
				Pos house = houses.get(i);
				
				for (int j = 0; j < M; j++) {
					Pos cur = select[j];
					len = Math.min(len, Math.abs(house.x-cur.x)+Math.abs(house.y-cur.y));
				}
				sum+=len;
			}
			min = Math.min(min, sum);
			return;
		}
		
		for (int i = start; i < chickens.size(); i++) {
			select[cnt] = chickens.get(i);
			solve(i+1,cnt+1);
		}
	}
	
	static class Pos{
		int x,y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}

}
