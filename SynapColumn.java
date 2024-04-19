import java.util.*;

public class SynapColumn {
    static  char[] alpha;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        sc.close();
        alpha = new char[26];

        // 1부터 25까지 A~Y이고, 0이 Z이다. 
        alpha[0] = 'Z';
        char ascii = 'A';
        for(int i=1;i<=25;i++){
            alpha[i] = ascii;
            ascii++;
        }
        String answer = "";

        answer = getColumn(input);        
        System.out.println(answer);

    }

    public static String getColumn(int input){
        String result="";
        if(input>26){
            // 26보다 큰 경우에는 재귀함수를 통해 그 값을 구한다. 
            if(input%26==0){
                // 26으로 나누어떨어지는 경우에는 다르게 처리한다. 
                result += getColumn(input/26-1);
            }else{
                result += getColumn(input/26);
            }
         
            result += alpha[input%26];
        }
        else{
            // 26보다 작은 경우엔 알파벳 배열에서 가져온다. 
            result += alpha[input%26];
        }

        return result;
    }
}
