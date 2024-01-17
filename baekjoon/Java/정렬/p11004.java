package baekjoon.Java.정렬;

import java.io.*;
import java.util.*;

// 퀵 정렬(시간 초과), 병합 정렬 
public class p11004 {
    static int K;
    static int[] sorted;
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        int[] arr;

        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken())-1;
            arr = new int[N];
            sorted = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

          //  quick_sort(arr, 0, N-1);  // 시간초과 뜸. 
           // Arrays.sort(arr);
            merge_sort(arr, 0, N-1);

            System.out.println(arr[K]);

        }catch(Exception e){
            System.out.println(e);
        }
    }

    static void merge(int[] arr, int start, int mid, int end){
        int first = start;  // 첫 번째 그룹의 인덱스
        int second = mid+1;  // 두 번째 그룹의 인덱스
        int new_index = start;  // 새로운 그룹의 인덱스
       // int[] sorted = new int[arr.length];  // 새로운 그룹을 위한 배열 할당

        while(first<=mid && second<=end){
            if(arr[first] < arr[second]){
                sorted[new_index++] = arr[first++];
            }else{
                sorted[new_index++] = arr[second++];
            }
        }

        // 남은 값들 넣기
        if(first<=mid){
            // 첫 번째 그룹에 남은 값이 있는 경우
            for(int i=first;i<=mid;i++){
                sorted[new_index++] = arr[i];
            }
        }else{
            // 두 번째 그룹에 남은 값이 있는 경우
            for(int i=second;i<=end;i++){
                sorted[new_index++] = arr[i];
            }
        }

        // 정렬된 값을 원래 배열로 복사
        for(int i=start;i<=end;i++){
            arr[i] = sorted[i];
        }

    }

    static void merge_sort(int[] arr, int start, int end){
        if(start<end){
            int mid = (start+end)/2;
            merge_sort(arr, start, mid);
            merge_sort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }


    static int partition(int[] arr, int start, int end){
        if(start+1==end){
            if(arr[start]>arr[end]){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end]=temp;
                return end;
            }
        }

       // int pivot = arr[start];
        int mid = (start+end)/2;
        int pivot = arr[mid];
        arr[mid] = arr[start];
        arr[start] = pivot;
        
        int low = start+1;
        int high = end;
        int temp;

        while(low<=high){
            while(arr[low]<pivot && low<=end){
                low++;
            }
            while(arr[high]>pivot && high>start){
                high--;
            }
            if(low<high){
                temp = arr[high];
                arr[high] = arr[low];
                arr[low] = temp;
                low++;
                high--;
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
