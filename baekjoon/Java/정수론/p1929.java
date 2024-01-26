package baekjoon.Java.정수론;

import java.io.*;
import java.util.*;

public class p1929 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, M;

        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            int[] arr = new int[N+1];
            for(int i=1;i<N+1;i++){
                arr[i] = i;
            }

            arr[1]=-1;
            for(int i=2;i<N+1;i++){
                int n = arr[i];
                if(n!=-1){
                    int j=2;
                    while(j*n<N+1){
                        arr[j*n]=-1;
                        j++;
                    }
                }
            }
            for(int i=M;i<N+1;i++){
                if(arr[i]!=-1){
                    System.out.println(arr[i]);
                }
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
