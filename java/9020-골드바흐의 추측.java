/*
 * ���� 9020 �������� ����
 * 2���� ū ¦�� n�� �־������� n= a+b (�� a,b�� �Ҽ�) �� ������ ��Ƽ���̶�� �Ѵ�.
 * �̶� n�� ������ ��Ƽ���� ����ϴ� ���α׷�
 * ���� ������ ������� ��Ƽ���� ���������� ��쿡�� �� �Ҽ��� ���̰� ���� �������� ����Ѵ�.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	//N�� �ִ밪 10000������ �Ҽ��� ���غ���
	static int max=10001;
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] prime = new boolean[max];
		
		prime[0]=prime[1]=true;
		
		for(int i=2;i<=Math.sqrt(max);i++)
		{
			if(prime[i])
				continue;
			for(int j=i*i;j<prime.length;j+=i)
			{
				prime[j]=true;
			}
		}
		// �׽�Ʈ ���̽�
		int t=Integer.parseInt(br.readLine());
		
		//¦�� n�� ���ݾ� ����� a�� 1���� b�� 1�������Ѽ� a��b�� �Ҽ��϶� ���� �ݺ��Ѵ�.
		while(t-->0)
		{
			int n=Integer.parseInt(br.readLine());
			int a= n/2;
			int b= n/2;
			
			while (true) {
				// �� ��Ƽ���� ��� �Ҽ��� break;
				if(!prime[a] && !prime[b]) {
					System.out.println(a + " " + b);
					break;
				}
				a--;
				b++;
			}
		}
	}
}