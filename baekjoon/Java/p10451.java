package baekjoon.Java;

import java.util.*;
import java.io.*;

public class p10451{
    static int answer=0;
    static HashSet<Integer> set;
    public static void main(String[] args){
        ArrayList[] graph;
        int T;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean[] visit;

        try{
            T = Integer.parseInt(br.readLine());

            for(int testCase=1;testCase<=T;testCase++){
                // 입력 받기
                int N = Integer.parseInt(br.readLine());
                st = new StringTokenizer(br.readLine());

                // 초기화
                graph = new ArrayList[N+1];
                visit = new boolean[N+1];
                for(int i=1;i<=N;i++){
                    graph[i] = new ArrayList<Integer>();
                }

                for(int i=1;i<=N;i++){
                    int node = Integer.parseInt(st.nextToken());
                    graph[i].add(node);
                }


                for(int i=1;i<=N;i++){
                    if(!visit[i]){
                        set = new HashSet<>();
                        DFS(i, visit, graph);
                    }
                }
                

                System.out.println(answer);
                answer=0;

            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    static void DFS(int n, boolean[] visit, ArrayList<Integer>[] graph){
        if(visit[n]){
            if(set.contains(n)){
                answer++;
                set.clear();
            }
            return;
        }

        set.add(n);
        visit[n] = true;

        for(int v : graph[n]){
            DFS(v, visit, graph);
        }
    }

    
}