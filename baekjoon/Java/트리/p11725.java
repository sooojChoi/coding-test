package baekjoon.Java.트리;

import java.util.*;
import java.io.*;

// 트리 구조
// dfs로 해결
public class p11725 {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] parent;
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N; // node 개수
        

        try{
            N = Integer.parseInt(br.readLine());
            list = new ArrayList[N+1];
            visited = new boolean[N+1];
            parent = new int[N+1];
            StringTokenizer st;

            for(int i=1;i<=N;i++){
                list[i] = new ArrayList<>();
            }

            for(int i=0;i<N-1;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(a==1){
                    parent[b]=1;
                }else if(b==1){
                    parent[a]=1;
                }else{
                    if(parent[a]!=0){
                        parent[b]=a;
                    }else if(parent[b]!=0){
                        parent[a]=b;
                    }
                }
                list[a].add(b);
                list[b].add(a);
            }

            DFS(1,1);

            

            StringBuilder sb = new StringBuilder();
            for(int i=2;i<=N;i++){
               sb.append(parent[i]+"\n");
            }
            System.out.println(sb);

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void DFS(int n, int p){
        if(visited[n]){
            return;
        }
        parent[n]=p;
        visited[n] = true;

        for(int i:list[n]){
            if(!visited[i]){
                DFS(i, n);
            }
        }
    }

    
}
// 연결을 나타내는 Connect 클래스
class Connect_11725{
    int node1;
    int node2;

    Connect_11725(int node1, int node2){
        this.node1 = node1;
        this.node2 = node2;
    }
}
