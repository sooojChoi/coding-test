package baekjoon.Java;

import java.util.*;
import java.io.*;

public class p11404 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n, m;
        int[][] distance;

        try{
            n = Integer.parseInt(br.readLine());
            m = Integer.parseInt(br.readLine());
            distance = new int[n+1][n+1];

            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    distance[i][j] = Integer.MAX_VALUE;
                    if(i==j){
                        distance[i][j]=0;
                    }
                }
            }

            for(int line=0;line<m;line++){
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                if(distance[i][j] != Integer.MAX_VALUE){
                    distance[i][j] = Math.min(distance[i][j], w);
                }else{
                    distance[i][j]=w;
                }
            }

            for(int point=1;point<=n;point++){
                for(int start=1;start<=n;start++){
                    if(start==point){
                        continue;
                    }
                    for(int end=1;end<=n;end++){
                        if(start==end || end==point){
                            continue;
                        }
                        if(distance[start][point]==Integer.MAX_VALUE || distance[point][end]==Integer.MAX_VALUE){
                            continue;
                        }
                        distance[start][end] = Math.min(distance[start][end], distance[start][point]+distance[point][end]);
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(distance[i][j]==Integer.MAX_VALUE){
                        sb.append("0");
                    }else{
                        sb.append(distance[i][j]);
                    }
                    if(j==n){
                        sb.append("\n");
                    }else{
                        sb.append(" ");
                    }
                }
            }

            System.out.println(sb);
        }catch(Exception e){
            System.out.println(e);
        }

    }
}
