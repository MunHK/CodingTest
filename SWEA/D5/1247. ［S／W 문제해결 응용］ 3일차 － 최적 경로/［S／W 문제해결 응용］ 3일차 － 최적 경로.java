import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution{
	static int cus[][];
	static int home[]= new int[2];
	static int work[]=new int[2];
	static int mn;
	static int n;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int test = Integer.parseInt(br.readLine());
		for(int t=1;t<=test;t++) {
			n = Integer.parseInt(br.readLine());
			mn=Integer.MAX_VALUE;
			cus=new int[n][2];
			boolean[] visited=new boolean[n];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			home[0]=Integer.parseInt(st.nextToken());
			home[1]=Integer.parseInt(st.nextToken());
			
			work[0]=Integer.parseInt(st.nextToken());
			work[1]=Integer.parseInt(st.nextToken());
			for(int i=0;i<n;i++) {
				cus[i][0]=Integer.parseInt(st.nextToken());
				cus[i][1]=Integer.parseInt(st.nextToken());
			}
			search(0,0,visited,home);
			System.out.println("#"+t+" "+mn);
		}
		
	}
	public static void search(int index,int degree,boolean[] visited,int now[]) {
		if(index==n) {
			degree+=Math.abs(work[0]-now[0])+Math.abs(work[1]-now[1]);
			mn=Math.min(mn, degree);
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				visited[i]=true;
				int godegree=degree+Math.abs(now[0]-cus[i][0])+Math.abs(now[1]-cus[i][1]);
				search(index+1,godegree,visited,new int[] {cus[i][0],cus[i][1]});
				visited[i]=false;
			}
			
		}
	}
}