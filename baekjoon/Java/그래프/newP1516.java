package baekjoon.Java.그래프;

import java.util.*;
import java.io.*;

public class newP1516 {
    static ArrayList<Integer>[] arr;
    static int[] time;
    public class Main {
        static ArrayList<Integer>[] arr;
        static int[] time;
        public static void main(String[] args){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N;
            int[] in_nodes_num;  //진입차수 저장하는 배열
    
            try{
                N = Integer.parseInt(br.readLine());
                arr = new ArrayList[N+1];
                time = new int[N+1];
                
                in_nodes_num = new int[N+1];
    
                for(int i=1;i<=N;i++){
                    arr[i] = new ArrayList<Integer>();
                }
                StringTokenizer st;
                for(int i=1;i<=N;i++){
                    st = new StringTokenizer(br.readLine());
                    time[i]=Integer.parseInt(st.nextToken());
    
                    while(true){
                        int n = Integer.parseInt(st.nextToken());
                        if(n==-1){
                            break;
                        }
                        // 그래프 초기화
                        arr[n].add(i);
                        // 진입차수 초기화
                        in_nodes_num[i]++;
                    }
                }
    
                Queue<Integer> q = new LinkedList<Integer>();
                for(int i=1;i<=N;i++){
                    if(in_nodes_num[i]==0){
                        q.add(i);
                    }
                }
    
                int node;
                int[] result = new int[N+1];
                while(!q.isEmpty()){
                    node = q.poll();
    
                    for(int i:arr[node]){
                        result[i] = Math.max(result[i], result[node]+time[node]);
                   
                        in_nodes_num[i]--;
                        if(in_nodes_num[i]==0){
                            q.add(i);
                        }
                    }
                }
    
                for(int i=1;i<=N;i++){
                    System.out.println(result[i]+time[i]);
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
}
