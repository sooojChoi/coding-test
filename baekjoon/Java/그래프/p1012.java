package baekjoon.Java.그래프;

import java.io.*;
import java.util.*;

public class p1012 {
    static boolean[][] visited;
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try{
            int T = Integer.parseInt(br.readLine());

            int M, N, K;
            int[][] graph;

            for(int i=0;i<T;i++){
                st = new StringTokenizer(br.readLine());
                M = Integer.parseInt(st.nextToken());
                N = Integer.parseInt(st.nextToken());
                K = Integer.parseInt(st.nextToken());

                graph = new int[M][N];
                visited = new boolean[M][N];

                int a, b;
                for(int j=0;j<K;j++){
                    st = new StringTokenizer(br.readLine());
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());
                    graph[a][b]=1;
                }

                // 1번부터 모든 그래프 탐색
                int answer=0;
                for(int j=0;j<M;j++){
                    for(int k=0;k<N;k++){
                        if(!visited[j][k] && graph[j][k]==1){
                            DFS(j, k, graph);
                            answer++;
                        }
                    }
                }

                System.out.println(answer);
                
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    static void DFS(int x, int y, int[][] graph){
        if(visited[x][y]){
            return;
        }
        visited[x][y] = true;
        // 위, 아래, 양옆에 인접한 노드가 있으면 거기로 이동
        if(x>0 && graph[x-1][y]==1){
            DFS(x-1, y, graph);
        }
        if(x<graph.length-1 && graph[x+1][y]==1){
            DFS(x+1, y, graph);
        }
        if(y>0 && graph[x][y-1]==1){
            DFS(x, y-1, graph);
        }
        if(y<graph[0].length-1 && graph[x][y+1]==1){
            DFS(x, y+1, graph);
        }
        
    }
}
