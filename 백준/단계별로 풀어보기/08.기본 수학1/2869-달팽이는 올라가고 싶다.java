/*
 * 백준 2869번 달팽이는 올라가고 싶다
 * 높이 V미터의 나무막대에 달팽이가 낮에 A미터 올라가고 밤에 B미터 올라갈때 정상에 올가가는데 며칠이걸리나
 * A , B , V 가 공백으로 구분되어 입력된다.
 * 단 시간제한 0.15초
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
		
		//a-b : 하루에 올라갈수있는 높이, v-a : 정상 도착 하루전
		//나누어 딱 떨어지는가, 아닌가에 대한 구분이 필요하다.
		// 딱 나누어떨어지면 하루만 더 올라가면 정상에 도착하므로 +1
		// 딱 나누어 떨어지지않았으면 2일에 더 필요하므로 +2
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
