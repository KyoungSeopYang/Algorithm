/*
 * ���� 10250 ACM ȣ��
 * ���� H�� �� ���� W���� ������ �������ִ� ���簢���� ȣ���� ����
 * ���������ʹ� ���� �������ְ� ���մ��� �Ա��� ���尡��� ������ ��ȣ�Ҷ�
 * N��° �մ��� ����ȣ����? YYXX or YXX �������� ��� Y�� ���� XX�� ���°���ΰ�
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	/*
	 * �����غ������� ���� �Ʒ����� ���� ������� ��ĭ�� ä������ 2���� �迭�� �����غ���
	 * �� N / H�� N��° �մ��� ������ ��ȣ�������� ������ 1ȣ���� �����ϹǷ� +1
	 * N % H �� N��° �մ��� ���� �������ȴ�
	 * 
	 * ������ N % H ==0�� ��� ���ǹ�ȣ�� 2���ǹ����⶧���� ���ܷ� +1�� �����ʰ�
	 * �������� 0���� �Ǿ�����⶧���� ���������� H���� �����޴� �������� �������
	 */
	public static void main(String[] args)throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int t=Integer.parseInt(bf.readLine());
		
		for(int i=1;i<=t;i++)
		{
			String str=bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			int h=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			int n=Integer.parseInt(st.nextToken());
			
			int x,y;
			
			if(n%h==0)
			{
				x=n/h;
				y=h*100;
			}
			else
			{
				y=(n%h)*100;
				x=(n/h)+1;
			}
			
			System.out.println(y+x);
		}
	}
}
