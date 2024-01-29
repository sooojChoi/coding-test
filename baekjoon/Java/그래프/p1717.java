package baekjoon.Java.그래프;

import java.util.*;
import java.io.*;

// 유니온 파인드 union find
public class p1717 {
    static int[] arr;
    public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringTokenizer st;

        try{
            st = new StringTokenizer(reader.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[n+1];

            int func, a, b;
            for(int i=0;i<=n;i++){
                arr[i]=i;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<m;i++){
                st = new StringTokenizer(reader.readLine());
                func = Integer.parseInt(st.nextToken());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                if(func==0){
                    union(a,b);

                }else{
                    a = find(a);
                    b = find(b);
                    if(a==b){
                        sb.append("YES\n");
                    }else{
                        sb.append("NO\n");
                    }
                }
            }
            System.out.println(sb);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            arr[b] = a;
        }
    }
    public static int find(int n){
        if(arr[n]!=n){
            arr[n] = find(arr[n]);
            return arr[n];
        }else{
            return n;
        }
    }
  
}
