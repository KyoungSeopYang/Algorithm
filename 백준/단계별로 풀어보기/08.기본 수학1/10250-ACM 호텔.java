/*
 * 백준 10250 ACM 호텔
 * 높이 H와 각 층에 W개의 객실을 가지고있는 직사각형의 호텔이 존재
 * 엘리베이터는 가장 좌측에있고 모든손님은 입구와 가장가까운 객실을 선호할때
 * N번째 손님의 객실호수는? YYXX or YXX 형식으로 출력 Y는 층수 XX는 몇번째방인가
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	/*
	 * 복잡해보이지만 왼쪽 아래부터 우측 상단으로 한칸씩 채워지는 2차원 배열을 생각해보자
	 * 즉 N / H는 N번째 손님의 객실의 번호가되지만 객실은 1호부터 시작하므로 +1
	 * N % H 는 N번째 손님의 객실 층수가된다
	 * 
	 * 하지만 N % H ==0이 라면 객실번호는 2가되버리기때문에 예외로 +1을 하지않고
	 * 층수또한 0층이 되어버리기때문에 예외적으로 H층이 배정받는 층수임을 명시하자
	 */
	public static void main(String[] args)throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int t=Integer.parseInt(bf.readLine());
		
		for(int i=1;i<=t;i++)
		{
			String str=bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			int h=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			int n=Integer.parseInt(st.nextToken());
			
			int x,y;
			
			if(n%h==0)
			{
				x=n/h;
				y=h*100;
			}
			else
			{
				y=(n%h)*100;
				x=(n/h)+1;
			}
			
			System.out.println(y+x);
		}
	}
}
