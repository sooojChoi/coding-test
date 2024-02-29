package baekjoon.Java.그리디;

import java.io.*;
import java.util.*;

public class p1744 {
    public static void main(String[] args){
        int N;
        PriorityQueue<Integer> minusQ = new PriorityQueue<>();
        PriorityQueue<Integer> plusQ = new PriorityQueue<>(Collections.reverseOrder());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result=0;

        try{
            N = Integer.parseInt(br.readLine());
            int n;
            for(int i=0;i<N;i++){
                n = Integer.parseInt(br.readLine());
                if(n<=0){
                    minusQ.add(n);
                }else{
                    plusQ.add(n);
                }
            }

            // 묶을 수가 있을 때, 두 수를 꺼내어 묶는다.
            int a, b;
            while(minusQ.size()>=2){
                a = minusQ.poll();
                b = minusQ.poll();

                result+=(a*b);
            }
            while(minusQ.size()>0){
                result+=minusQ.poll();
            }

            while(plusQ.size()>=2){
                a = plusQ.poll();
                b = plusQ.poll();

                // 둘 중에 하나라도 1이라면 곱하지 않기.
                if(a==1 || b==1){
                    result+=a;
                    result+=b;
                    break;
                }

                result+=(a*b);
            }
            while(plusQ.size()>0){
                result+=plusQ.poll();
            }

            System.out.println(result);

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
