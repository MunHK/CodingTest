import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int m= Integer.parseInt(br.readLine());
        int result=m;
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int plus=Integer.parseInt(st.nextToken());
            int minus=Integer.parseInt(st.nextToken());
            m=m+plus-minus;
            result=Math.max(result,m);
            if(m<0){
                result=0;
                break;
            }
        }
        System.out.println(result);
    }
}