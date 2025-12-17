import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int n,k;
	static Queue<Integer> q = new ArrayDeque<>();
	static int[] path=new int[100001];
	static boolean[] visit=new boolean[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result=0;
		
		n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		
		q.add(n);
		
		while(!q.isEmpty()) {
			int num=q.poll();
			if(num==k) break;
			
			for(int now:new int[] {num+1,num-1,num*2}) {
				if(now>100000 || now<0) continue;
				if(visit[now]) continue;
				q.add(now);
				visit[now]=true;
				path[now]=num;
			}
		}
		Stack<Integer> stack = new Stack<>();
		while(true) {
			if(k==n) {
				stack.add(k);
				break;
			}
			stack.add(k);
			k=path[k];
			result+=1;
		}
		System.out.println(result);
		int size=stack.size();
		for(int i=0;i<size;i++) {
			System.out.print(stack.pop()+" ");
		}
	}
	
}
