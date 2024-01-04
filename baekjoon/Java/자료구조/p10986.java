package baekjoon.Java.자료구조;

import java.util.*;

// 나머지 합 구하기
// 합 배열, 조합 이용
public class p10986 {
    public static void main(String[] args){
        long answer = 0L;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] S = new long[N];
        long[] C = new long[M];
         
         S[0] = sc.nextInt();
        //합 배열 구하기
        if(N>1){
            for(int i=1;i<N;i++){
                S[i] = S[i-1]+sc.nextInt();
            }
        }
    
        sc.close();

        for(int i=0;i<N;i++){
            int remainder = (int) S[i]%M;
            if(remainder==0) answer++; 
            C[remainder]++;
        }

        for(int i=0;i<M;i++){
            if(C[i]>1){
                answer += (long)(C[i]*(C[i]-1)/2);
            }
        }

        System.out.println(answer);

    }
}
