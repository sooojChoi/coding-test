package baekjoon.Java.정수론;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p21568 {
    static int x=1, y=0;

    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int A, B, C;

        try{
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            
            // Ax + By = C
            //x, y를 공백으로 구분해 출력하고 해가 없을 경우 -1 출력
            int gcd = gcd(A, B);
            if(C%gcd != 0){
                System.out.println("-1");
                return;
            }

            int k = C/gcd;
            System.out.print(x*k+" "+y*k);

        }catch(Exception e){
            System.out.println(e);
        }
    }


    public static int gcd(int a, int b){
        if(b==0){
            return a;
        }else{
            int result = gcd(b,a%b);
            int temp_x=x;
            x = y;
            y = temp_x - y*(a/b);
            return result;
        }
    }
    
}
