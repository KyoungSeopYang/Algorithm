package com.ssafy.day0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D1_2056_연월일달력 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			char[] input = br.readLine().toCharArray();
			sb.append("#"+tc+" ");
			boolean flag = true;
			
			String year = String.valueOf(input, 0, 4);
			String month = String.valueOf(input, 4, 2);
			String day = String.valueOf(input, 6, 2);

			switch (month) {
			case "01":	case "03":	case "05":	case "07":
			case "08":	case "10":	case "12":
				if(Integer.parseInt(day)== 0 || Integer.parseInt(day)>31 ) {
					flag = false;
				}
				break;
				
			case "04" : case "06": case "09" : case "11" :
				if(Integer.parseInt(day)== 0 || Integer.parseInt(day)>30 ) {
					flag = false;
				}
				break;
				
			case "02" :
				if(Integer.parseInt(day)== 0 || Integer.parseInt(day)>28 ) {
					flag = false;
				}
				break;
			default :
				flag = false; break;
			}
			
			if(flag) 
				sb.append(year+"/"+month+"/"+day+"\n");
			 else 
				 sb.append(-1 +"\n");

		}
		System.out.println(sb);
	}

}
