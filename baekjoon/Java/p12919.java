package baekjoon.Java;

import java.util.*;


public class p12919 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String S, T;
        
        S = sc.nextLine();
        T = sc.nextLine();
        
        boolean result = makeSameSentence(S, T);

        if(result){
            System.out.println(1);
        }else{
            System.out.println(0);
        }

        sc.close();
       
    }

    // S가 T가 될 수 있는지 검사하는 함수
    static boolean makeSameSentence(String S, String T){
        // 두 문자열의 길이가 같다면 결과를 return 한다. 
        if(S.length() == T.length()){
            if(S.equals(T)){
                return true;
            }else{
                return false;
            }
        }
        
        // a는 문자열+'A'
        // b는 (문자열+'B')를 뒤집은 것
        // reverse 기능을 사용하기 위해 StringBuilder를 활용하였다. 
        String a = S+'A';
        StringBuilder temp = new StringBuilder();
        temp.append(S+'B');
        temp.reverse();
        String b = temp.toString();

        boolean r1, r2;

        // 문자열 T에 a 또는 a를 reverse한 문자열이 포함되는지 확인한다. 
        r1 = isIncludeSentence(a, T);
        // 포함된다면, 해당 문자열에 대해 같은 과정을 진행한다. 
        if(r1){
            r2 = makeSameSentence(a, T);
            if(r2){
                return true;
            }
        }

        // a 또는 a를 reverse한 문자열에 대해서 T가 되는 문자열이 없었다면,
        // b에 대해 검사한다. 
        r1 = isIncludeSentence(b, T);
        // 포함된다면, 해당 문자열에 대해 같은 과정을 진행한다. 
        if(r1){
            r2 = makeSameSentence(b, T);
            if(r2){
                return true;
            }
        }

        return false;
    }

    // s가 T에 포함되는지 검사하는 함수
    static boolean isIncludeSentence(String s, String T){
        StringBuilder sb = new StringBuilder();
        sb.append(s).reverse();
        if(T.contains(s) || T.contains(sb.toString())){
            return true;
        }else{
            return false;
        }
    }

    
}
