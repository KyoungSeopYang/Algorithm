/*
 * ���� 3009 �� ��° ��
 * �� ���� �־����� �� �࿡ ������ ���簢���� ����� ���� �ʿ��� �׹�° ���� ���϶�
 * �� ���� x,�� y �� ���� �̷����ʴ� �Ѱ��� ���ϸ� �ȴ�.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		int a_x=Integer.parseInt(st.nextToken());
		int a_y=Integer.parseInt(st.nextToken());
		
		st= new StringTokenizer(br.readLine());
		int b_x=Integer.parseInt(st.nextToken());
		int b_y=Integer.parseInt(st.nextToken());
		
		st= new StringTokenizer(br.readLine());
		int c_x=Integer.parseInt(st.nextToken());
		int c_y=Integer.parseInt(st.nextToken());
		
		int d_x,d_y;
		
		if(a_x==b_x) d_x=c_x;
		else if (b_x==c_x) d_x=a_x;
		else d_x=b_x;
		
		if(a_y==b_y) d_y=c_y;
		else if (b_y==c_y) d_y=a_y;
		else d_y=b_y;
		
		System.out.println(d_x+" "+d_y);
	}
}