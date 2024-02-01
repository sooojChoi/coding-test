package baekjoon.Java.정렬;

import java.io.*;

// 버블 정렬(O(n^2))

// 삽입 정렬, 퀵 정렬, 병합 정렬로 정렬해보자. 
public class p2750 {
    static int[] arr;
    static int[] sorted;
    public static void main(String[] args){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N;

        try{
            N = Integer.parseInt(bf.readLine());
            arr = new int[N];
            sorted = new int[N];
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(bf.readLine());
            }

            //bubble();
            //quick_sort(0, N-1);
            merge_sort(0, N-1);

            for(int i=0;i<N;i++){
                System.out.println(arr[i]);
            }
           
        }catch(Exception e){
            System.out.println(e);
        }
    }

    static void merge(int s, int mid, int e){
        int first = s;
        int second = mid+1;
        int new_index = s;

        while(first<=mid && second<=e){
            if(arr[first]>arr[second]){
                sorted[new_index++] = arr[second++];
            }else{
                sorted[new_index++] = arr[first++];
            }
        }
        if(first<=mid){
            for(int i=first;i<=mid;i++){
                sorted[new_index++] = arr[i];
            }
        }
        if(second<=e){
            for(int i=second;i<=e;i++){
                sorted[new_index++] = arr[i];
            }
        }

        for(int i=s;i<=e;i++){
            arr[i] = sorted[i];
        }
    }
    
    static void merge_sort(int s, int e){
        if(s<e){
            int mid = (s+e)/2;
            merge_sort(s, mid);
            merge_sort(mid+1, e);
            merge(s, mid, e);
        }
    }

    public static int partition(int s, int e){
        int low = s;
        int high = e+1;
        int pivot = arr[s];

        do{
            do{
                low++;
            }while(arr[low]<pivot && low<e);

            do{
                high--;
            }while(arr[high]>pivot && high>s);
            
            if(low<high){
                swap(low, high);
            }
        }while(low<high);

        arr[s]=arr[high];
        arr[high]=pivot;
        return high;
    }
    public static void swap(int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;        
    }

    public static void quick_sort(int s, int e){
        if(s<e){
            int pivot = partition(s, e);
            quick_sort(s, pivot-1);
            quick_sort(pivot+1, e);
        }
    }

    public static void bubble(){
        int end=arr.length-1;
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
    }
}
