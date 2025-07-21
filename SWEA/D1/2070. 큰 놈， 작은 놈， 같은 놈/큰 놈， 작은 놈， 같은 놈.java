import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int test=1;test<=t;test++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a>b)
                System.out.println("#"+test+" >");
            else if(a<b)
                System.out.println("#"+test+" <");
            else
                System.out.println("#"+test+" =");
            
        }
    }
}