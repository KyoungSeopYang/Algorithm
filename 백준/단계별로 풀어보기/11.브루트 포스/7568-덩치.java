/*
 * ����� ��ġ�� (x,y)�� ǥ���Ҷ� x y �� ��� ū ����� ���� ��ġ�� ũ�ٰ� ǥ���Ѵٰ� �Ѵ�
 * �̶� �ڽź��� ��ġ�� ū ����� ���� k��� �� ����� ��ġ ����� k+1�̶�� �Ҷ� 
 * n���� ���ܿ��� �� ����� ��ġ ����� ����ϴ� ���α׷�
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