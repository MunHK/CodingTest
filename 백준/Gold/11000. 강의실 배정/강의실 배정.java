import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static PriorityQueue<CLS> pq = new PriorityQueue<>();
	static PriorityQueue<Integer> room = new PriorityQueue<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.add(new CLS(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		while(!pq.isEmpty()) {
			CLS cls = pq.poll();
			
			if(!room.isEmpty() && room.peek()<=cls.start)
				room.poll();
			
			room.add(cls.end);
		}
		System.out.println(room.size());
	}
	
	static class CLS implements Comparable<CLS>{
		int start,end;
		CLS(int start,int end){
			this.start=start;
			this.end=end;
		}
		@Override
		public int compareTo(CLS o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.start,o.start);
		}
	}
}
