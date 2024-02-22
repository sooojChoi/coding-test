package baekjoon.Java;

import java.io.*;
import java.util.*;

// 회의실 배정
public class p1931 {
    public static void main(String[] args){
        int N;
        Meeting[] arr;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            N = Integer.parseInt(br.readLine());
            arr = new Meeting[N];
            
            StringTokenizer st;
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                arr[i] = new Meeting(s, e);
            }

            // 끝나는 시간 기준으로 정렬
            Arrays.sort(arr);

            int end=arr[0].end;
            int result=1;
            for(int i=1;i<arr.length;i++){
                if(arr[i].start>=end){
                    result++;
                    end=arr[i].end;
                }
            }

            System.out.print(result);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

class Meeting implements Comparable<Meeting>{
    int start, end;

    Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o){
        // 끝나는 시간이 더 작은 것이 우선,
        // 끝나는 시간이 같다면 시작 시간이 더 작은 것이 우선.
        if(o.end<end){
            return 1;
        }else if(o.end==end){
            if(o.start<start){
                return 1;
            }else{
                return -1;
            }
        }else{
            return -1;
        }
    }
}