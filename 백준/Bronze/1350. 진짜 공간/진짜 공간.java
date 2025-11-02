import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] files = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            files[i] = Long.parseLong(st.nextToken());
        }

        long cluster = Long.parseLong(br.readLine());
        long total = 0;

        for (long file : files) {
            if (file == 0) continue; 
            long clustersNeeded = (file + cluster - 1) / cluster;
            total += clustersNeeded * cluster;
        }

        System.out.println(total);
    }
}
