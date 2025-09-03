import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num[]=new int[n];
		int dp[]=new int[n];
		int result=0;
		for(int i=0;i<n;i++) {
			num[i]=sc.nextInt();
		}
		for(int i=n-1;i>=0;i--) {
			for(int j=i+1;j<n;j++) {
				if(num[i]>num[j]) {
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}
		}
		for(int i=0;i<n;i++) {
			result=Math.max(result, dp[i]);
		}
		System.out.println(result+1);
	}
}
