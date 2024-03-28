package baekjoon.Java.동적계획법;

import java.util.*;
import java.io.*;

public class p14501 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N;
        int[] dp;
        boolean[] visit;

        try{
            N = Integer.parseInt(br.readLine());
            Counsel[] counsels = new Counsel[N+1];
            dp = new int[N+1];
            visit = new boolean[N+1];

            int days;
            int price;
            for(int i=1;i<=N;i++){
                st = new StringTokenizer(br.readLine());
                days = Integer.parseInt(st.nextToken());
                price = Integer.parseInt(st.nextToken());
                counsels[i] = new Counsel(i, i+days-1, price);
            }

            for(int d=1;d<=N;d++){
                for(int check=1;check<=d;check++){
                    // 검사하기
                    if(visit[check]==false){
                        if(counsels[check].finish==d){
                            if(dp[d]==0){
                                dp[d] = Math.max(dp[d-1], counsels[check].price+dp[check-1]);
                            }else{
                                dp[d] = Math.max(dp[d], counsels[check].price+dp[check-1]);
                            }
                            
                            visit[check]=true;
                        }
                    }
                }

                // 내 dp가 업데이트 되지 않았다면, 
                if(dp[d]==0){
                    dp[d]=dp[d-1];
                }
            }

            System.out.println(dp[N]);
        }catch(Exception e){
        }
    }
}

class Counsel{
    int start;
    int finish;
    int price;

    Counsel(int start, int finish, int price){
        this.start = start;
        this.finish = finish;
        this.price = price;
    }
}
