package baekjoon.Java.자료구조;

import java.io.*;
import java.util.*;

public class p17298 {
    public static void main(String[] args){
        int N;
        int[] A;
        Stack<Integer> stack = new Stack<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] result;

        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            A = new int[N];
            result = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                A[i] = Integer.parseInt(st.nextToken());
            }

            stack.push(0); 

            int i=1;
            int top=0;
            result[N-1]=-1;
            while(i<=N-1){
                if(stack.size()>0){
                    top = stack.peek();
                    if(A[i]>A[top]){
                        stack.pop();
                        result[top] = A[i];
                    }else{
                        stack.push(i);
                        i++;
                    }
                }else{
                    stack.push(i);
                    i++;
                }
            }
            while(stack.size()>0){
                result[stack.pop()] = -1;
            }

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for(int k=0;k<N;k++){
                bw.write(result[k]+" ");
            }

            bw.write("\n");
            bw.flush();

        }catch(Exception exception){
            System.out.println(exception);
        }

       
    }
    
}
