//���� 1065 �Ѽ�
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		
		System.out.println(hansu(in.nextInt()));
		in.close();
	}
	
	public static int hansu(int num)
	{
		int cnt=0;
		
		//100���� �������� ��� �Ѽ��̴�.
		if (num<100)
		{
			return num;
		}
		else {
			cnt =99;
			
			for(int i=100;i<=num;i++)
			{
				//�� �ڸ��� �� ���ϱ�
				int hun= i/100;
				int ten=(i/10)%10;
				int one=i%10;
				
				//�� �ڸ����� ���������ΰ�?
				if(hun-ten==ten-one)
				{
					cnt++;
				}
			}
		}
		return cnt;
	}

}
