package baekjoon.Java.탐색;

import java.io.*;
import java.util.*;

// 미해결, 같은 알고리즘으로 C++로 풀면 성공하지만 자바의 경우 시간초과.
public class p1325 {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int hacked=0;
    
    public static void main(String[] args){
        int N, M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] result;

        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            list = new ArrayList[N+1];
            visited = new boolean[N+1];
            result = new int[N+1];

            int a, b;
            for(int i=1; i<=N; i++){
                list[i] = new ArrayList<Integer>();
            }
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                list[b].add(a);
            }

            int max=-1;
            for(int i=1;i<=N;i++){
                visited = new boolean[N+1];
                DFS(i);
                if(hacked>max){max=hacked;}
                result[i] = hacked;
                hacked=0;
            }

            for(int i=1;i<=N;i++){
                if(result[i]==max){
                    System.out.print(i+" ");
                }
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }

    static void DFS(int v){
        if(visited[v]){
            return;
        }
        
        hacked++;
        visited[v] = true;

        for(int i:list[v]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }

}
