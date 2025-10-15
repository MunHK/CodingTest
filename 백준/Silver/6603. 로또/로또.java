import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int num[];
	static int list[];
	static boolean visited[];
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
			n = Integer.parseInt(st.nextToken());
			
			if(n==0)
				break;
			
			num=new int[n];
			list=new int[6];
			visited=new boolean[n];
			
			for(int i=0;i<n;i++) {
				num[i]=Integer.parseInt(st.nextToken());
			}
			
			recursive(0,0);
			System.out.println(sb.toString());
		}
	}
	private static void recursive(int idx, int m) {
		if(idx==6) {
			for(int i=0;i<6;i++) 
				sb.append(list[i]).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i=m;i<n;i++) {
			if(!visited[i]) {
				visited[i]=true;
				list[idx]=num[i];
				recursive(idx+1,i+1);
				visited[i]=false;
			}
		}
	}
	
}
