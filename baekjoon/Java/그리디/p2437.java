package baekjoon.Java.그리디;

import java.io.*;
import java.util.*;

public class p2437 {
    static int N;
    static int[] weight;
    public static void main(String[] args){
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 1;

        try{
            N = Integer.parseInt(br.readLine());
            weight = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                weight[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(weight);

            HashSet<Long> set = new HashSet<>();
            HashSet<Long> tempList = new HashSet<>();
            for(int i=0;i<N;i++){
                if(weight[i]==answer){
                    answer++;
                }
                for(long s:set){
                    tempList.add(s+weight[i]);
                    if(s+weight[i]==answer){
                        answer++;
                    }
                } 
                for(long n:tempList){
                    set.add(n);
                }
                set.add((long)weight[i]);
                tempList.clear();
            }
            System.out.println(answer);
            


        }catch(Exception e){
            System.out.println(e);
        }
    }

    
}
