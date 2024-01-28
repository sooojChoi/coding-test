package baekjoon.Java.그래프;

import java.util.*;
import java.io.*;

// 사이클이 있는 경우 해결이 안 됨.
// https://www.acmicpc.net/board/view/6899
// 위 사이트에 올라온 반례 해결하면 정답 나올 듯.
public class p1325 {
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    static int[] count;
    static Set<Integer> current_visited_node;
    static int[] result;

    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N, M;

        try{
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new ArrayList[N+1];
            visited = new boolean[N+1];
            result = new int[N+1];
            current_visited_node = new HashSet<>();

            for(int i=0;i<N+1;i++){
                arr[i] = new ArrayList<Integer>();
            }
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[y].add(x);
            }
            count = new int[N+1];
            int max=0;
            for(int i=1;i<N+1;i++){
                if(!visited[i]){
                    DFS(i);
                    for(int j=1;j<=N;j++){
                        if(result[j]!=0 && count[j]==0){
                            count[j] = result[j];
                            if(max<count[j]){
                                max = count[j];
                            }
                        }
                    }
                    result = new int[N+1];
                    current_visited_node = new HashSet<>();
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i=1;i<=N;i++){
                if(count[i]==max){
                    sb.append(i+" ");
                }
            }
            System.out.println(sb);

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void DFS(int v){
        if(visited[v]){
            return;
        }
        current_visited_node.add(v);
        visited[v] = true;
        for(int n:current_visited_node){
            result[n]++;
        }

        for(int i:arr[v]){
            if(!visited[i]){
                DFS(i);
            }else{
                // 이미 방문한 곳이라면 그 곳의 count를 현재 노드에 더해준다.
                if(count[i]!=0){
                    // 이전 탐색에서 이미 방문한 적 있다는 것.
                    for(int n:current_visited_node){
                        result[n]+=count[i];
                    }
                }else if(result[i]!=0){
                    // 이번 탐색에서 이미 방문한 적 있다는 것.
                    // 양방향이라는 것.
                    // 양방향인 경우 두 노드는 방문할 수 있는 노드의 수가 같다.
                    result[v] = result[i];
                    break;
                }
            }
        }
        // 방문할 노드가 없거나 연결된 모든 노드를 방문한 후에 현재 노드를 count 대상에서 제거.
        current_visited_node.remove(v);
    }

    
}
