package baekjoon.Java.동적계획법;

import java.io.*;
import java.util.*;

public class p2239 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, k, coin;
        int[] dp;
        StringTokenizer st;

        try{
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            dp = new int[k+1];

            for(int i=0;i<n;i++){
                coin = Integer.parseInt(br.readLine());
                if(coin<=k){
                    int[] temp = dp.clone();
                    for(int j=0;j<=k-coin;j++){
                        dp[j+coin]++;
                        if((j+coin)%coin == 0 && (j+coin)/coin!=1){
                         
                            if(temp[k-(j+coin)]!=0){
                                dp[k]+=temp[k-(j+coin)];
                            }
                        }
                    }
                }
            }
            
            System.out.println(dp[k]);


        }catch(Exception e){
            System.out.println(e);
        }

    }
}
