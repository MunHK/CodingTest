import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,result=0;
	static Flower[] flower;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n=Integer.parseInt(br.readLine());
		flower=new Flower[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			flower[i]=new Flower(a,b,c,d);
		}
		Arrays.sort(flower);
		
		int startMonth=3;
		int startDay=1;
		int endMonth=0;
		int endDay=0;
		int start=0;
		
		while(startMonth < 11 || (startMonth == 11 && startDay <= 30)) {
			boolean flag=false;
			int i=start;
			for(;i<n;i++) {
				Flower now = flower[i];
				if(now.startMonth>startMonth || (now.startMonth==startMonth&&now.startDay>startDay)) {
					break;
				}
				
				if(now.startMonth<startMonth || (now.startMonth==startMonth && now.startDay<=startDay)) {
					if(now.endMonth>endMonth ||(now.endMonth==endMonth && now.endDay>endDay)) {
						flag=true;
						endMonth=now.endMonth;
						endDay=now.endDay;
					}
				}
			}
			if(flag) {
				startMonth=endMonth;
				startDay=endDay;
				result+=1;
				start=i;
			}
			if(!flag) {
				System.out.println(0);
				return;
			}
		}
		System.out.println(result);
	}
	
	static class Flower implements Comparable<Flower>{
		int startMonth,startDay,endMonth,endDay;
		public Flower(int startMonth,int startDay,int endMonth,int endDay) {
			this.startMonth=startMonth;
			this.startDay=startDay;
			this.endMonth=endMonth;
			this.endDay=endDay;
		}
		@Override
		public int compareTo(Flower o) {
			if(this.startMonth==o.startMonth) {
				if(this.startDay==o.startDay) {
					if(this.endMonth==o.endMonth) {
						return Integer.compare(o.endDay, this.endDay);
					}
					return Integer.compare(o.endMonth, this.endMonth);
				}
				return Integer.compare(this.startDay, o.startDay);
			}
			return Integer.compare(this.startMonth, o.startMonth);
		}
		
	}
}
