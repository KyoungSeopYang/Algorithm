import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		Student[] arr= new Student[N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			String name=st.nextToken();
			int kor=Integer.parseInt(st.nextToken());
			int eng=Integer.parseInt(st.nextToken());
			int math=Integer.parseInt(st.nextToken());
			
			arr[i]=new Student(name,kor,eng,math);
		}
		
		Arrays.sort(arr,new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				if(s1.kor==s2.kor) {
					if(s1.eng==s2.eng) {
						if(s1.math==s2.math) {
							//국영수가 같을때
							return s1.name.compareTo(s2.name);
						}
						//국영이 같을때
						return s2.math-s1.math;
					}
					//국어가 같을때
					return s1.eng-s2.eng;
				}
				return s2.kor-s1.kor;
			}
		});
		
		StringBuilder sb= new StringBuilder();
		
		for(int i=0;i<N;i++) {
			sb.append(arr[i].name).append("\n");
		}
		System.out.print(sb);
	}
	
	public static class Student{
		String name;
		int kor;
		int eng;
		int math;
		
		public Student(String name,int kor,int eng,int math) {
			this.name=name;
			this.kor=kor;
			this.eng=eng;
			this.math=math;
		}
	}
}