import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int num[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		num=new int[n];
		
		st=new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++)
			num[i]=Integer.parseInt(st.nextToken());
		
		Arrays.sort(num);
		
		recursive(0,new int[m]);
		
		System.out.println(sb.toString());
	}
	private static void recursive(int index, int[] is) {
		if(index==m) {
			for(int i=0;i<m;i++) 
				sb.append(is[i]).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i=0;i<n;i++) {
			is[index]=num[i];
			recursive(index+1,is);
		}
	}
}
