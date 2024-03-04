package programmers.Java;

import java.util.*;

// 프로그래머스 '가장 먼 노드' 문제
// 다익스트라 최단거리구하기 알고리즘 활용
public class graphFurthestNode {
    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] graph = new int[][]{
            {3,6},
            {4,3},
            {3,2},
            {1,3},
            {1,2},
            {2,4},
            {5,2}
        };

        int answer = sol.solution(6, graph);
        System.out.println(answer);
    }
}

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] distance = new int[n+1];  // 1번 노드로부터의 거리
        boolean[] visited = new boolean[n+1];  // 방문 여부 저장
        ArrayList<Edge>[] edgeList = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            distance[i] = Integer.MAX_VALUE;
            edgeList[i] = new ArrayList<>();
        }
        
        for(int i=0;i<edge.length;i++){
            edgeList[edge[i][0]].add(new Edge(edge[i][1], 1));
            edgeList[edge[i][1]].add(new Edge(edge[i][0], 1));
        }

        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(1, 0));
        distance[1] = 0;

        int max=0;
        while(!q.isEmpty()){
            Edge e = q.poll();  // 현재 가장 적은 거리를 가진 노드 꺼낸다. 

            if(visited[e.node]){
                continue;
            }
            visited[e.node] = true;

            // 현재 노드와 연결된 모든 노드를 방문하며 거리 업데이트
            for(Edge nextEdge: edgeList[e.node]){
                // 원래 거리보다 지금 노드를 거쳐가는 거리가 더 짧다면
                // 지금 노드를 거쳐가는 것으로 업데이트
                if(distance[nextEdge.node] > distance[e.node]+nextEdge.weight){
                    distance[nextEdge.node] = distance[e.node]+nextEdge.weight;
                    q.add(new Edge(nextEdge.node, distance[nextEdge.node]));
                }
            }
        }

        for(int i=1;i<=n;i++){
            if(distance[i]>max){
                max = distance[i];
            }
        }
        for(int i=1;i<=n;i++){
            if(distance[i]==max){
                answer++;
            }
        }

        return answer;
    }

}

class Edge implements Comparable<Edge>{
    int node;
    int weight;

    Edge(int node, int weight){
        this.node=node;
        this.weight=weight;
    }

    @Override
    public int compareTo(Edge e){
        if(this.weight < e.weight){
            return -1;
        }else{
            return 1;
        }
    }
}
