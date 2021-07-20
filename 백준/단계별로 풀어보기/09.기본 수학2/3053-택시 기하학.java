/*
 * 백준 3053 택시기하학
 * 반지름 R이 주어졌을때 유클리드 기하학에서 원의 넓이와 택시 기하학에서 원의 넓이를 구하는 프로그램
 * 
 * 유클리드 기하학은 Pi*r*r
 * 택시 기하학은 2*r*r
 * 
 * 개념 https://st-lab.tistory.com/89
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