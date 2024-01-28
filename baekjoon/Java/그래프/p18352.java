package baekjoon.Java.그래프;

import java.io.*;
import java.util.*;

// 그래프
public class p18352 {
    static boolean[] visited;
    static int[] depth;
    static ArrayList<Integer>[] arr;
    static int N, M, K, X;
    static ArrayList<Integer> result;

    public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
    
        try{
            st = new StringTokenizer(reader.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            arr = new ArrayList[N+1];
            visited = new boolean[N+1];
            depth = new int[N+1];
            result = new ArrayList<>();

            for(int i=0;i<N+1;i++){
                arr[i] = new ArrayList<>();
            }
            int start, end;
            for(int i=0;i<M;i++){
                st = new StringTokenizer(reader.readLine());
                start = Integer.parseInt(st.nextToken());
                end = Integer.parseInt(st.nextToken());
                arr[start].add(end);
            }

            BFS(X);

            Collections.sort(result);

            if(result.size()==0){
                System.out.println("-1");
                return;
            }
            for(int i:result){
                System.out.println(i);
            }
            


        }catch(Exception e){
            System.out.println(e);
        }

    }
    static int current_depth=0;
    public static void BFS(int v){
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        depth[v] = 0;

        while(q.size()>0){
            int n = q.poll();
            
            for(int i:arr[n]){
                if(!visited[i]){
                    depth[i] = depth[n]+1;
                    visited[i]=true;
                    if(depth[i]==K){
                        result.add(i);
                        continue;
                    }
                    q.add(i);

                }
            }
        }
    }
    
}
