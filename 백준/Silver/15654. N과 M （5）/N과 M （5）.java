import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int num[];
	static int pt[];
	static boolean visited[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		num = new int[n];
		pt=new int[m];
		visited=new boolean[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		recursive(0);
		System.out.println(sb.toString());
	}
	static void recursive(int index) {
		if(index==m) {
			for(int i=0;i<m;i++) {
				sb.append(pt[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				visited[i]=true;
				pt[index]=num[i];
				recursive(index+1);
				visited[i]=false;
			}
		}
	}
	
}
