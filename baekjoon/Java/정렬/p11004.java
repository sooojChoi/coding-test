package baekjoon.Java.정렬;

import java.io.*;
import java.util.*;

// 퀵 정렬 (시간 초과됨.ㄴ 다시 해보기.)
public class p11004 {
    static int K;
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        int[] arr;

        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken())-1;
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            quick_sort(arr, 0, N-1);

            System.out.println(arr[K]);

        }catch(Exception e){
            System.out.println(e);
        }
    }

    static int partition(int[] arr, int start, int end){
       // int pivot = arr[start];
        int mid = (start+end)/2;
        int pivot = arr[mid];
        arr[mid] = arr[start];
        arr[start] = pivot;
        
        int low = start+1;
        int high = end;
        int temp;

        while(low<high){
            while(arr[low]<pivot && low<end){
                low++;
            }
            while(arr[high]>pivot && high>start){
                high--;
            }
            if(low<high){
                temp = arr[high];
                arr[high] = arr[low];
                arr[low] = temp;
            }
        }
        
        temp = arr[start];
        arr[start] = arr[high];
        arr[high] = temp;

        return high;
    }

    static void quick_sort(int[] arr, int start, int end){
        if(start<end){
            int pivot = partition(arr, start, end);
            
            if(pivot==K){
                return;
            }else if(pivot<K){
                quick_sort(arr, pivot+1, end);
            }else{
                quick_sort(arr, start, pivot-1);
            }
            // quick_sort(arr, start, pivot-1);
            // quick_sort(arr, pivot+1, end);
        }
    }
    
}
