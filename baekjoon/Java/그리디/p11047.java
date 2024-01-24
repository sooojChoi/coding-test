package baekjoon.Java.그리디;

import java.io.*;
import java.util.*;

// 그리디
public class p11047 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];

            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(br.readLine());
            }
            int count=0;
            for(int i=N-1;i>=0;i--){
                if(arr[i]<=K){
                    count+=K/arr[i];
                    K=K%arr[i];
                    if(K==0){
                        break;
                    }
                }
            }

            System.out.println(count);
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
