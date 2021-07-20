/*
 * ���� 1193 �м�ã��
 * �̿� ���� ������ �м����� 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> �� �� ���� ������� ������ 
 * ���ʴ�� 1��, 2��, 3��, 4��, 5��, �� �м���� ����.X�� �־����� ��, X��° �м��� ���ϴ� ���α׷�
 * 
 * t= �и� +����
 * �밢�� �迭�� �� = t-1
 * t�� Ȧ���� �밢�� ������ t�� ¦���� �밢�� �Ʒ����� �д´�.
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(bf.readLine());
		
		int t=2,sum=1;
		
		//n��° �м��� �ش��ϴ� �밢�� �������� t���� �м��� �� ���� ���Ѵ�.
		while(sum<n)
		{
			sum+=t;
			t++;
		}
		//¦�� Ȧ������ �Ǵ�
		if(t%2==0)
		{
			//sum-n�� �밢�� �������� n��° ������ �Ÿ��̹Ƿ� ���ڿ� �и��� ���Ҽ� �ִ�.
			System.out.println((1+(sum-n))+"/"+(t-1-(sum-n)));
		}else
		{
			System.out.println((t-1-(sum-n))+"/"+(1+(sum-n)));
		}
		
	}
}
