import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int l,c;
	static boolean[] visited;
	static List<Integer> alpha = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		l=Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		visited=new boolean[c];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<c;i++) {
			alpha.add((int)st.nextToken().charAt(0)-97);
		}
		Collections.sort(alpha);
		recursive(0,0,new int[l]);
		System.out.println(sb.toString());
	}
	private static void recursive(int start,int idx, int[] list) {
		if(idx==l) {
			int a=0,b=0;
			for(int i=0;i<idx;i++) {
				if(list[i]==0||list[i]==4||list[i]==8||list[i]==14||list[i]==20) a+=1;
				else b+=1;
			}
			if(a>=1 && b>=2) {
				for(int i=0;i<idx;i++) {
					sb.append((char)(list[i]+97));
				}
				sb.append("\n");
			}
			return;
		}
		for(int i=start;i<c;i++) {
			visited[i]=true;
			list[idx]=alpha.get(i);
			recursive(i+1,idx+1,list);
			visited[i]=false;
		}
	}
	
}
