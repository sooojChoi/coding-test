package baekjoon.Java.자료구조;

import java.io.*;
import java.util.*;

public class p1253 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        int arr[];

        try{
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int result=0;
            int left=0, right=N-1;
            for(int i=0;i<N;i++){
                while(left<right){
                    // 검사할 인덱스와 같으면 비교하지 않고 넘어감.
                    if(left==i){
                        left++; continue;
                    }
                    if(right==i){
                        right--; continue;
                    }
                    // 검사할 값과 같으면 리턴
                    // 검사할 값보다 크면 수를 줄여야 하니까 right을 줄이고
                    // 검사할 값보다 작으면 수를 늘여야 하니까 left를 증가
                    int sum=arr[left]+arr[right];
                    if(sum==arr[i]){
                        result++;
                        break;
                    }else if(sum<arr[i]){
                        left++;
                    }else{
                        right--;
                    }        
                }
                left=0; right=N-1;
            }

            print(result);
        }catch(Exception e){
            print(e);
        }
    }

    static void print(Object obj){
        System.out.print(obj);
    }
    static void println(Object obj){
        System.out.println(obj);
    }
    
}
