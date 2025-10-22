import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int in[];
	static boolean visited[];
	static int num[];
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		in=new int[n];
		num=new int[n];
		visited=new boolean[n];
		for(int i=0;i<n;i++) 
			in[i]=Integer.parseInt(st.nextToken());
		recursive(0);
		System.out.println(result);
	}
	private static void recursive(int idx) {
		if(idx==n) {
			int a=num[0],sum=0;
			for(int i=1;i<n;i++) {
				sum+=Math.abs(a-num[i]);
				a=num[i];
			}
			result=Math.max(result, sum);
			return;
		}
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				visited[i]=true;
				num[idx]=in[i];
				recursive(idx+1);
				visited[i]=false;
			}
		}
	}
}
