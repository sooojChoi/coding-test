package baekjoon.Java.동적계획법;

import java.io.*;
import java.util.StringTokenizer;

public class p12865 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N, K;
        int[][] info;
        int[][] dp;
        int answer=0;

        try{
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            info = new int[N][2];
            dp = new int[N][2];

            int w, v;
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                w = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                info[i][0]=w;
                info[i][1]=v;
            }

            if(info[0][0] <= K){
                dp[0][0] = info[0][0];
                dp[0][1] = info[0][1];
            }
        

            for(int i=1;i<N;i++){
                for(int j=0;j<i;j++){
                    // 무게가 K보다 작을 때
                    if(dp[j][0] + info[i][0] <= K){
                        // 다른 물건과 챙겼을 때의 값보다 더 값이 높을 때
                        if(dp[i][1] < dp[j][1]+info[i][1]){
                            dp[i][0]=dp[j][0]+info[i][0];
                            dp[i][1]=dp[j][1]+info[i][1];
                        }
                    }else{
                        if(dp[i][0]<=K){
                            if(info[i][0]+info[j][0] <= K){
                                if(dp[i][1] < info[i][1]+info[j][1]){
                                    dp[i][0] = info[i][0]+info[j][0];
                                    dp[i][1] = info[i][1]+info[j][1];
                                }
                            }else{
                                dp[i][0] = info[i][0];
                                dp[i][1] = info[i][1];
                            }
                            
                        }
                    }
                }
                if(dp[i][1]>answer){
                    answer = dp[i][1];
                }

            }
            
            System.out.println(answer);
        }catch(Exception e){
            System.out.println(e);
        }

    }
    
}
