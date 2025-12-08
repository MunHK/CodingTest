import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int a,b;
	static PriorityQueue<Integer> result = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a=Integer.parseInt(st.nextToken());
		b=Integer.parseInt(st.nextToken());
		
		TreeSet<Integer> aa = new TreeSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<a;i++) {
			aa.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<b;i++) {
			aa.remove(Integer.parseInt(st.nextToken()));
		}
		System.out.println(aa.size());
		for(int num:aa) {
			System.out.print(num+" ");
		}
	}
}
