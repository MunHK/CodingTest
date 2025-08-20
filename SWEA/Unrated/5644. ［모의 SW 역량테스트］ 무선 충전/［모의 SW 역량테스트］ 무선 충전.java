import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class AP{
	int x;
	int y;
	int c;
	int p;
	public AP(){}
	public AP(int x,int y,int c,int p){
		this.x=x;
		this.y=y;
		this.c=c;
		this.p=p;
	}
}

public class Solution {
	static int result;
	static int[] dx= {0,-1,0,1,0};
	static int[] dy = {0,0,1,0,-1};
	static int M,A;
	static int[] am,bm;
	static AP ap[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(br.readLine());
		for(int t=1;t<=test;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			result=0;
			am = new int[M];
			bm = new int[M];
			
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<M;i++) 
				am[i]=Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<M;i++) 
				bm[i]=Integer.parseInt(st.nextToken());
			
			ap= new AP[A];
			for(int i=0;i<A;i++) {
				st=new StringTokenizer(br.readLine()," ");
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				int c=Integer.parseInt(st.nextToken());
				int p=Integer.parseInt(st.nextToken());
				ap[i]=new AP(y,x,c,p);
			}
			move();
			System.out.println("#"+t+" "+result);
		}
	}
	
	public static void move() {
		AP a = new AP(1,1,0,0);
		AP b = new AP(10,10,0,0);
		List<Integer> Aable=new ArrayList<>();
		List<Integer> Bable=new ArrayList<>();
		List<int[]> Numcase = new ArrayList<>();
		for(int i=-1;i<M;i++) {
			int idxa=0,idxb=0,mx=0;
			
			if(i>=0) {
				a.x+=dx[am[i]];
				a.y+=dy[am[i]];
				b.x+=dx[bm[i]];
				b.y+=dy[bm[i]];
			}
			
			for(int j=0;j<A;j++) {
				if(Math.abs(a.x-ap[j].x)+Math.abs(a.y-ap[j].y)<=ap[j].c) {
					Aable.add(j);
				}
				if(Math.abs(b.x-ap[j].x)+Math.abs(b.y-ap[j].y)<=ap[j].c) {
					Bable.add(j);
				}
			}
			
			if(Aable.size()>0 && Bable.size()==0) {
				for(int Ap:Aable)
					mx=Math.max(mx, ap[Ap].p);
			}
			else if(Bable.size()>0 && Aable.size()==0) {
				for(int Bp:Bable)
					mx=Math.max(mx, ap[Bp].p);
			}
			else {
				for(int Ap:Aable) {
					for(int Bp:Bable) {
						Numcase.add(new int[] {Ap,Bp});
					}
				}
				for(int[] idx : Numcase) {
					idxa=idx[0];
					idxb=idx[1];
					if(idxa==idxb) {
						mx=Math.max(mx, ap[idxa].p);
						continue;
					}
					mx=Math.max(mx, ap[idxa].p+ap[idxb].p);
				}
			}
			result+=mx;
			Aable.clear();
			Bable.clear();
			Numcase.clear();
		}
	}

}
