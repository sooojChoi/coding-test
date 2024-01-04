package baekjoon.Java.자료구조;

import java.io.*;
import java.util.*;


// 투 포인터
public class p1940 {
    public static void main(String[] args){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] arr;
        int start=0,end=1,count=0, sum=0;
        try{
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bf.readLine());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bf.readLine());
            arr = new int[N];

            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            while(start!=N-1){
                sum = arr[start]+arr[end];
                if(sum == M){
                    count++;
                    start++;
                    end=start+1;
                }else if(sum > M){
                     start++;
                     end=start+1;
                }else{
                    end++;
                    if(end==N){
                        start++;
                        end = start+1;
                    }
                }
                
            }


        }catch(Exception exception) {
        }

        System.out.println(count);
    }
}
