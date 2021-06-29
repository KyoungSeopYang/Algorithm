/*
 * ���� 2675 ���ڿ� �ݺ�
 * ���ڿ� S�� �Է¹��� �Ŀ� �� ���ڸ� R�� �ݺ��� �� ���ڿ� P�� ����� ����ϴ� ���α׷�
 */
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		//�׽�Ʈ ���̽� �� �Է�
		int n= Integer.parseInt(bf.readLine());
		
		//�׽�Ʈ ���̽� ��ŭ �ݺ�
		for(int a=0;a<n;a++)
		{
		  String input = bf.readLine();
			
			StringTokenizer st = new StringTokenizer(input);
			
			int t= Integer.parseInt(st.nextToken());
			String str=st.nextToken();
			
			//���ڿ��� ���Ҷ� StringBuilder Ŭ������ �����ϴ�
			StringBuilder sb= new StringBuilder();
			
			for(int i=0;i<str.length();i++) {
				for(int j=0;j<t;j++) {
					sb.append(str.charAt(i));
				}		
			}
			
			System.out.println(sb.toString());
		}
	
	}
}
