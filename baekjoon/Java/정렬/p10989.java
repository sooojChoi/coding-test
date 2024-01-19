package baekjoon.Java.정렬;

import java.io.*;

public class p10989{

    public static void main(String[] args){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        try{
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(br.readLine());
            }
            br.close();
            // 정렬할 배열과 최대 자릿수 넘겨주기
            radix_sort(arr, 5);
           // Arrays.sort(arr);

            StringBuilder sb =new StringBuilder();
            for(int value : arr) {
                sb.append(value).append('\n');
            }
            System.out.print(sb);

        }catch(Exception e){
            System.out.println(e);
        }
    }

    static void radix_sort(int[] arr, int max_count){

        int jarisu = 1;
        int count = 1;
        int[] output = new int[arr.length];

        while(count<=max_count){

            int[] bucket = new int[10];
            for(int i=0;i<arr.length;i++){
                bucket[(arr[i]/jarisu)%10]++;
            }
            for(int i=1;i<10;i++){
                bucket[i]+=bucket[i-1];
            }
            for(int i=arr.length-1;i>=0;i--){
                output[bucket[(arr[i]/jarisu%10)]-1] = arr[i];
                bucket[(arr[i]/jarisu)%10]--;
            }
            for(int i=0;i<arr.length;i++){
                arr[i] = output[i];
            }
            jarisu=jarisu*10;
            count++;
        }
    }

}