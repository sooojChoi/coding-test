package baekjoon.Java;

import java.util.*;

// 문자열 폭발
// 문자를 하나씩 스택에 넣으면서,
// 스택의 크기가 bomb의 길이보다 커졌다면 
// 가장 최근의 bomb만큼의 문자들이 bomb과 같은지 비교하고
// 같다면 제거한다.
// 그 다음 문자를 넣으면서 또 반복.
public class p9935 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[] input = sc.nextLine().toCharArray();
        String bomb = sc.nextLine();

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<input.length;i++){
            stack.push(input[i]);
            if(stack.size()>=bomb.length()){
                int count=0;
                // 가장 최근 단어가 bomb인지 검사하고 맞으면 bomb길이만큼 pop
                for(int j=0;j<bomb.length();j++){
                    if(stack.get(stack.size()-bomb.length()+j)!=bomb.charAt(j)){
                        break;
                    }else{
                        count++;
                    }
                }
                if(count==bomb.length()){
                    for(int j=0;j<bomb.length();j++){
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if(stack.size()>0){
            for(int i=0;i<stack.size();i++){
                sb.append(stack.get(i));
            }
        }else{
            sb.append("FRULA");
        }
        System.out.println(sb);
        
        
        
    }

}
