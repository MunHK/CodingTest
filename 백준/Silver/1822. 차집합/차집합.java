import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int a,b;
	static int[] aa;
	static int[] bb;
	static PriorityQueue<Integer> result = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a=Integer.parseInt(st.nextToken());
		b=Integer.parseInt(st.nextToken());
		
		aa=new int[a];
		bb=new int[b];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<a;i++) {
			aa[i]=Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<b;i++) {
			bb[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(bb);
		for(int i=0;i<a;i++) {
			binSearch(aa[i]);
		}
		int size=result.size();
		System.out.println(size);
		for(int i=0;i<size;i++) {
			System.out.print(result.poll()+" ");
		}
	}
	private static void binSearch(int num) {
		int left=0;
		int mid=b/2;
		int right=b-1;
		while(true) {
			if(bb[mid]==num) {
				break;
			}else if(bb[mid]>num) {
				right=mid;
				mid=(right+left)/2;
			}else if(bb[mid]<num) {
				left=mid;
				mid=(right+left)/2;
			}
			if(Math.abs(right-left)<=1) {
				if(bb[left]!=num && bb[right]!=num)
					result.add(num);
				break;
			}
		}
	}
}
