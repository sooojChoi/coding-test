package baekjoon.Java.탐색;


import java.util.*;
import java.io.*;

// DFS 깊이 우선 탐색
public class p11724 {
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr = new ArrayList[n+1];
            visited = new boolean[n+1];

            // 방문 배열, 인접 리스트 초기화
            for(int i=1;i<n+1;i++){
                visited[i] = false;
                arr[i] = new ArrayList<Integer>();
            }

            for(int i=0;i<e;i++){
                st = new StringTokenizer(br.readLine());
                int one = Integer.parseInt(st.nextToken());
                int two = Integer.parseInt(st.nextToken());
                // 양방향 그래프이므로 둘 다 넣어준다.
                arr[one].add(two);
                arr[two].add(one);
            }
            

            int count=0;
            for(int i=1;i<n+1;i++){
                if(!visited[i]){
                    DFS(i);
                    count++;
                }
            }

            System.out.println(count);



        }catch(Exception e){
            System.out.println(e);
        }
    }

    static void DFS(int v){
        if(visited[v]){
            return;
        }
        visited[v]=true;
        for(Integer i : arr[v]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }
}
