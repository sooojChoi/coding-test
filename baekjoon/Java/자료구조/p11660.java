package baekjoon.Java.자료구조;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구간 합 구하기(배열 버전)
//   S[i][j] = S[i-1][j] + S[i][j-1] - S[i-1][j-1] + A[i][j];
// (a,b)에서 (c,d)까지 구간 합: S[c][d] - S[c][b-1] - S[a-1][d] + S[a-1][b-1]
public class p11660 {
    public static void main(String[] args) {
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N=Integer.parseInt(st.nextToken());
            int M=Integer.parseInt(st.nextToken());

            int[][] S = new int[N][N];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(bf.readLine());
                for(int j=0;j<N;j++){
                    int n = Integer.parseInt(st.nextToken());
                    if(i==0 && j==0){
                        S[i][j] = n;
                    }else if(i==0){
                        S[i][j]=S[0][j-1]+n;
                    }else if(j==0){
                        S[i][j] = S[i-1][0]+n;
                    }else{
                        S[i][j] = S[i-1][j] + S[i][j-1] - S[i-1][j-1]+n;
                    }
                }
            }

            for(int i=0;i<M;i++){
                st = new StringTokenizer(bf.readLine());
                int a=Integer.parseInt(st.nextToken())-1;
                int b=Integer.parseInt(st.nextToken())-1;
                int c=Integer.parseInt(st.nextToken())-1;
                int d=Integer.parseInt(st.nextToken())-1;
                int result=0;
                if(a==0 &&b==0){
                    result = S[c][d];
                }else if(a==0){
                    result = S[c][d] - S[c][b-1];
                }else if(b==0){
                    result = S[c][d] - S[a-1][d];
                }else{
                    result = S[c][d] - S[c][b-1] - S[a-1][d] + S[a-1][b-1];
                }
                System.out.println(result);
                
            }

        }catch(Exception e){
        }
        
    }
    
}
