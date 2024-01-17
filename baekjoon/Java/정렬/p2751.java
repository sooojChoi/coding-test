package baekjoon.Java.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 병합 정렬
public class p2751 {
    public static void main(String[] args){
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          int N;
          int[] arr;

          try{
            N = Integer.parseInt(br.readLine());
            arr = new int[N];

            for(int i=0;i<N;i++){
              arr[i] = Integer.parseInt(br.readLine());
            }
            merge_sort(arr, 0, N-1);
            
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for(int i=0;i<N;i++){
                bw.write(arr[i]+"\n");
            }
            bw.flush();
            bw.close();
          }catch(Exception e){
            System.out.println(e);
          }
    }

    static void merge(int[] arr, int start, int mid, int end){
        int first = start;
        int second = mid+1;
        int new_index = start;
        int[] sorted = new int[arr.length];

        while(first<=mid &&second<=end){
            if(arr[first]<arr[second]){
                sorted[new_index++] = arr[first++];
            }else{
                sorted[new_index++] = arr[second++];
            }
        }

        if(first<=mid){
            for(int i=first;i<=mid;i++){
                sorted[new_index++] = arr[i];
            }
        }else{
            for(int i=second;i<=end;i++){
                sorted[new_index++] = arr[i];
            }
        }

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
}
