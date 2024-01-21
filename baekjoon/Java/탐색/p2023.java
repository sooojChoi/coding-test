package baekjoon.Java.탐색;

import java.io.*;

// DFS
public class p2023 {
    static int N;
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            N = Integer.parseInt(br.readLine());

            DFS(2,1);
            DFS(3,1);
            DFS(5,1);
            DFS(7,1);

        }catch(Exception e){
            System.out.println(e);
        }
    }



    static boolean primeTest(long n){
        if(n==1)
            return false;
        if(n==2)
            return true;

        long mid = n/2;
        for(long i=2;i<mid;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    static void DFS(long v, int jarisu){
        if(jarisu == N){
            System.out.println(v);
            return;
        }

        for(int i=1;i<=9;i++){
            // 소수인지 검사하고 소수이면 그 아래까지 탐색.
            long nv = v*10+i;
            if(primeTest(nv)){
                DFS(nv, jarisu+1);
            }
        }
    }
}
