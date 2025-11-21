import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,result=0;
	static int[] numA;
	static int[] numB;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		numA=new int[n];
		numB=new int[n];
		
		StringTokenizer stA = new StringTokenizer(br.readLine());
		StringTokenizer stB = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			numA[i]=Integer.parseInt(stA.nextToken());
			numB[i]=Integer.parseInt(stB.nextToken());
		}
		Arrays.sort(numA);
		Arrays.sort(numB);
		for(int i=0;i<n;i++) {
			result+=numA[i]*numB[n-1-i];
		}
		System.out.println(result);
	}
	
}
