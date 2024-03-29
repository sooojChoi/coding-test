package baekjoon.Java.자료구조;

import java.util.*;
import java.io.*;

public class p11286 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try{
            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
                int first_abs = Math.abs(o1);
                int second_abs = Math.abs(o2);
                if(first_abs == second_abs)
                    return o1>o2 ? 1 : -1;
                else
                    return first_abs - second_abs;
            });

            for(int i=0;i<N;i++){
                int request = Integer.parseInt(br.readLine());
                if(request == 0){
                    if(pq.isEmpty()){
                        System.out.println("0");
                    }else{
                        System.out.println(pq.poll());
                    }
                }else{
                    pq.add(request);
                }
            }
        }catch(Exception exception) {
        }

        

    }
    
}
