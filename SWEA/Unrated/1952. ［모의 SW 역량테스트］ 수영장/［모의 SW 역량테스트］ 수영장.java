import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int day,month,tmonth,year;
	static int[] cost;
	static boolean[] visited;
	static int mn;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for(int t=1;t<=test;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			day=Integer.parseInt(st.nextToken());
			month=Integer.parseInt(st.nextToken());
			tmonth=Integer.parseInt(st.nextToken());
			year=Integer.parseInt(st.nextToken());
			mn=Integer.MAX_VALUE;
			visited=new boolean[16];
			cost = new int[16];
			
			st=new StringTokenizer(br.readLine()," ");
			for(int i=0;i<12;i++) {
				cost[i]=Integer.parseInt(st.nextToken());
			}
			
			cal(0,0);
			System.out.println("#"+t+" "+mn);
		}
    }
	
	public static void cal(int loc, int sum) {
		if(loc>=12) {
			mn=Math.min(mn, sum);
			return;
		}
		
		if(visited[loc]) 
			cal(loc+1,sum);
		
		// 하루 이용권
		visited[loc]=true;
		cal(loc+1,sum+cost[loc]*day);
		visited[loc]=false;
		
		//한달 이용권
		visited[loc]=true;
		cal(loc+1,sum+month);
		visited[loc]=false;
		
		visited[loc]=true;
		visited[loc+1]=true;
		visited[loc+2]=true;
		cal(loc+3,sum+tmonth);
		visited[loc]=false;
		visited[loc+1]=false;
		visited[loc+2]=false;
		
		Arrays.fill(visited, true);
		cal(loc+11,sum+year);
		Arrays.fill(visited, false);
	}
}
