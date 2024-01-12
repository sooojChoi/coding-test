package baekjoon.Java.정렬;

import java.util.*;
import java.io.*;

// 선택정렬
public class p1427 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            String n = br.readLine();
            int[] arr = new int[n.length()];
            for(int i=0;i<n.length();i++){
                arr[i] = Integer.parseInt(n.substring(i, i+1));
            }

            int start_index=0;
            while(start_index<n.length()){
                int max = arr[start_index];
                int max_index = start_index;
                // 최솟값 구하기
                for(int i=start_index;i<n.length();i++){
                    if(arr[i]>max){
                        max = arr[i];
                        max_index = i;
                    }
                }
                arr[max_index] = arr[start_index];
                arr[start_index] = max;
                start_index++;
            }

            for(int i=0;i<n.length();i++){
                System.out.print(arr[i]);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
