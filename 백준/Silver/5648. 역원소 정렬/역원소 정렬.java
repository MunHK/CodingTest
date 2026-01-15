import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		int n = Integer.parseInt(st.nextToken());
		int cnt=0;
		
		while(st.hasMoreTokens() && cnt<n) {
			String num = st.nextToken();
			String reverse = new StringBuilder(num).reverse().toString();
			pq.add(Long.parseLong(reverse));
			cnt++;
		}
		
		while(cnt<n) {
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens() && cnt<n) {
				String num = st.nextToken();
				String reverse = new StringBuilder(num).reverse().toString();
				pq.add(Long.parseLong(reverse));
				cnt++;
			}
		}
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
}
