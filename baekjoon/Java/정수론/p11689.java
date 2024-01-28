package baekjoon.Java.정수론;

import java.util.*;

// 오일러 피 (P[i] = P[i]-P[i]/K)
// 해당 문제에서 데이터 최대 크기가 10^12이기 때문에 long으로 받아서 처리해야 됨
// 아직 해결 못함
public class p11689 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] P = new int[N+1];
    
        for(int i=1;i<=N;i++){
            P[i] = i;
        }

        for(int i=2;i<=N;i++){
            if(P[i]==i){
                for(int j=i; j<=N;j+=i){
                    P[j] = P[j] - P[j]/i;
                }
            }
        }
        
        sc.close();

        System.out.println(P[N]);
    }
    
}
