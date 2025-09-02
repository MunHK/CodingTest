import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int result[]=new int[200002];
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		int k=sc.nextInt();
		Arrays.fill(result, Integer.MAX_VALUE);
		
		PriorityQueue<subin> pq = new PriorityQueue<>();
		pq.add(new subin(n,0));
		result[n]=0;
		while(!pq.isEmpty()) {
			subin now = pq.poll();
			if(now.x==k) break;
			
			int minus=now.x-1;
			int plus=now.x+1;
			int mul=now.x*2;
			
			if(minus>=0 && result[minus]>now.cost+1) {
				result[minus]=now.cost+1;
				pq.add(new subin(minus,result[minus]));
			}
			if(plus<=200000 && result[plus]>now.cost+1) {
				result[plus]=now.cost+1;
				pq.add(new subin(plus,result[plus]));
			}
			if(mul<=200001 && result[mul]>now.cost) {
				result[mul]=now.cost;
				pq.add(new subin(mul,result[mul]));
			}
			
		}
		System.out.println(result[k]);
	}
}

class subin implements Comparable<subin>{
	int x,cost;
	subin(int x,int cost){
		this.x=x;
		this.cost=cost;
	}
	@Override
	public int compareTo(subin o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.cost, o.cost);
	}
	
}