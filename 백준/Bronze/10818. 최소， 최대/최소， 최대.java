import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int num[] = new int[n];
        for(int i=0;i<n;i++)
            num[i]=Integer.parseInt(st.nextToken());
        
        Arrays.sort(num);
        System.out.println(num[0]+" "+num[n-1]);
    }
}