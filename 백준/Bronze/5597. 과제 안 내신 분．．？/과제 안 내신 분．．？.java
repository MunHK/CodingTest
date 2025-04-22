import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] n=new int[30];
        for(int i=0;i<28;i++){
            int num=Integer.parseInt(br.readLine());
            n[num-1]+=1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<30;i++){
            if(n[i]==0)
                sb.append(i+1).append("\n");
        }
        System.out.println(sb);
    }
}