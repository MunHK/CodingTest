import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static PriorityQueue<Long> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Long result=0L;
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			pq.add(Long.parseLong(st.nextToken()));
		}
		for(int i=0;i<m;i++) {
			long a = pq.poll();
			long b = pq.poll();
			pq.add(a+b);
			pq.add(a+b);
		}
		
		for(Long num:pq) {
			result+=num;
		}
		System.out.println(result);
	}
}