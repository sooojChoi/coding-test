package baekjoon.Java;


import java.io.*;
import java.util.*;

public class p1083 {
    public static void main(String[] args){
        int N, S;
        // 입력받은 배열 저장
        Integer[] arr;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try{
            N = Integer.parseInt(br.readLine());
            arr = new Integer[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            S = Integer.parseInt(br.readLine());

           
            // 몇 번째 인덱스까지 정렬되었는가.  
            // -1이면 하나도 정렬되지 않은 것. 
            int sortedIndex=-1;

            // 현재 정렬되지 않은 부분에 대해서 내림차순으로 저장하고 있는 배열
            ArrayList<Node> nodeList = new ArrayList<>();


            while(S>0){       
                if(sortedIndex==N-1){
                    break;
                }
                // sorted Index+1 부터 last index까지를 연결리스트에 넣는다. 
                for(int i=sortedIndex+1;i<N;i++){
                    nodeList.add(new Node(arr[i], i));
                }

                // value 기준으로 내림차순 정렬된다. 
                Collections.sort(nodeList);

                
                while(!nodeList.isEmpty()){
                    if(S==0)
                    {
                        break;
                    }


                    for(Node n : nodeList){
                        int indexOfMax = n.index;
                        
                        // 현재 가장 큰 수가 (정렬된 부분 제외하고)맨 앞으로 올 수 있는지 확인한다. 
                        // 만약 가장 큰 수가 가장 앞에 있어서 교환이 필요 없다면 
                        // 정렬된 인덱스만 1 증가시키고, nodeList에서 해당 노드를 제거한다.
                        if(indexOfMax==sortedIndex+1){
                            sortedIndex++;
                            nodeList.remove(n);
                            break;
                        }
                        // 가장 큰 수를 정렬되지 않은 부분 중 가장 맨 앞으로 가져간다. 
                        // 맨 앞부터 가장 큰 수가 있던 자리-1까지, 요소들이 한 칸씩 뒤로 이동한다. 
                        if(indexOfMax-sortedIndex-1<=S){
                            sortedIndex++;
                            
                            for(int i=indexOfMax;i>=sortedIndex+1;i--){
                                arr[i] = arr[i-1];
                                changeIndex(arr[i], nodeList);
                                S--;
                            }
                            arr[sortedIndex] = n.value;
                            
                            
                            nodeList.remove(n);
                            break;
                        }    
                    }

                                
                }

                
            }


            for(int i=0;i<N;i++){
                System.out.print(arr[i]+" ");
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
    }

    // value가 find인 요소를 찾아 index를 index+1 해준다. 
    static void changeIndex(int find, ArrayList<Node> list){
        int start = 0;
        int end = list.size()-1;

        
        while(start<=end){
            int mid = (start+end)/2;
            int value = list.get(mid).value;

            if(value == find){
                list.get(mid).index += 1;
                return;
            }else if(value > find){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
    }
    
    static class Node implements Comparable<Node>{
        int value;
        int index;
    
        Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    
        @Override
        public int compareTo(Node o) {
            if(o.value < this.value){
                return -1;
            }else if(o.value > this.value){
                return 1;
            }else{
                return 0;
            }
        }
    }
}

