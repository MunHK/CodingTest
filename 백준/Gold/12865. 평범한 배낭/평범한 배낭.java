import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int dp[][];
	static List<Bag> list;
	static int n,k,result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		list.add(new Bag(0,0));
		dp=new int[n+1][k+1];
		result=0;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Bag(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		for(int i=1;i<=n;i++) {
			Bag bag=list.get(i);
			for(int j=1;j<=k;j++) {
				dp[i][j]=dp[i-1][j];
				if(j>=bag.v) 
					dp[i][j]=Math.max(dp[i][j], dp[i-1][j-bag.v]+bag.c);
				result=Math.max(result, dp[i][j]);
			}
		}
		System.out.println(result);
		
	}
	static class Bag{
		int v,c;
		Bag(int v,int c){
			this.v=v;
			this.c=c;
		}
	}
}

