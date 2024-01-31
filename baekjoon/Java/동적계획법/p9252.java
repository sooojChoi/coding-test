package baekjoon.Java.동적계획법;

import java.util.*;

public class p9252 {
    public static void main(String[] args){
        char[] a,b;
        int[][] dp;

        Scanner sc = new Scanner(System.in);
        a = sc.nextLine().toCharArray();
        b = sc.nextLine().toCharArray();

        dp = new int[a.length+1][b.length+1];

        if(a[1]==b[1]){
            dp[1][1]=1;
        }else{
            dp[1][1]=0;
        }
        

        for(int i=1;i<=a.length;i++){
            for(int j=1;j<=b.length;j++){
                if(a[i-1]==b[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int i = a.length;
        int j = b.length;
        int size = dp[a.length][b.length];

        while(sb.length()<size){
            if(a[i-1]==b[j-1]){
                sb.append(a[i-1]);
                i--;
                j--;
            }else{
                if(dp[i-1][j]>dp[i][j-1]){
                    i--;
                }else{
                    j--;
                }
            }
        }

        System.out.println(size+"\n"+sb.reverse());
        

    }
}
