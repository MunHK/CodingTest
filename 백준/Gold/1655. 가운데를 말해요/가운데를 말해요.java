import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	static PriorityQueue<Integer> leftpq = new PriorityQueue<>(new Comparator<Integer>() {
		public int compare(Integer o1, Integer o2) {
			return Integer.compare(o2,o1);
			};
	});
	static PriorityQueue<Integer> rightpq = new PriorityQueue<>(new Comparator<Integer>() {
		public int compare(Integer o1, Integer o2) {
			return Integer.compare(o1,o2);
			};
	});
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		for(int i=1;i<=n;i++) {
			int num = Integer.parseInt(br.readLine());
			
			leftpq.add(num);
			
			if(!rightpq.isEmpty() && leftpq.peek()>rightpq.peek()) {
				rightpq.add(leftpq.poll());
				leftpq.add(rightpq.poll());
			}
			if(leftpq.size()>rightpq.size()+1) {
				rightpq.add(leftpq.poll());
			}
			sb.append(leftpq.peek()).append("\n");
		}
		System.out.println(sb.toString());
	}
	
}
