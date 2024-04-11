package baekjoon.Java.동적계획법;
import java.io.*;
import java.util.*;

public class p1915 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        int[][] input;
        int[][] dp;  // 0,0부터 자신을 포함한 전체 사각형 중, 가장 큰 정사각형의 한 변 길이
        int max_length=0;
        
        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            input = new int[n][m];
            dp = new int[n][m];

            for(int i=0;i<n;i++){
                char[] temp = br.readLine().toCharArray();
                for(int j=0;j<m;j++){
                    input[i][j] = temp[j]-'0';
                    if(i==0 || j==0){
                        dp[i][j] = input[i][j];
                        if(dp[i][j]==1){
                            max_length=1;
                        }
                    }
                }
            }

            // dp 배열 구하기.
            for(int i=1;i<n;i++){
                for(int j=1;j<m;j++){
                    // 기본값이 0인 경우
                    if(input[i][j]==0){
                        // 자신을 포함한 정사각형은 만들어질 수 없다. 
                        dp[i][j]=0;
                    }
                    // 기본값이 1인 경우
                    else{
                        // 왼쪽, 위쪽, 상단좌측이 모두 0이 아닌 경우
                        if(dp[i-1][j]!=0 && dp[i][j-1]!=0 && dp[i-1][j-1]!=0){
                            // 세 값이 모두 같은 경우, 더 큰 정사각형 생성 가능. 
                            if(dp[i-1][j]==dp[i][j-1] && dp[i][j-1]==dp[i-1][j-1]){
                                dp[i][j] = dp[i-1][j-1]+1;
                            }
                            // 하나라도 값이 다른 경우 '가장 작은 값'+1
                            else{
                                int min = Math.min(dp[i-1][j], dp[i][j-1]);
                                min = Math.min(min, dp[i-1][j-1]);
                                dp[i][j] = min +1;
                            }
                        }
                        // 하나라도 0인 값이 있는 경우
                        // 자신을 포함한 정사각형의 최대 크기는 1밖에 될 수 없다. 
                        else{
                            dp[i][j]=1;
                        } 
                        // 최댓값 업데이트   
                        max_length = Math.max(max_length, dp[i][j]);
                    }
                }
            }

            int answer = max_length*max_length;

            System.out.println(answer);

        }catch(Exception e){
            System.out.println(e);
        }

    }
}
