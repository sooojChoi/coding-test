package baekjoon.Java.탐색;

import java.io.*;
import java.util.*;

public class p10815 {
    public static void main(String[] args){
        int N, M;
        int[] card;
        int[] checkList;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            card = new int[N];
            for(int i=0;i<N;i++){
                card[i] = Integer.parseInt(st.nextToken());
            }
            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            checkList = new int[M];
            for(int i=0;i<M;i++){
                checkList[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(card);
        
            for(int i=0;i<M;i++){
                int start=0;
                int end=N-1;
                int mid;
                int check=0;
                while(start<=end){
                    mid = (start+end)/2;
                    if(card[mid]==checkList[i]){
                        check=1;
                        break;
                    }else if(card[mid]>checkList[i]){
                        end=mid-1;
                    }else{
                        start=mid+1;
                    }
                }
                System.out.print(check+" ");
            }
        

        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
