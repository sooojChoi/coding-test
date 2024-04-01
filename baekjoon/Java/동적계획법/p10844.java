package baekjoon.Java.동적계획법;

import java.util.*;

public class p10844 {
    public static void main(String[] args){
        int[][] dp;
        int n;
        final int divide = 1000000000;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        // dp[3][0]은 3번째 자리수에 0이 올 수 있는 경우의 수
        // 즉 n이 3일 때 답은 dp[3][0]+dp[3][1]+...+dp[3][9]
        dp = new int[n+1][10];  
        dp[1][0] = 0;
        for(int i=1;i<=9;i++){
            dp[1][i]=1;
        }

        if(n==1){
            System.out.println(9);
            sc.close();
            return;
        }

        long sum=0;
        for(int i=2;i<=n;i++){
            for(int j=0;j<=9;j++){
                if(j==0){
                    dp[i][j]=dp[i-1][1]%divide;
                }else if(j==9){
                    dp[i][j]=dp[i-1][8]%divide;
                }else{
                    dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%divide;
                }
                if(i==n){
                    sum+=dp[i][j];
                }
            }
            
        }

        System.out.println(sum%divide);

        


        sc.close();

    }
}
