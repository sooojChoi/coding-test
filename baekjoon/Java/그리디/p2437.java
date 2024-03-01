package baekjoon.Java.그리디;

import java.io.*;
import java.util.*;


public class p2437 {
    public static void main(String[] args){
        int N;
        int[] weight;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            N = Integer.parseInt(br.readLine());
            weight = new int[N];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                weight[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(weight);

            long sum=weight[0];
            if(sum>1){
                System.out.println("1");
                return;
            }
            for(int i=1;i<N;i++){
                if(sum+1<weight[i]){
                    break;
                }else{
                    sum+=weight[i];                    
                }
            }


            System.out.println(sum+1);

        }catch(Exception e){
            System.out.println(e);
        }
    }

}
