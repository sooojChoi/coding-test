package baekjoon.Java.자료구조;

import java.util.*;
import java.io.*;

// 스택
public class p1874 {
    public static void main(String[] args){
        int n, push=1;
        int[] data;
        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        boolean result = true;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try{
            StringTokenizer st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            data = new int[n];
            
            for(int i=0;i<n;i++){
                st = new StringTokenizer(bf.readLine());
                data[i] = Integer.parseInt(st.nextToken());
            }

            

            for(int i=0;i<n;i++){
                int d = data[i];

                // push가 d보다 작거나 같으면 같아질 때까지 1씩 키우며 스택에 추가.
                if(push<=d){
                    while(push!=d+1){
                        stack.push(push);
                        sb.append("+\n");

                        if(push==d){
                            stack.pop();
                            sb.append("-\n");
                        }
                        push++;                        
                    }
                }
                // push가 d보다 크면 스택에 있는 값 pop. 
                else{
                    int element = stack.pop();
                    if(element!=d){
                        result=false;
                        System.out.println("NO");
                        break;
                    }
                    sb.append("-\n");
                }
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        if(result) System.out.println(sb.toString());
    }
}
