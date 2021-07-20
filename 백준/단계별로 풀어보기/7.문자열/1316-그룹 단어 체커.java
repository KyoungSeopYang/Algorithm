/*
 * ���� 1316 �׷� �ܾ� üĿ
 * �ܾ �����ϴ� ��� ���ڰ� ���� �����ؼ� ������ ����� �ܾ�= �׷�ܾ� ex) happy, abc
 * N���� �Է¹޾� �׷� �ܾ��� ������ ����Ͻÿ�
 */
import java.io.IOException;
import java.util.Scanner;

public class Main {

	static boolean check(String str) {
		//��� �� ���ĺ� Ȯ�ο� ����
		boolean[] check = new boolean[26];
		
		// ���������� ���� ���ĺ��� �ε�����
		int prev =0;
		
		for(int i=0;i<str.length();i++)
		{
			//�ش� ���ĺ��� �������� �ִ°�?
			if(check[str.charAt(i)-97])
			{
				//������ ���Դ� ���ĺ��� ���� ���ĺ��� ������?
				if(prev!=str.charAt(i)-97)
				{
					return false;
				} 
			}
			else //�ش� ���ĺ��� �������� ���ٸ�
			{
				check[str.charAt(i)-97]=true;
				// ������ ���� ���� ���ĺ��� �ε��� �� ����
				prev=str.charAt(i)-97;
			}	
		}
		
		//���� ���� ������ �׷�ܾ��̴�.
		return true;
	}
	
	public static void main(String[] args)throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n=Integer.parseInt(sc.nextLine());
		int count=0;
		
		for(int i=0;i<n;i++)
		{
			
			if(check(sc.nextLine()))
			{
				count++;
			}
			
		}
		
		System.out.print(count);
	}
}
