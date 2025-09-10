import java.io.*;
import java.util.*;
 
public class Solution {
   public static void main(String[] args) throws IOException {
      BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      StringTokenizer st;
      int T = Integer.parseInt(in.readLine());
      for(int tc=1;tc<=T;tc++){
         st = new StringTokenizer(in.readLine());
         int N = Integer.parseInt(st.nextToken());
         int[][] adj = new int[N][N];
 
         for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
               adj[i][j] = Integer.parseInt(st.nextToken());
            }
         }
 
         int min = Integer.MAX_VALUE;
         for(int i=0;i<N;i++){
            int tmp = 0;
            int[] visited = new int[N];
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(i);
 
            while(!queue.isEmpty()){
               int x = queue.poll();
               for(int j=0;j<N;j++){
                  if(i==j) continue;
                  if(visited[j]!=0 || adj[x][j]==0) continue;
                  visited[j] = visited[x]+1;
                  tmp += visited[j];
                  queue.offer(j);
               }
            }
 
            if(min>tmp) min = tmp;
         }
 
         sb.append("#").append(tc).append(" ").append(min).append("\n");
      }
      System.out.print(sb);
   }
}