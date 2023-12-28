package baekjoon.Java.자료구조;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구간 합 구하기
// 합 배열을 생성하면 O(1)로 해결 가능.
// S[i]=S[i-1]+A[i]
// i부터 j까지 구간 합: S[j]-S[i=1]
public class p11659 {

    public static void main(String[] args) {
     
    try{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int size_of_arr = Integer.parseInt(st.nextToken());    
        int query_size = Integer.parseInt(st.nextToken());
        int[] S = new int[size_of_arr+1];
        st = new StringTokenizer(bf.readLine());
        S[0] = 0;
        for(int i=1; i<size_of_arr+1; i++){
            S[i] = S[i-1]+Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<query_size; i++){
            st = new StringTokenizer(bf.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            System.out.println(S[end]-S[start-1]);
        }

    }catch(Exception e){
    }   
    }
}
