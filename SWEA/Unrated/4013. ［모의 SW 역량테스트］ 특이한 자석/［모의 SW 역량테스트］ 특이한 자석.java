import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Rot{
	int num,go;
	Rot(int num,int go){
		this.num=num;
		this.go=go;
	}
}
public class Solution {
	static List<Integer> wheel[];
	static int k,result;
	static List<Rot> in;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			k = Integer.parseInt(br.readLine());
			wheel=new ArrayList[4];
			result=0;
			in=new ArrayList<>();
			for(int i=0;i<4;i++) {// 0=n 1=s
				wheel[i]=new ArrayList<>();
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<8;j++) {
					wheel[i].add(Integer.parseInt(st.nextToken()));
				}
			}
			for(int i=0;i<k;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int num=Integer.parseInt(st.nextToken());
				int go=Integer.parseInt(st.nextToken());
				in.add(new Rot(num,go));
			}
			for(int i=0;i<k;i++) {
				rotate(in.get(i));
				for(int j=0;j<4;j++) {
					//System.out.println(wheel[j].toString());
				}
			}
			for(int i=0;i<4;i++) {
				if(wheel[i].get(0)==1) {
					if(i==0) result+=1;
					else if(i==1) result+=2;
					else if(i==2) result+=4;
					else if(i==3) result+=8;
				}
			}
			System.out.println("#"+tc+" "+result);
		}
	}
	
	static void rotate(Rot rot) {//1 = 오른쪽,  -1 = 왼쪽
		int[] cango = new int[4];
		boolean[] can = new boolean[4];
		
		cango[rot.num-1]=rot.go;
		can[rot.num-1]=true;
		for(int i=rot.num-1;i<3;i++) {
			if(!with(i,i+1)) break;
			else {
				can[i+1]=true;
				cango[i+1]=cango[i]==1?-1:1;
			}
		}
		for(int i=rot.num-1;i>0;i--) {
			if(!with(i-1,i)) break;
			else {
				can[i-1]=true;
				cango[i-1]=cango[i]==1?-1:1;
			}
		}
		for(int i=0;i<4;i++) {
			if(can[i]) {
				if(cango[i]==1) {
					int num=wheel[i].get(7);
					wheel[i].remove(7);
					wheel[i].add(0, num);
				}
				else if(cango[i]==-1) {
					int num=wheel[i].get(0);
					wheel[i].remove(0);
					wheel[i].add(num);
				}
			}
		}
	}
	static boolean with(int a,int b) {
		if(wheel[a].get(2)!=wheel[b].get(6))
			return true;
		return false;
	}
}
