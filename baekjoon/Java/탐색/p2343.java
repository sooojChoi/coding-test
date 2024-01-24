package baekjoon.Java.탐색;

import java.io.*;
import java.util.*;


public class p2343 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M;
        int[] arr;
        int sum=0, max=0;

        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
                sum+=arr[i];
                if(max<arr[i]){
                    max = arr[i];
                }
            }

            // 블루레이의 크기가 될 수 있는 값은 max ~ 모든 레슨의 합
            int start = max;
            int end = sum;
            int count=0;
            while(start<=end){
                int mid = (start+end)/2;
                // mid가 가능한 블루레이 크기인지 검사
                int s=0;
                for(int i=0;i<N;i++){
                    if(s+arr[i]>mid){
                        count++;
                        s=0;
                    }
                    s += arr[i];
                }
                if(s!=0){
                    count++;
                }
                if(count>M){
                    start=mid+1;
                }else{
                    end = mid-1;
                }
                count=0;
            }

            System.out.println(start);

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
