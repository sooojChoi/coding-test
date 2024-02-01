package baekjoon.Java.동적계획법;

import java.util.*;
import java.io.*;

public class p11049 {
    static int N;
    static Mat[] M;
    static int[][] dp;

    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        

        try{
            N = Integer.parseInt(br.readLine());
            M = new Mat[N+1];
            dp = new int[N+1][N+1];

            int r, c;
            for(int i=1;i<=N;i++){
                st = new StringTokenizer(br.readLine());
                r = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                M[i] = new Mat(r, c);
            }    

            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    dp[i][j]=-1;
                }
            }

            System.out.println(excute(1, N));
        }catch(Exception e){
            System.out.println(e);
        }
    }

    static int excute(int s, int e){
        if(dp[s][e]!=-1){
            return dp[s][e];
        }
        if(s==e){
            return 0;
        }
        if(s+1==e){
            return M[s].row*M[e].row*M[e].col;
        }
        int result = Integer.MAX_VALUE;
        for(int i=s;i<e;i++){
            result = Math.min(result, M[s].row*M[i].col*M[e].col + excute(s, i) + excute(i+1, e));
        }

        return dp[s][e] = result;
        
    }
    static class Mat{
        int row;
        int col;
    
        Mat(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}


