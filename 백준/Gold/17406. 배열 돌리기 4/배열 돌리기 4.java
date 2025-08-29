import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n,m,k;
	static int roin[][];
	static int graph[][];
	static int gogrp[][];
	static int cs[];
	static int dx[]= {1, 0, -1, 0};
	static int dy[]= {0, 1, 0, -1};
	static boolean[] visited;
	static List<int[]> list=new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		int result=Integer.MAX_VALUE;
		roin=new int[k][3];
		cs=new int[k];
		graph=new int[n][m];
		visited=new boolean[k];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				graph[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<k;i++) {
			st=new StringTokenizer(br.readLine());
			roin[i][0]=Integer.parseInt(st.nextToken());
			roin[i][1]=Integer.parseInt(st.nextToken());
			roin[i][2]=Integer.parseInt(st.nextToken());
		}
		recur(0);
		for(int i=0;i<list.size();i++) {
			int[] let = list.get(i);
			gogrp=new int[n][m];
			for(int w=0;w<n;w++) {
				System.arraycopy(graph[w], 0, gogrp[w], 0, m);
			}
			for(int j=0;j<k;j++) {
				rotate(let[j],gogrp);
			}
			for(int x=0;x<n;x++) {
				int sm=0;
				for(int y=0;y<m;y++) {
					sm+=gogrp[x][y];
				}
				result=Math.min(sm, result);
			}
		}
		System.out.println(result);
	}
	static void rotate(int time,int[][] graph) {
		int xMin=roin[time][0]-roin[time][2]-1;
		int yMin=roin[time][1]-roin[time][2]-1;
		int xMax=roin[time][0]+roin[time][2]-1;
		int yMax=roin[time][1]+roin[time][2]-1;
		int max=roin[time][2];
		int index;
		for(int cnt=0;cnt<max;cnt++) {
			int x=xMin;
			int y=yMin;
			int start=graph[xMin][yMin];
			index=0;
			while(index<4) {
				int nx=x+dx[index];
				int ny=y+dy[index];
				if(nx>=xMin && nx<=xMax && ny>=yMin && ny<=yMax) {
					graph[x][y]=graph[nx][ny];
					x=nx;
					y=ny;
				}
				else {
					index++;
				}
			}
			graph[xMin][yMin+1]=start;
			xMin++; yMin++; xMax--; yMax--;
		}
	}
	static void recur(int index) {
		if(index==k) {
			list.add(cs.clone());
			return;
		}
		for(int i=0;i<k;i++) {
			if(!visited[i]) {
				visited[i]=true;
				cs[index]=i;
				recur(index+1);
				visited[i]=false;
			}
		}
	}
}
