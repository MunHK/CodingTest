import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int num[];
	static int n,m;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			num=new int[n+1];
			for(int i=1;i<=n;i++)
				num[i]=i;
			for(int i=0;i<m;i++) {
				st=new StringTokenizer(br.readLine());
				int c=Integer.parseInt(st.nextToken());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				if(c==0) {
					union(a,b);
				}
				else if(c==1) {
					sb.append(find(a)==find(b) ? 1:0);
				}
					
			}
			System.out.println(sb.toString());
		}
	}
	
	static int find(int i) {
		if(num[i]==i)
			return i;
		return find(num[i]);
	}
	static void union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot==bRoot)
			return;
		else if(aRoot>bRoot)
			num[bRoot]=aRoot;
		else if(bRoot>aRoot)
			num[aRoot]=bRoot;
	}

}
