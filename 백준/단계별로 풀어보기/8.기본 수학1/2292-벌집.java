/*
 * ���� 2292 ����
 * �������� �������� �߾��� �� 1���� �����ؼ� �̿��ϴ� �濡 ���ư��� 1�� �����ϴ� ��ȣ�� �ű��
 * ���� N�� �־������� ������ �߾Ӻ��� N�� ������� �ּ� ���(���۰� �� ����)�� ����϶�
 * �� N������ ���° �㿡 �ִ��� �˾Ƴ��� �ǰ� N==1�� ���� ���ܷ� ��´�
 */
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args)throws IOException {
		Scanner sc=new Scanner(System.in);
		int n = in.nextInt();
		
		//���° ������
		int round=1;
		// �ش� ���� �ּҹ��ȣ
		int room=2;
		
		//n==1�� ����ó��
		if(n==1)
			System.out.print(1);
		else {
			//N�� ���° �㿡 �ִ��� �˱����� �ڵ�
			while(room<=n)
			{
				//�ּ� ���ȣ�� ������Ű��
				room=room+(6*round);
				// ������ �㵵 ������Ų��.
				round++;
			}
			
			System.out.print(round);
		}
			
	}
}
