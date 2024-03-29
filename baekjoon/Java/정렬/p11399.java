package baekjoon.Java.정렬;

import java.util.*;
import java.io.*;


// 버블, 선택, 삽입 정렬, 퀵 정렬
public class p11399 {
    public static void main(String[] main){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 오름차순 정렬
            //bubble_sort(arr);
            //select_sort(arr);
            //insert_sort(arr);
            quick_sort(arr, 0, n-1);

            int sum=arr[0];
            for(int i=0;i<n-1;i++){
                arr[i+1]=arr[i]+arr[i+1];
                sum+=arr[i+1];
            }

            System.out.println(sum);
    
        }catch(Exception e){
            System.out.println(e);  
        }
    }

    static int partition(int[] arr, int start, int end){
        int pivot = arr[start];
        int low = start;
        int high = end+1;
        int temp;

        do{
            do{
                low++;
            }while(arr[low]<pivot && low<end);

            do{
                high--;
            }while(arr[high]>pivot && high>start);

            // low와 high가 교차되지 않았으면 두 값을 교체한다.
            if(low<high){
                temp = arr[low];
                arr[low ] = arr[high];
                arr[high] = temp;
            }
        }while(low<high);

        // pivot과 high를 교환
        temp = arr[start];
        arr[start] = arr[high];
        arr[high] = temp;

        return high;
    }
    // 퀵 정렬
    static void quick_sort(int[] arr, int start, int end){
        if(start<end){
            int pivot = partition(arr, start, end);

            quick_sort(arr, start, pivot-1);
            quick_sort(arr, pivot+1, end);
        }

    }

    // 버블 정렬
    static void bubble_sort(int[] arr){
        int end_index = arr.length;
        while(end_index>0){
            for(int i=0;i<end_index-1;i++){
                if(arr[i+1]<arr[i]){
                    int temp = arr[i+1];
                    arr[i+1]=arr[i];
                    arr[i] = temp;
                }
            }
            end_index--;
        }
    }

    // 선택 정렬
    static void select_sort(int[] arr){
        int n = arr.length;
        int start_index=0;
        while(start_index < n){
            int min = arr[start_index];
            int min_index = start_index;

            for(int i=start_index;i<n;i++){
                if(arr[i]<min){
                    min = arr[i];
                    min_index = i;
                }
            }
            arr[min_index] = arr[start_index];
            arr[start_index] = min;
            start_index++;
        }
    }

    // 삽입 정렬
    static void insert_sort(int[] arr){
        int index=1;
        while(index<arr.length){
            int insert_index=index;
            int insert_value = arr[index];
            // 적절한 위치 탐색
            for(int i=0;i<index;i++){
                if(arr[i]>insert_value){
                    insert_index=i;
                    break;
                }
            }
            // index까지 shift하고 insert
            for(int i=index;i>insert_index;i--){
                arr[i]=arr[i-1];
            }
            arr[insert_index]=insert_value;
            index++;
        }
    }
}