package baekjoon.Java.탐색;

import java.io.*;
import java.util.*;

// DFS
public class p13023 {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static boolean result = false;
    static int N;
    static int[] distance;

    public static void main(String[] args){
        int M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            list = new ArrayList[N];
            visited = new boolean[N];
            distance = new int[N];

            for(int i=0;i<N;i++){
                list[i] = new ArrayList<>();
            }

            int a, b;
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }

            for(int i=0;i<N;i++){
                DFS(i);
                if(result){
                    break;
                }
                visited = new boolean[N];
                distance = new int[N];
            }
            if(result){
                System.out.println("1");
            }else{
                System.out.println("0");
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }

    static void DFS(int v){
        if(visited[v]){
            return;
        }
        visited[v] = true;

        for(int i:list[v]){
            if(!visited[i]){
                distance[i] = distance[v]+1;
                if(distance[i]==4){
                    result=true;
                    return;
                }
                DFS(i);
                if(result){
                    return;
                }
            }
        }
        if(distance[v]!=4){
            visited[v] = false;
        }

    }
}
