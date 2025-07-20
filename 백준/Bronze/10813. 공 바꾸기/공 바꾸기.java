import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a=br.readLine().split(" ");
        int n = Integer.parseInt(a[0]);
        int m = Integer.parseInt(a[1]);
        int num[] = new int[n];
        for(int i=0;i<n;i++)
            num[i]=i+1;
        for(int i=0;i<m;i++){
            a=br.readLine().split(" ");
            int x=Integer.parseInt(a[0]);
            int y=Integer.parseInt(a[1]);
            int z=num[x-1];
            num[x-1]=num[y-1];
            num[y-1]=z;
        }
        for(int i=0;i<n;i++)
            System.out.printf(num[i]+" ");
        
    }
}