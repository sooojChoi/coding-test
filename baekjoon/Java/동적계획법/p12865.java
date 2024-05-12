package baekjoon.Java.동적계획법;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p12865 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N, K;
        int[][] dp;

        try{
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            dp = new int[K+1][N+1];

            int w, v;
            for(int i=1;i<=N;i++){
                st = new StringTokenizer(br.readLine());
                w = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                
                for(int j=0;j<=K;j++){
                    if(w <= j){
                        dp[j][i] = Math.max(dp[j][i-1],dp[j-w][i-1]+v);
                    }else{
                        dp[j][i] = dp[j][i-1];
                    }
                }
        
            }

            
            System.out.println(dp[K][N]);

        }catch(Exception e){
            System.out.println(e);
        }

    }
    
}