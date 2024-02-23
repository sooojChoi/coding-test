package baekjoon.Java.정렬;

import java.io.*;
import java.util.*;

public class p2470 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        Number[] arr;

        try{
            N = Integer.parseInt(br.readLine());
            arr = new Number[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                arr[i] = new Number(Integer.parseInt(st.nextToken()));
            }

            Arrays.sort(arr);
            int min=Integer.MAX_VALUE;
            int a=0, b=0;
            for(int i=0;i<N-1;i++){
                int sum = Math.abs(arr[i].value+arr[i+1].value);
                if(sum==0){
                    if(arr[i].value<arr[i+1].value){
                        System.out.println(arr[i].value+" "+arr[i+1].value);
                    }else{
                        System.out.println(arr[i+1].value+" "+arr[i].value);
                    }
                    return;
                }
                if(sum<min){
                    min=sum;
                    if(arr[i].value<arr[i+1].value){
                        a=arr[i].value;
                        b=arr[i+1].value;
                    }else{
                        a=arr[i+1].value;
                        b=arr[i].value;
                    }
                }
            }

            System.out.println(a+" "+b);
        }catch(Exception e){

        }
    }
}

class Number implements Comparable<Number>{
    int value;

    Number(int value){
        this.value = value;
    }

    @Override
    public int compareTo(Number o){
        // 절댓값 기준으로 오름차순 정렬
        if(Math.abs(o.value)>Math.abs(value)){
            return -1;
        }else{
            return 1;
        }
    }
}
