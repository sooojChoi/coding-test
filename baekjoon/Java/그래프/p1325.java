package baekjoon.Java.그래프;

import java.util.*;
import java.io.*;

// 사이클이 있는 경우 해결이 안 됨.
// https://www.acmicpc.net/board/view/6899
// 위 사이트에 올라온 반례 해결하면 정답 나올 듯.
// 지금 방법처럼 하면 시간초과 나고.. HashSet 이용하면 사이클이나 양방향을 해결 못하고..
public class p1325 {
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    static int count;

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

            for(int i=0;i<N+1;i++){
                arr[i] = new ArrayList<Integer>();
            }
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[y].add(x);
            }
            count = 0;
            int max=0;
            int[] result = new int[N+1];
            for(int i=1;i<N+1;i++){
                DFS(i);
                result[i] = count;
                if(max<count){
                    max=count;
                }
                count=0;
                visited = new boolean[N+1];
            }
            StringBuilder sb = new StringBuilder();
            for(int i=1;i<=N;i++){
               if(result[i]==max){
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

        visited[v] = true;
        count++;

        for(int i:arr[v]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }

    
}
