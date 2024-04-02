package baekjoon.Java.동적계획법;
import java.io.*;
import java.util.*;

public class p13398 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        Queue<Long> list = new LinkedList<Long>();

        try{
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                list.add(Long.parseLong(st.nextToken()));
            }

            // 양수끼리 모두 더한다. 
            Stack<Long> stack = new Stack<Long>();
            while(!list.isEmpty()){
                long num = list.poll();
                if(num<0){
                    stack.add(num);
                }else{
                    long tmpNum=num;
                    while(!list.isEmpty()){
                        if(list.peek()>=0){
                            tmpNum += list.poll();
                        }else{
                            break;
                        }
                    }
                    stack.add(tmpNum);
                }
            }
            // 만약 모두 양수였다면 그것이 답이다. 
            if(stack.size()==1){
                System.out.println(stack.pop());
            }

            // 음수를 가운데에 두고, 양수끼리 더했을 때 
            // 각 양수가 혼자일 때보다 크다면 그대로 더한다. 
            // 그렇지 않으면, 그대로 놔둔다. 
            // 더 이상 계산할 것이 없을 때, 
            // 음수가 존재하면 음수를 빼고 다시 계산해보고
            // 음수가 존재하지 않으면 그대로 모두 더한 것이 답이다.

            

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
