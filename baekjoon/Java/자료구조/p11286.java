package baekjoon.Java.자료구조;

import java.util.*;
import java.io.*;
// 시간초과 됨. 다시 하기.
public class p11286 {
    public static void main(String[] args){
        int N;
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> tempQueue = new LinkedList<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        try{
            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());

            for(int i=0; i<N; i++){
                st = new StringTokenizer(bf.readLine());
                int n = Integer.parseInt(st.nextToken());

                if(n!=0){
                    queue.add(n);
                }else if(n==0 && queue.size()==0){
                    bw.write("0\n");
                }else{
                    // 절댓값이 가장 작은 수들 중 가장 작은 수
                    int min;
                    tempQueue = new LinkedList<>();

                    min = queue.poll();
                    while(queue.size()!=0){
                        int k = queue.poll();
                        if(Math.abs(k)<Math.abs(min) || (Math.abs(k)==Math.abs(min) && k<0)){
                            tempQueue.add(min);
                            min = k;
                        }else{
                            tempQueue.add(k);
                        }
                    }
                    bw.write(min+"\n");
                    queue = tempQueue;
                     

                }
            }


            bw.flush();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        
    }
    
}
