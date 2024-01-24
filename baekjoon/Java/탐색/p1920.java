package baekjoon.Java.탐색;

import java.io.*;
import java.util.*;

// 이진 탐색
public class p1920 {
    static int[] arr;
    public static void main(String[] args){
        int N, M;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<M;i++){
                binarySearch(Integer.parseInt(st.nextToken()));
            }
        }catch(Exception e){
            System.out.println(e);
        }

    }

    static void binarySearch(int n){
        int start = 0;
        int end = arr.length-1;
        int mid = (start+end)/2;
        int mid_v = arr[mid];
        int result=0;

        while(start<=end){
            mid = (start+end)/2;
            mid_v = arr[mid];
            if(mid_v<n){
                start=mid+1;
            }else if(mid_v>n){
                end=mid-1;
            }else{
                result=1;
                break;
            }
        }
        System.out.println(result);
    }
}
