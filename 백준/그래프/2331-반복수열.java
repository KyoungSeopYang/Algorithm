import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int A=Integer.parseInt(st.nextToken());
		int P=Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list=new ArrayList<>();
		
		list.add(A);
		
		while(true) {
			
			int sum=0;
			while(A>0) {
				sum += Math.pow(A%10, P);
				A/=10;
			}
			if(list.contains(sum)) {
				System.out.println(list.indexOf(sum));
				break;
			}
			A=sum;
			list.add(A);
		}

	}
}