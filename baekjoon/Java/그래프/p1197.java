package baekjoon.Java.그래프;

import java.util.*;
import java.io.*;

// 최소 신장 트리 (모든 정점들을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리)
public class p1197 {
    static int[] leader;
    public static void main(String[] args){
        int V, E;  // 정점, 간선
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Edge_1197> list = new PriorityQueue<>();  // 에지 정보를 저장하는 에지리스트
          // union find 알고리즘에 사용되는 대표 노드 배열
        ArrayList<Edge_1197> result = new ArrayList<>(); // 구현된 에지를 저장하는 리스트

        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            leader = new int[V+1];

            for(int i=1;i<=V;i++){
                leader[i]=i;
            }
           
            for(int i=1;i<=E;i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                list.add(new Edge_1197(s, e, w));
            }

            int a, b;
            while(result.size()!=(V-1)){
                Edge_1197 e = list.poll();
                a = find(e.s_node);
                b = find(e.e_node);
                if(a!=b){
                    union(e.s_node, e.e_node);
                    result.add(e);
                }
            }

            int result_weight=0;
            for(Edge_1197 e:result){
                result_weight += e.weight;
            }

            System.out.println(result_weight);

        }catch(Exception e){
        }

    }

    static public void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            leader[a] = b;
        }
    }
    static public int find(int n){
        if(leader[n]==n){
            return n;
        }else{
            return leader[n] = find(leader[n]);
        }
    }


}

class Edge_1197 implements Comparable<Edge_1197>{
    int s_node;
    int e_node;
    int weight;

    Edge_1197(int s_node, int e_node, int weight){
        this.s_node = s_node;
        this.e_node = e_node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge_1197 e){
        if(this.weight > e.weight){
            return 1;
        }else{
            return -1;
        }
    }
}
