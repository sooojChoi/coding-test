package baekjoon.Java.정수론;

import java.util.*;

public class p1456 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
     

        try{

            long[] arr = new long[10000001];
            for(int i=2;i<arr.length;i++){
                arr[i] = i;
            }
            // 소수가 아닌 수는 모두 -1로 처리한다.
            // 10^7 의 제곱이 10^14이므로 소수 판별은 10^7까지만 하면 된다.
            // 10^7까지의 소수 판별은 10^7의 제곱근까지 for문을 수행하면 된다.
            for(int i=2;i<=Math.sqrt(arr.length);i++){
                if(arr[i]!=0){
                    for (int j = i + i; j < arr.length; j = j + i) { // 배수 지우기
                        arr[j] = 0;
                    }
                }
            
            }

            int count=0;
            for(int i=2;i<arr.length;i++){
                if(arr[i]!=0){
                    long temp = arr[i];
                    // 나눗셈을 수행하기 때문에 double형으로 꼭! 바꿔줘야 한다.
                    while((double)arr[i]<=(double)B/(double)temp){
                        if((double)arr[i]>=(double)A/(double)temp){
                            count++;
                        }
                        temp*=arr[i];
                    }
                }
            }
            
            System.out.println(count);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
