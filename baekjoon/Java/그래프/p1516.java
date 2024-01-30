package baekjoon.Java.그래프;

import java.util.*;
import java.io.*;


// 메모리 초과 나는 이유?
public class p1516 {
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
            int[] result = new int[N+1];
            in_nodes_num = new int[N+1];

            for(int i=1;i<=N;i++){
                arr[i] = new ArrayList<Integer>();
            }
            StringTokenizer st;
            for(int i=1;i<=N;i++){
                st = new StringTokenizer(br.readLine());
                time[i]=Integer.parseInt(st.nextToken());
                result[i]=time[i];

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
        
            // 진입차수가 2이상인 노드에 한해, 각 노드로 진입하는 노드들을 저장하는 리스트
            ArrayList<Integer>[] in_nodes = new ArrayList[N+1];  
            for(int i=1;i<N+1;i++){
                in_nodes[i] = new ArrayList<Integer>();
            }

            Queue<Integer> q = new LinkedList<Integer>();
            for(int i=1;i<=N;i++){
                if(in_nodes_num[i]==0){
                    q.add(i);
                }
            }

            int[] temp_time = new int[N+1];
            int node, max=0;
            while(!q.isEmpty()){
                node = q.poll();

                for(int i:arr[node]){
                    in_nodes[i].add(node);
                    in_nodes_num[i]--;
                    if(in_nodes[i].size()>0){
                        // temp_time 초기화
                        for(int x=0;x<N+1;x++){
                            temp_time[x] = 0;
                        }
                        max=0;
                        
                        // i로 들어오는 모든 노드들에 대해 검사한다.
                        // i로 들어오는 노드가 1개일 경우, 그 노드의 시간과 i의 시간을 더해서 i에 저장
                        // 그렇지 않을 경우, i로 들어오는 노드들 간의 연결성을 확인한 후 시간의 최댓값을 구해
                        // 그 최댓값과 i의 시간을 더해 i에 저장
                        for(int j:in_nodes[i]){
                            if(in_nodes[i].size()==1){
                                temp_time[j] = time[j];
                                break;
                            }
                            // 다른 노드들과의 연결성 확인
                            for(int k:in_nodes[i]){
                                if(j!=k){
                                    // j가 k로 진입한다면(=연결되어있다면)
                                    if(arr[j].contains(k)){
                                        temp_time[j] = time[k];
                                        temp_time[k] = time[k];
                                    }else{
                                        temp_time[j] = time[j];
                                    }
                                }
                            }
                        }
                        // temp_time 중 최댓값을 구해서 time[i]에 더해준다.
                        for(int j=1;j<N+1;j++){
                            if(temp_time[j]>max){
                                max = temp_time[j];
                            }
                        }
                        
                        if(in_nodes[i].size()>1){
                            time[i] = result[i]+max;
                        }else{
                            time[i] += max;
                        }
                        

                    }
                    if(in_nodes_num[i]==0){
                        q.add(i);
                    }
                }
            }

            for(int i=1;i<=N;i++){
                System.out.println(time[i]);
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
