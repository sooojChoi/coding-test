package baekjoon.Java.자료구조;

import java.io.*;
import java.util.*;

// 투 포인터 알고리즘.
public class p2018 {

    public static void main(String[] args){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int start=1,end=1,sum=1,count=1;

        try{
            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());

            while(end!=N){
                if(sum==N){
                    count++;
                    end++;
                    sum+=end;
                }else if(sum>N){
                    sum-=start;
                    start++;
                }else{
                    end++;
                    sum+=end;
                }
            }

        }catch(Exception exception){
        }

        System.out.println(count);
        
    }
    
}
