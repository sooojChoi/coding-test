package baekjoon.Java.동적계획법;

import java.util.*;

public class p11726 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[1]=1;
        if(n==1){
            System.out.println(1);
            sc.close();
            return;
        }
        dp[2]=2;
        
        for(int i=3;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%10007;
        }
        System.out.println(dp[n]);

        sc.close();

    }
}

/*  n=7이라면,
n=6인 경우에 가로 길이 1 짜리 막대를 붙이는 경우의 수와,
n=5인 경우에 가로 길이 2 짜리 막대를 붙이는 경우의 수를 더하면 된다 .

[주의할 점]
1. dp[n]은 직사각형 전체 가로 길이가 n일 때 구성 가능한 경우의 수를 10007로 나눈 나머지의 값이다.
따라서 점화식에서, n을 구성 가능한 경우의 수 % 10007을 한 값을 저장해주어야 한다.

2. n의 크기가 1일 때, dp[2]에 접근할 수 없다. 1인 경우를 따로 체크해주어야 한다. 

*/
