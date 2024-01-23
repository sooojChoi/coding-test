package baekjoon.Java.탐색;


import java.util.*;
import java.io.*;

class p1260 {
  static ArrayList<Integer>[] arr;
  static boolean[] visited;
  
  public static void main(String[] args){
    int n, e, s;
    
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    try{
    	StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
      	e = Integer.parseInt(st.nextToken());
      	s = Integer.parseInt(st.nextToken());
      	arr = new ArrayList[n+1];
      	visited = new boolean[n+1];
      
      	// arr 초기화
      	for(int i=1;i<n+1;i++){
          arr[i] = new ArrayList();
          visited[i] = false;
        }
      	for(int i=0;i<e;i++){
          st = new StringTokenizer(br.readLine());
          int a = Integer.parseInt(st.nextToken());
          int b = Integer.parseInt(st.nextToken());
          arr[a].add(b);
          arr[b].add(a);
        }

        for(int i=1;i<n+1;i++){
            Collections.sort(arr[i]);
        }

        // for(int i=1;i<n+1;i++){
        //     if(!visited[i]){
        //         DFS(i);
        //     }
        // }
        DFS(s);
        for(int i=1;i<n+1;i++){
            visited[i] = false;
        }

        System.out.println("");

        BFS(s);
      
      	
    }catch(Exception err){
      System.out.println(err);
    }
  }

	static void DFS(int v){
		if(visited[v]){
		    return;
		}
		visited[v] = true;
        System.out.print(v+" ");
		for(int i: arr[v]){
		  if(!visited[i]){
		    DFS(i);
		  }
		}
	}

    static void BFS(int v){
        Queue<Integer> q = new LinkedList();
        q.add(v);
        visited[v] = true;

        while(q.size() !=0){
            int node = q.poll();
            System.out.print(node+" ");

            for(int i : arr[node]){
                if(!visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }

    }
  
}