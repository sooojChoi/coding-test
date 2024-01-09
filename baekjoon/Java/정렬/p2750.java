package baekjoon.Java.정렬;


import java.util.*;
import java.io.*;

// 버블 정렬(O(n^2))
public class p2750 {
    public static void main(String[] args){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] arr;

        try{
            int N = Integer.parseInt(bf.readLine());
            arr = new int[N];
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(bf.readLine());
            }

            int end=N-1;
            while(end!=0){
                for(int i=0;i<end;i++){
                
                    if(arr[i] > arr[i+1]){
                         int temp = arr[i];
                        arr[i] = arr[i+1];
                        arr[i+1] = temp;
                    }
                }
                end--;
            }

            
            for(int i=0;i<N;i++){
                System.out.println(arr[i]);
            }
           
        }catch(Exception e){
        }
        



    }
}
