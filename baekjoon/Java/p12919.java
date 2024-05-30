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

    static boolean makeSameSentence(String S, String T){
        if(S.length() == T.length()){
            if(S.equals(T)){
                return true;
            }else{
                return false;
            }
        }
        
        String a = S+'A';
        StringBuilder temp = new StringBuilder();
        temp.append(S+'B');
        temp.reverse();
        String b = temp.toString();

        temp.delete(0, temp.length());
        temp.append(a).reverse();
        if(T.contains(a) || T.contains(temp.toString())){
            boolean r1 = makeSameSentence(a, T);
            if(r1){
                return true;
            }
        }
        
        temp.delete(0, temp.length());
        temp.append(b).reverse();
        if(T.contains(b) || T.contains(temp.toString())){
            boolean r2 = makeSameSentence(b, T);
            if(r2){
                return true;
            }
        }
        

        return false;
    }

    
}
