package baekjoon.Java.그래프;

import java.io.*;
import java.util.*;

public class p1707 {
    static String answer = "YES";
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static HashSet<Integer> groupA;
    static HashSet<Integer> groupB;
    static char[] groupList;

    public static void main(String[] args){
        int K;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try{
            K = Integer.parseInt(br.readLine());
            int V, E;
            int node1, node2;
            
            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                V = Integer.parseInt(st.nextToken());
                E = Integer.parseInt(st.nextToken());
                graph = new ArrayList[V+1];
                visited = new boolean[V+1];
                groupList = new char[V+1];

                for(int j=1;j<=V;j++){
                    graph[j] = new ArrayList<>();
                }

                for(int j=0;j<E;j++){
                    st = new StringTokenizer(br.readLine());
                    node1 = Integer.parseInt(st.nextToken());
                    node2 = Integer.parseInt(st.nextToken());
                    graph[node1].add(node2);
                    graph[node2].add(node1);
                }

                groupA = new HashSet<Integer>();
                groupB = new HashSet<Integer>();

                for(int j=1;j<=V;j++){
                    if(!visited[j]){
                        DFS(j, 'a');
                    }
                }

                // 검사하고 출력
                System.out.println(answer);
                answer="YES";

            }
        }catch(Exception e){
            System.out.println(e);
        }

    }    

    static void DFS(int v, char group){
        // 이미 방문했던 노드가
        // 나랑 같은 그룹에 있다면 이분 그래프 형성X
        if(visited[v]){
            // 부모 노드와 같은 그룹에 속하는지 확인.
            if(groupList[v]==group){
                answer="NO";
            }
            return;
        }
        // 부모와 인접해있기 때문에
        // 부모와 다른 그룹에 들어간다. 
        switch (group) {
            case 'a':
                groupB.add(v);
                groupList[v]='b';
                break;
            case 'b':
                groupA.add(v);
                groupList[v]='a';
                break;
            default:
                break;
        }
        visited[v] = true;

        for(int i:graph[v]){
            if(group=='a'){
                DFS(i, 'b');
            }else{
                DFS(i, 'a');
            }
        }

    }
}
