import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int n;
	static int[] weight;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		weight = new int[n];
		for (int i = 0; i < n; i++) {
			weight[i] = Integer.parseInt(st.nextToken());

		}
		Arrays.sort(weight);
		int sum=0;
		for(int i=0;i<n;i++) {
			if(sum+1>=weight[i])
				sum+=weight[i];
			else
				break;
		}
		System.out.println(sum+1);
	}

}
