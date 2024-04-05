package baekjoon.Java.동적계획법;
import java.io.*;
import java.util.*;

public class p13398 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int[] input;
        // dp[n]은 0부터 n까지에서 n을 포함한 수열 중 최댓값
        int[] dp;

        try{
            n = Integer.parseInt(br.readLine());
            input = new int[n];
            dp = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i=0;i<n;i++){
                input[i] = Integer.parseInt(st.nextToken());
            }
            dp[0] = input[0];

            int max=dp[0];
            int max_index=0;
            for(int i=1;i<n;i++){
                int value = input[i];
                dp[i] = Math.max(value, dp[i-1]+value);
                if(dp[i]>max){
                    max = dp[i];
                    max_index=i;
                }
            }

            int[] temp = new int[n];
            for(int i=1;i<n;i++){
                // 모든 음수 input 값에 대해, 
                // 그 음수를 제거할 경우의 최댓값을 구한다. 
                if(input[i]<0 && dp[i]<0){
                    if(max_index>i && max_index<n){
                        max = Math.max(max, dp[max_index]+dp[i-1]);
                    }else{
                        temp[i] = dp[i-1];
                        for(int j=i+1;j<n;j++){
                            int value = input[j];
                            if(value<0){
                                break;
                            }
                            temp[j] = Math.max(value, temp[j-1]+value);
                            if(temp[j]>max){
                                max = temp[j];
                                max_index=j;
                            }
                        }
                    }
                }else if(input[i]<0 && dp[i]>=0){
                    if(max_index>i && max_index<n){
                        // 음수 값 만큼 더해준다. 
                        max = Math.max(max, dp[max_index]+input[i]*-1);
                    }else{
                        temp[i] = dp[i-1];
                        for(int j=i+1;j<n;j++){
                            int value = input[j];
                            if(value<0){
                                break;
                            }
                            temp[j] = Math.max(value, temp[j-1]+value);
                            if(temp[j]>max){
                                max = temp[j];
                                max_index=j;
                            }
                        }
                    }
                }


                

            }

            System.out.println(max);

        }catch(Exception e){
            System.out.println(e);
        }

      
    }
}
