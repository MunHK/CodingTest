import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] num;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			int mx=0;
			long result=0;
			n=Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			num=new int[n];
			
			for(int i=0;i<n;i++) {
				num[i]=Integer.parseInt(st.nextToken());
			}
			mx=num[n-1];
			for(int i=n-2;i>=0;i--) {
				int now = num[i];
				if(now<mx) {
					result+=mx-now;
				}else {
					mx=now;
				}
			}
			System.out.println(result);
		}
		
	}
}

