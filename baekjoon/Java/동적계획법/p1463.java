package baekjoon.Java.동적계획법;

import java.util.*;

// dp
public class p1463 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        int[] dp = new int[N+1];

        if(N==1){
            System.out.println(0);
            return;
        }else if(N==2 || N==3){
            System.out.println(1);
            return;
        }
        dp[1]=0;
        dp[2]=1;  // 2/2
        dp[3]=1;  // 3/3

        int sec, thr, minus, min;
        for(int i=4;i<=N;i++){
            sec=i/2;
            thr=i/3;
            minus=i-1;

            if(i%3==0 && i%2==0){
                min = Math.min(dp[sec], dp[thr]);
                min = Math.min(min, dp[minus]);
            }else if(i%3==0){
                min = Math.min(dp[thr], dp[minus]);
            }else if(i%2==0){
                min = Math.min(dp[sec], dp[minus]);
            }else{
                min = dp[minus];
            }
            dp[i] = min+1;
        }

        System.out.println(dp[N]);

    }
}
