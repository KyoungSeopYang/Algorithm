/*
 * ���� 1002 �ͷ�
 * 
 * �ͷ� �ΰ��� ��ǥ (x1,y1), (x2,y2)�� �� �ͷ��� ������ ��ġ r1,r2�� �־������� ������ ������ �ִ� ����Ǽ�
 * �����غ������� ����� (x1,y1), (x2,y2)�� �߽����� r1,r2�� �������� ������ �� �ΰ���
 * ������ ������ ����ϴ� ���α׷�
 * 
 * ���� ���´� ����,����, �ܺο��� ����������,���ο��� ����������, ����, �� ���� ������ ���� �ϴ°��� ������
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		int t=Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
		
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());
			int r1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			int r2=Integer.parseInt(st.nextToken());
			//�� ���� �������� �Ÿ�
			int distance_pow= (int)(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
			
			//�� ���� ������
			if(x1==x2 && y1==y2 && r1==r2) {
				sb.append(-1).append("\n");
			}
			// �� ���� �ܺο��� ������������
			else if(distance_pow>Math.pow(r1+r2, 2)) {
				sb.append(0).append("\n");
			}
			// �� ���� ���ο��� ������ ������
			else if(distance_pow<Math.pow(r1-r2, 2)) {
				sb.append(0).append("\n");
			}
			// �� ���� ������ �� 
			else if(distance_pow==Math.pow(r1+r2, 2)) {
				sb.append(1).append("\n");
			}
			// �� ���� ������ ��
			else if(distance_pow==Math.pow(r1-r2, 2)) {
				sb.append(1).append("\n");
			}
			
			else {
				sb.append(2).append("\n");
			}
		}
		
		System.out.println(sb);
		
	}
}