package programmers.Java;
import java.util.*;

public class 가장큰수 {
    public static void main(String[] args){
        // 문자열로 내림차순 정렬?
        String answer="";
        int[] numbers = {6, 10,2};
        
        Solution s = new Solution();
        answer = s.solution(numbers);

        System.out.println(answer);
        
    }

    static class Solution {

        public String solution(int[] numbers) {
            String answer = "";
    
            String[] strlist = new String[numbers.length];
            for(int i=0;i<numbers.length;i++){
                strlist[i] = String.valueOf(numbers[i]);
            }
    
            Arrays.sort(strlist, (o1, o2)-> (o2+o1).compareTo(o1+o2));
    
            for(int i=0;i<numbers.length;i++){
                answer += strlist[i];
            }
    
             if(answer.charAt(0)=='0'){
                answer = "0";
            }
    
            return answer;
        }
    
    
    }

}
