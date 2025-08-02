import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int cow[] = {2,2,2,2,2,2,2,2,2,2,2};
    int n=sc.nextInt();
    int result=0;
    for(int i=0;i<n;i++){
        int a=sc.nextInt();
        int b=sc.nextInt();
        if(cow[a]==2){
            cow[a]=b;
        }
        else{
            if(cow[a]!=b){
                cow[a]=b;
                result+=1;
            }
        }
    }
    System.out.println(result);
  }
}