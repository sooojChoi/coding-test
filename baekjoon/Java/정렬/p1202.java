package baekjoon.Java.정렬;

import java.io.*;
import java.util.*;

public class p1202 {

    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, K;
        ArrayList<Jewel> jewel;
        ArrayList<Long> bag; 

        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            jewel = new ArrayList<>();
            bag = new ArrayList<>();

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                int m=Integer.parseInt(st.nextToken());
                int v=Integer.parseInt(st.nextToken());
                jewel.add(new Jewel(m, v));
            }
            for(int i = 0; i < K; i++){
                bag.add(Long.parseLong(br.readLine()));
            }

            Collections.sort(jewel);   // 무게 기준 오름차순 정렬
            Collections.sort(bag);  // 가방 오름차순 정렬
            // merge_sort(0, K-1);  // 가방 오름차순 정렬

            long result=0;
            // 가방에 넣을 수 있는 보석을 우선순위 큐에 모두 넣고
            // 하나 꺼내 정답에 더하기. 
            PriorityQueue<Jewel> q = new PriorityQueue<>((o1,o2)->{
                if(o1.price > o2.price){
                    return -1;
                }else{
                    return 1;
                }
            });
            int jewel_index=0;
            for(int i=0;i<K;i++){
                for(int j=jewel_index;j<jewel.size();j++){
                    if(jewel.get(j).weight<=bag.get(i)){
                        q.add(jewel.get(j));
                        jewel_index++;
                    }else{
                        break;
                    }
                }
                if(q.size()>0){
                    result += q.poll().price;
                }
            }


            System.out.println(result);


        }catch(Exception e){
            System.out.println(e);
        }
    }

}



class Jewel implements Comparable<Jewel>{
    int weight;
    int price;

    Jewel(int weight, int price){
        this.weight = weight;
        this.price = price;
    }

    @Override
    public int compareTo(Jewel o) {
        // 무게 기준 오름차순
        if(o.weight < weight){
            return 1;
        }else{
            return -1;
        }
    }
}


