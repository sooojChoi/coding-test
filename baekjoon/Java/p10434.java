package baekjoon.Java;

import java.util.*;
import java.io.*;

public class p10434 {
    public static void main(String[] args) {
        int P;
        String answer="NO";
        int[] M;
        int max=0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try{
            P = Integer.parseInt(br.readLine());

            // 행복 수 판정에 사용되는 배열
            boolean[] dp;
            boolean[] visit;
            // 소수 판정에 사용되는 배열
            boolean[] prime;
            // 입력받는 배열
            M = new int[P+1];

            // 입력받기
            for(int i=1;i<=P;i++){
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                M[i] = Integer.parseInt(st.nextToken());
                if(M[i]>max){
                    max = M[i];
                }
            }

            prime = new boolean[max+1];
            dp = new boolean[10000];
            
            setPrimeArray(prime);

            for(int i=1;i<=P;i++){
                visit = new boolean[10000];
                if(isHappyNumber(M[i], visit, dp)){
                    if(prime[M[i]]){
                        answer = "YES";
                    }
                }

                System.out.println(i+" "+M[i]+" "+answer);
                answer = "NO";
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

    // // 특정 수 n이 소수인지 아닌지 판별해준다.
    // static boolean isPrime(int n){
    //     if(n==1){
    //         return false;
    //     }
    //     if(n==2){
    //         return true;
    //     }

    //     int e = (int)Math.sqrt(n);

    //     // 2부터 n의 제곱근까지의 수 중,
    //     // 나누어 떨어지는 수가 있다면 약수가 존재하는 것이다. 
    //     for(int i=2;i<=e;i++){
    //         if(n%i==0){
    //             return false;
    //         }
    //     }

    //     return true;
    // }



    // 1부터 array.length-1까지의 수에 대해서,
    // array배열에 소수인지 아닌지 저장해준다. 
    // 에라토스테네스의 체 방식을 사용하였다. 
    // true이면 소수, false이면 소수가 아니다. 
    static void setPrimeArray(boolean[] array){
        if(array.length<0){
            return;
        }

        int i;
        // 모두 true로 초기화한다. 
        for(i=2;i<array.length;i++){
            array[i] = true;
        }

        i=2;
        for(i=2;i<Math.sqrt(array.length)+1;i++){
            // 만약 어떤 수가 소수이면,
            // 그 수의 배수들에 대해서 false 처리한다. 
            if(array[i]==true){
                for(int j=i+i;j<array.length;j+=i){
                    array[j]=false;
                }
            }
        }


    }
}
