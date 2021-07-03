/*
 * ���� 2869�� �����̴� �ö󰡰� �ʹ�
 * ���� V������ �������뿡 �����̰� ���� A���� �ö󰡰� �㿡 B���� �ö󰥶� ���� �ð����µ� ��ĥ�̰ɸ���
 * A , B , V �� �������� ���еǾ� �Էµȴ�.
 * �� �ð����� 0.15��
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String str=bf.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		int v=Integer.parseInt(st.nextToken());
		int day;
		
		//a-b : �Ϸ翡 �ö󰥼��ִ� ����, v-a : ���� ���� �Ϸ���
		//������ �� �������°�, �ƴѰ��� ���� ������ �ʿ��ϴ�.
		// �� ����������� �Ϸ縸 �� �ö󰡸� ���� �����ϹǷ� +1
		// �� ������ ���������ʾ����� 2�Ͽ� �� �ʿ��ϹǷ� +2
		if((v-a)%(a-b)==0)
		{
			day=(v-a)/(a-b)+1;
		}
		else
		{
			day=(v-a)/(a-b)+2;
		}
				
		System.out.println(day);
		
	}
}
