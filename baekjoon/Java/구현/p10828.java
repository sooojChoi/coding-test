package baekjoon.Java.구현;

import java.util.*;
import java.io.*;


// Java의 Stack 클래스를 사용했을 때보다 직접 구현 시
// 메모리 사용량, 속도 면에서 더 우수하다

public class p10828 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try{
            int commandNum = Integer.parseInt(br.readLine());

            String command;
            int pushNum;
           // Stack<Integer> stack = new Stack<>();
            List<Integer> stack = new ArrayList<>();

            for(int i=0;i<commandNum;i++){
                st = new StringTokenizer(br.readLine());
                command = st.nextToken();

                switch (command) {
                    case "push":
                        pushNum = Integer.parseInt(st.nextToken());
                        stack.add(pushNum);
                        break;
                    case "pop":
                        if(stack.size()>0){
                            System.out.println(stack.get(stack.size()-1));
                            stack.remove(stack.size()-1);
                        }else{
                            System.out.println(-1);
                        }
                        break;
                    case "size":
                        System.out.println(stack.size());
                        break;
                    case "empty":
                        if(stack.size()==0){
                            System.out.println(1);
                        }else{
                            System.out.println(0);
                        }
                        break;
                    case "top":
                        if(stack.size()>0){
                            System.out.println(stack.get(stack.size()-1));
                        }else{
                            System.out.println(-1);
                        }
                        break;
                
                    default:
                        break;
                }
            }

        }catch(Exception e){
            System.out.println("error: "+e);
        }
    }
}
