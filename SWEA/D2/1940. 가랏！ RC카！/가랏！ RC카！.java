import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] com;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			int n = Integer.parseInt(br.readLine());
			int speed=0,distance=0;
			com=new int[n][2];
			for(int i=0;i<n;i++) {
				st=new StringTokenizer(br.readLine());
				int how=Integer.parseInt(st.nextToken());
				if(how==0) {
					distance+=speed;
				}
				else if(how==1) {
					speed+=Integer.parseInt(st.nextToken());
					distance+=speed;
				}
				else {
					speed-=Integer.parseInt(st.nextToken());
					speed=(speed<0?0:speed);
					distance+=speed;
				}
			}
			System.out.println("#"+tc+" "+distance);
		}
	}
}
