import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] n=new int[42];
        int result=0;
        for(int i=0;i<10;i++){
            int num=Integer.parseInt(br.readLine());
            n[num%42]+=1;
        }
        for(int j=0;j<42;j++){
            if(n[j]!=0)
                result+=1;
        }
        System.out.println(result);
    }
}