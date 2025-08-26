//20250826 과제

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Island implements Comparable<Island>{
	int a,b;
	double d;

	Island(int a,int b,double d) {
		this.a=a;
		this.b=b;
		this.d=d;
	}

	@Override
	public int compareTo(Island o) {
		// TODO Auto-generated method stub
		return Double.compare(this.d, o.d);
	}
	
}
public class Solution {
	static int[][] graph;
	static ArrayList<Island> is;
	static int[] parent;
	static int n;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			n=Integer.parseInt(br.readLine());
			double tex,result=0;
			int cnt=0;
			graph=new int[n][2];
			parent=new int[n];
			is=new ArrayList<>();
			StringTokenizer stx = new StringTokenizer(br.readLine());
			StringTokenizer sty = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				graph[i][0]=Integer.parseInt(stx.nextToken());
				graph[i][1]=Integer.parseInt(sty.nextToken());
				parent[i]=i;
			}
			tex=Double.parseDouble(br.readLine());
			
			for(int i=0;i<n;i++) {
				for(int j=i+1;j<n;j++) {
					double degree=Math.pow(Math.abs(graph[i][0]-graph[j][0]),2)+Math.pow(Math.abs(graph[i][1]-graph[j][1]),2);
					is.add(new Island(i,j,degree));
				}
			}
			
			Collections.sort(is);
			for(int i=0;i<is.size();i++) {
				Island island = is.get(i);
				if(find(island.a)!=find(island.b)) {
					union(island.a,island.b);
					result+=tex*island.d;
					cnt+=1;
				}
				if(cnt==n-1)
					break;
			}
			System.out.println("#"+tc+" "+Math.round(result));
		}
	}
	static int find(int i) {
		if(parent[i]==i)
			return i;
		return parent[i]=find(parent[i]);
	}
	static void union(int a,int b) {
		a=find(a);
		b=find(b);
		if(a!=b)
			parent[b]=a;
	}
}
