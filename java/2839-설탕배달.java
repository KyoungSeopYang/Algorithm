/*
 * ���� 2839 �������
 * ���� Nų�α׷��� �Է¹����� 5�� 3Ű�α׷� ������ ���� ����Ҷ� �ּ����� ������� ���
 * ����������������� -1 ���
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(bf.readLine());
		int output=0;
		
		
		while(n>0)
		{
			//5�� ����� 5ų�α׷����� ������ �������°� �ּҰ��̰�
			if(n%5==0) {
				output +=n/5;
				break;
			} //�׷��� �ʴٸ� 3Ű�α׷� �Ѻ����� ì����
			else {
				n-=3;
				output++;
			}
		
		}
		
		if(n<0)
			System.out.println(-1);
		else
			System.out.println(output);
		
	}
}
