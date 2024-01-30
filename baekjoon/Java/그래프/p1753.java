package baekjoon.Java.그래프;

import java.util.*;
import java.io.*;

// 다익스트라
public class p1753 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V, E, K;
        ArrayList<Edge>[] arr;
        int[] distance;
        boolean[] visited;

        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(br.readLine());
            arr = new ArrayList[V+1];
            distance = new int[V+1];
            visited = new boolean[V+1];

            for(int i=1;i<=V;i++){
                arr[i] = new ArrayList<>();
                distance[i] = Integer.MAX_VALUE;
            }

            for(int i=0;i<E;i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                arr[s].add(new Edge(e,w));
            }

            PriorityQueue<Edge> q = new PriorityQueue<Edge>();
            q.add(new Edge(K,0));
            distance[K]=0;

            // q가 비어있지 않을 때까지
            while(!q.isEmpty()){
                Edge edge = q.poll();  // 가장 작은 distance를 가진 노드 선택.
                if(visited[edge.node]){
                    // 이미 방문한 노드라면 계산하지 않음.
                    continue;
                }
                visited[edge.node] = true;

                // 해당 노드에 연결된 노드들을 방문하면서 거리 탐색
                for(Edge e:arr[edge.node]){ 
                    if(distance[e.node] > distance[edge.node]+e.weight){
                        distance[e.node] = distance[edge.node]+e.weight;
                        q.add(new Edge(e.node, distance[e.node]));
                    }
                }
            }

            for(int i=1;i<=V;i++){
                if(visited[i]){
                    System.out.println(distance[i]);
                }else{
                    System.out.println("INF");
                }
            }



        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}

class Edge implements Comparable<Edge>{
    int node;
    int weight;

    Edge(int node, int weight){
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        if(this.weight - o.weight <0){
            return -1;
        }else{
            return 1;
        }
    }
}
