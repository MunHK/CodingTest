import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n,result=1,time=0;
	static PriorityQueue<Meeting> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n=Integer.parseInt(br.readLine());
		list=new PriorityQueue<>();
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			list.add(new Meeting(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		time=list.poll().end;
		for(int i=1;i<n;i++) {
			Meeting meet = list.poll();
			if(meet.start<time)
				continue;
			else{
				result+=1;
				time=meet.end;
			}
			//System.out.println("start: "+meet.start+",  end: "+meet.end+",  time: "+time);
		}
		System.out.println(result);
		
		
		
		
	}
	
	
	
	static class Meeting implements Comparable<Meeting>{
		int start,end;
		Meeting(int start, int end){
			this.start=start;
			this.end=end;
		}
		@Override
		public int compareTo(Meeting o) {
			// TODO Auto-generated method stub
			if(this.end==o.end)
				return Integer.compare(this.start, o.start);
			else
				return Integer.compare(this.end, o.end);
		}
	}
}
