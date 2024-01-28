package baekjoon.Java.정수론;

import java.util.*;
import java.io.*;

// 최소공배수. 
// 유클리드 호제법을 이용한다면, 두 수의 곱을 최대공약수로 나누면 최소공배수를 구할 수 있다.
public class p1934 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            int T = Integer.parseInt(br.readLine());
            int A, B;
            StringTokenizer st;
            for(int i=0;i<T;i++){
                st = new StringTokenizer(br.readLine());
                A = Integer.parseInt(st.nextToken());
                B = Integer.parseInt(st.nextToken());
                if(A>B){
                    int temp = A;
                    A = B;
                    B = temp;
                }
                int result = B;
                while(result%A!=0){
                    result=result+B;
                }

                System.out.println(result);
            }
        }catch(Exception e){
        }
    }
    

}
