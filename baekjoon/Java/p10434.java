package baekjoon.Java;

import java.util.*;
import java.io.*;

public class p10434 {
    public static void main(String[] args) {
        int P;
        int M;
        String answer;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try{
            P = Integer.parseInt(br.readLine());

            boolean[] dp = new boolean[9999];
            boolean[] visit = new boolean[9999];

            for(int i=1;i<=P;i++){
                st = new StringTokenizer(br.readLine());
                int test_case = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());

                answer = "NO";

                if(isHappyNumber(M, visit, dp)){
                    if(isPrime(M)){
                        answer = "YES";
                    }
                }
                
                System.out.println(test_case+" "+M+" "+answer);

            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    // 행복수인지 아닌지 판별한다.
    static boolean isHappyNumber(int n, boolean[] visit, boolean[] dp){
        // 방문 체크한다. 
        visit[n]=true;

        if(n==1){
            return dp[1]=true;
        }

        int sum = getSum(n);

        if(sum==1){
            return dp[n]=true;
        }else if(visit[sum]){
            return dp[n] = dp[sum];
        }else{
            return dp[n] = isHappyNumber(sum, visit, dp);
        }

    }

    static int getSum(int n){
        int sum=0;
        while(n>0){
            int temp = n%10;
            sum += temp*temp;
            n/=10;
        }
        return sum;
    }

    // 특정 수 n이 소수인지 아닌지 판별해준다.
    static boolean isPrime(long n){
        if(n==1){
            return false;
        }
        if(n==2){
            return true;
        }

        long e = (long)Math.sqrt(n)+1;

        // 2부터 n의 제곱근까지의 수 중,
        // 나누어 떨어지는 수가 있다면 약수가 존재하는 것이다. 
        for(long i=2;i<=e;i++){
            if(n%i==0){
                return false;
            }
        }

        return true;
    }



    // // 1부터 array.length-1까지의 수에 대해서,
    // // array배열에 소수인지 아닌지 저장해준다. 
    // // 에라토스테네스의 체 방식을 사용하였다. 
    // // true이면 소수, false이면 소수가 아니다. 
    // static void setPrimeArray(boolean[] array){
    //     if(array.length<0){
    //         return;
    //     }

    //     int i;
    //     // 모두 true로 초기화한다. 
    //     for(i=1;i<array.length;i++){
    //         array[i] = true;
    //     }

    //     i=2;
    //     for(i=2;i<Math.sqrt(array.length)+1;i++){
    //         // 만약 어떤 수가 소수이면,
    //         // 그 수의 배수들에 대해서 false 처리한다. 
    //         if(array[i]==true){
    //             for(int j=i+i;j<array.length;j+=i){
    //                 array[j]=false;
    //             }
    //         }
    //     }


    // }
}
