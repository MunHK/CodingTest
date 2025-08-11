import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] graph;
	static int n,m;
	static int[][] home;
	static int[][] ck;
	static int[] ch;
	static int cnt=0,hcnt=0;
	static boolean[] visited;
	static int minresult=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n=Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph=new int[n][n];
		home=new int[n*2][2];
		ck=new int[13][2];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<n;j++) {
				int a =Integer.parseInt(st.nextToken());
				switch(a) {
				case 1:
					home[hcnt][0]=i;
					home[hcnt][1]=j;
					hcnt+=1;
					break;
				case 2:
					ck[cnt][0]=i;
					ck[cnt][1]=j;
					cnt+=1;
					break;
				}
				graph[i][j]=a;
			}
		}
		visited=new boolean[cnt];
		ch=new int[m];
		ckst(0,0);
		System.out.println(minresult);
	}
	
	public static void ckst(int index,int start) {
		if(index==m) {
			minresult=Math.min(minresult, cal(ch));
			return;
		}
		
		for(int i=start;i<cnt;i++) {
			if(!visited[i]) {
				visited[i]=true;
				ch[index]=i;
				ckst(index+1,i+1);
				visited[i]=false;
			}
		}
	}
	public static int cal(int[] lst) {
		int result=0;
		int mn=Integer.MAX_VALUE;
		for(int i=0;i<hcnt;i++) {
			for(int j=0;j<m;j++) {
				int c = Math.abs(home[i][0]-ck[lst[j]][0])+Math.abs(home[i][1]-ck[lst[j]][1]);
				mn=Math.min(mn, c);
			}
			result+=mn;
			mn=Integer.MAX_VALUE;
		}
		return result;
	}
}