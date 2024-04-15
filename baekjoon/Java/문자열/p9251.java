package baekjoon.Java.문자열;
import java.io.*;

public class p9251 {
    public static void main(String[] args){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] str1;
        char[] str2;
        int[][] lcs;
        int answer=0;

        try{
           str1 = bf.readLine().toCharArray();
           str2 = bf.readLine().toCharArray();

           lcs = new int[str1.length+1][str2.length+1];

           for(int i=1; i<=str1.length;i++){
                for(int j=1;j<=str2.length;j++){
                    if(str1[i-1]==str2[j-1]){
                        lcs[i][j] = lcs[i-1][j-1]+1;
                        answer = Math.max(answer, lcs[i][j]);
                    }else{
                        lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                    }
                }
           }

           System.out.println(answer);

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
