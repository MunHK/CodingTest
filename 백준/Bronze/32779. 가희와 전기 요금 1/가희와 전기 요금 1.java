import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            int a = Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());

            double result=(a*m*105.6)/(60*1000);

            System.out.println((int)result);
        }
    }
}