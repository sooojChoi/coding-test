package baekjoon.Java.정렬;

import java.io.*;
import java.util.*;

public class p1202 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, K;
        PriorityQueue<Jewel> jewel;  // 비싼 보석부터 뽑아내기 위해 우선순위 큐로 정의
        ArrayList<Long> bag; 

        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            jewel = new PriorityQueue<>((o1, o2)->{
                  // 비싼 순으로 뽑는다. 
                if(o1.price < o2.price){
                    return 1;
                }else{
                    return -1;
                }
            });
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

            Collections.sort(bag);  // 오름차순            

            long result=0;
            // 비싼 순으로 뽑으면서, 들어갈 수 있는 가방 중 제일 작은 가방에 넣기
            while(jewel.size()>0){ 
                int index;
                Jewel jw = jewel.poll();
                if(jw.weight>bag.get(bag.size()-1)){
                    index=-1;
                }else{
                    index=getBagIndex(bag, jw.weight);
                }
                
                if(index!=-1){
                    result+=jw.price;
                    bag.remove(index);
                }
                if(bag.size()==0){
                    break;
                }
            }            

            System.out.println(result);


        }catch(Exception e){
            System.out.println(e);
        }
    }

    // 들어갈 수 있는 가방 중 가장 작은 가방의 인덱스를 리턴
    // 들어갈 수 있는 가방이 없다면 -1 리턴
    // 가방 무게는 보석 무게보다 같거나 커야 한다. 
    static int getBagIndex(ArrayList<Long> bList, int j_weight){
        if(bList.size()==0){
            return -1;
        }
        int start=0;
        int end=bList.size()-1;
        int mid = (start+end)/2;
        while(start<=end){
            mid = (start+end)/2;

            if(bList.get(mid)==j_weight){
                // 가방 무게와 보석 무게가 같은 경우.
                // 들어갈 수 있는 가방 중 가장 작은 가방의 인덱스
                return mid;
            }else if(bList.get(mid)<j_weight){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        
        // mid가 보석 무게보다 적다면, 보석 무게보다 큰 가방을 찾아서 리턴
        // 보석 무게보다 큰 가방이 없다면 -1 리턴
        if(bList.get(mid)<j_weight){
            for(int i=mid+1;i<bList.size();i++){
                if(bList.get(i)>=j_weight){
                    return i;
                }
            }
            return -1;
        }
        // mid가 보석 무게보다 크다면, 보석 무게보다 큰 가방 중 더 작은 가방 찾기
        else{
            int r=mid;
            for(int i=mid-1;i>0;i--){
                if(bList.get(i)>=j_weight){
                    r=i;
                }else{
                    break;
                }
            }
            return r;
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
        // 비싼 순으로 뽑는다. 
        if(o.price < price){
            return -1;
        }else{
            return 1;
        }
    }
}


