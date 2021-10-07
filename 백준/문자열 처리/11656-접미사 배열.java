import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		String str=br.readLine();
		int size = str.length();
		
		String[] arr=new String[size];
		
		arr[size-1] = Character.toString(str.charAt(size-1));
		
		for(int i=size-2;i>=0;i--) {
			arr[i]=str.charAt(i)+arr[i+1];
		}
		
		Arrays.sort(arr);
		
		for(String s : arr) {
			sb.append(s).append('\n');
		}
		System.out.println(sb);
	}
}    