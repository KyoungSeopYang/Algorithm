/*
 * ���� 3053 �ýñ�����
 * ������ R�� �־������� ��Ŭ���� �����п��� ���� ���̿� �ý� �����п��� ���� ���̸� ���ϴ� ���α׷�
 * 
 * ��Ŭ���� �������� Pi*r*r
 * �ý� �������� 2*r*r
 * 
 * ���� https://st-lab.tistory.com/89
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		double r=Double.parseDouble(br.readLine());
		
		System.out.println(r*r*Math.PI);
		System.out.println(r*r*2);
	}
}