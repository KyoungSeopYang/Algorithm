/*
 * ���� 1152 �ܾ��� ����
 * ���� ��ҹ��ڿ� ���⸸���� �̷���� ���ڿ��� �Է¹޾����� ��� �ܾ�ִ��� ���
 * �ߺ��ܾ ������ Ƚ����ŭ ī��Ʈ, ���ڿ� �յڷ� ������ ���� �� �ִ�.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args)throws IOException {
			BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
			
			String input= bf.readLine();
			
			//StringTokenizer�δ� �迭 ũ�⸦ ���ϱ� ��ƴ�. �׷��� split()���
			String[] str=input.split(" ");
			int count=0;
			
			//�յڿ� ���鹮�ڰ� ������ �ֱ⶧���� �߰��� for��
			for(int i=0; i<str.length;i++)
			{
				if(str[i]!="")
				{
					count++;
				}
			}
			
			System.out.println(count);		
	}
}
