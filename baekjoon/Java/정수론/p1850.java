package baekjoon.Java.정수론;

import java.util.*;

// 유클리드 호제법 (gcd. 최대공약수 구하기)
public class p1850 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            long a = sc.nextLong();
            long b = sc.nextLong();
            
            if(a>b){
                long temp=a;
                a=b;
                b=temp;
            }

            long big = b;
            long small = a;
            while(b%small!=0){
                b = small;
                small = big%small;
                big = b;
            }
            
            StringBuilder sb = new StringBuilder();
            for(long i=0;i<small;i++){
                sb.append("1");
            }

            System.out.println(sb);
            sc.close();
            
            
        }catch(Exception e){
        }
    }

}
