package baekjoon.Java;
import java.util.*;

public class p1038 {
    public static void main(String[] args){
        int N;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        Long i=1l;
        int range=0;
        while(range<N){
            if(i>10){
                int length = i.toString().length()-1;
                
                int v1 = (int)Math.pow(10, length);
                int v2 = (int)((i/v1)%10);
                if(v2 < length){
                    i = (long)v1*length;
                }
            }

            boolean result = checkNum(i);
            if(result){
                range++;
            }
            if(i==9876543210L){
                break;
            }
            i++;
        }

        i--;
        if(range!=N){
            System.out.println("-1");
        }else{
            System.out.println(i);
        }
        
    }

    static boolean checkNum(long n){
        if(n<11){
            return true;
        }
        long temp = n%10;
        n /= 10;
        while(n>0){
            if(temp >= n%10){
                return false;
            }
            temp = n%10;
            n /= 10;
        }
        return true;
    }
}
