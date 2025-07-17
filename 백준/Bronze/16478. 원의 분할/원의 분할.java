import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n[]=new int[3];
        for(int i=0;i<3;i++)
            n[i]=Integer.parseInt(st.nextToken());
        System.out.println((double)n[0]*n[2]/n[1]);
    }
}