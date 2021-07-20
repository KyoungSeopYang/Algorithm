/*
 * ������ 155p 6.3 ����:��ǳ
 * �� �л����� �ֿ� ���� ���� ģ������ ���ΰ� �־����� �л����� ¦ ������ �ִ� ����� ���� ���϶�
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static boolean[][] pair;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int t=Integer.parseInt(br.readLine());
		
		for (int i=0;i<t;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//�л��� ��
			n=Integer.parseInt(st.nextToken());
			//ģ�� ���� ��
			int m=Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			pair = new boolean[10][10];
			
			for(int j=0;j<m;j++) {
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				
				pair[a][b]=true;
				pair[b][a]=true;
			}
			
			System.out.println(SerchFriends(new boolean[n]));
			
		}
	}
	
	//taken[n]�� n��° �л��� ¦�� ã������ true �ƴϸ� false
	public static int SerchFriends(boolean[] taken) {
		//���� �л��� �� ���� ��ȣ�� ���� �л�
		int firstFree=-1;
		
		for(int i=0; i<n;i++) {
			if(!taken[i]) {
				firstFree=i;
				break;
			}
		}
		
		//��� �л��� ¦�� ã�Ҵ�
		if(firstFree==-1) return 1;
		int ret =0;
		
		//i��° �л��� ¦�� ��ã�Ұ� firstFree�л��� i �л��� ģ�����
		for(int i=0;i<n;i++) {
			if(!taken[i] && pair[firstFree][i]) {
				taken[i]=taken[firstFree]=true;
				ret +=SerchFriends(taken);
				taken[i]=taken[firstFree]=fals e;	
			}
		}

		return ret;
	}
	
}