package baekjoon.Java.그리디;

import java.io.*;
import java.util.*;

public class p17150 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        try{
            N = Integer.parseInt(br.readLine());
            for(int i=0;i<N;i++){
                pq.add(Integer.parseInt(br.readLine()));
            }

            if(N==1){
                System.out.println(0);
                return;
            }


            int sum=0;
            ArrayList<Integer> list = new ArrayList<>();
            while(pq.size()>0){
                int num=pq.poll();
                list.add(num);
                if(list.size()==2){
                    int s = list.get(0)+list.get(1);
                    if(pq.size()!=0){
                        pq.add(s);
                        sum+=s;
                        list.clear();
                    }
                }
            }
            for(int i : list){
                sum+=i;
            }

            
            System.out.println(sum);


        }catch(Exception e){
        }
        
    }    
}
