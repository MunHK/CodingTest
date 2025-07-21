import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int test=1;test<=t;test++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int num[]=new int[10];
            for(int i=0;i<10;i++){
                num[i]=Integer.parseInt(st.nextToken());
            }
            Arrays.sort(num);
            System.out.println("#"+test+" "+num[9]);
            
        }
    }
}