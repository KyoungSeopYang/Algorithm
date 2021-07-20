/*
 * ���� 1978 �Ҽ�ã��
 * �־��� �� N�� �߿��� �Ҽ��� ����� ����ϴ� ���α׷�
 * 
 * �Ҽ��� ���ϴ� ����� 3����
 * 1. 2 ~ N-1���� N�� ���������� ������ �������� ���� ���°�?
 * 2. 2 ~ N�� �����ٱ��� N�� ���������� ������ �������� ���� ���°�?
 * 3. 2 ~ N�� �����ٱ����� ����� ã������ ���� �������� �����ϸ� ���°��� �Ҽ��̴�.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int t=Integer.parseInt(bf.readLine());
		StringTokenizer st=new StringTokenizer(bf.readLine());
		int count=0;
		
		for(int i =0;i<t;i++)
		{
			boolean isPrime = true;
			 
			int num=Integer.parseInt(st.nextToken());
			
			//1�� �Ҽ����ƴϴ�.
			if(num==1)
			{
				continue;
			}
			//Math.sqrt()�� �������� ���ϴ� �Լ� �� 2~�����ٱ������� N�� �������.
			for(int j=2;j<=Math.sqrt(num);j++)
			{
				//����������� ���� �ϳ��������� �Ҽ����ƴϹǷ� break
				if(num%j==0)
				{
					isPrime=false;
					break;
				}
			}
			if(isPrime)
				count++;
	
		}
		
		System.out.println(count);

		
	}
}
