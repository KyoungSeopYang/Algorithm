/*
 * 사람의 덩치를 (x,y)로 표현할때 x y 둘 모두 큰 사람이 더욱 덩치가 크다고 표현한다고 한다
 * 이때 자신보다 덩치가 큰 사람의 수가 k라면 그 사람의 덩치 등수는 k+1이라고 할때 
 * n명의 집단에서 각 사람의 덩치 등수를 출력하는 프로그램
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		
		int n=Integer.parseInt(br.readLine());
		
		int[][] inbody=new int[n][3];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			inbody[i][0]=Integer.parseInt(st.nextToken());
			inbody[i][1]=Integer.parseInt(st.nextToken());
			inbody[i][2]=1;
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(inbody[i][0]<inbody[j][0] && inbody[i][1]<inbody[j][1]) {
					inbody[i][2]++;
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			System.out.print(inbody[i][2] + " ");
		}
	}
	
}