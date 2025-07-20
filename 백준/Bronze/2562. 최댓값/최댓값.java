import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mx=0;
        int ix=0;
        for(int i=0;i<9;i++){
            int a=Integer.parseInt(br.readLine());
            if(mx<a){
                ix=i;
                mx=a;
            }
        }
        System.out.printf(mx+"\n"+(ix+1));
    }
}