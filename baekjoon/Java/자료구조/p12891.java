package baekjoon.Java.자료구조;

import java.io.*;
import java.util.*;

// 슬라이딩 윈도우
public class p12891 {
    public static void main(String[] args){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int S=0,P=0;
        String dna="";
        int[] limit = new int[4];
        int count=0;
    
        try{
            StringTokenizer st = new StringTokenizer(bf.readLine());
            S = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bf.readLine());
            dna = st.nextToken();
            st = new StringTokenizer(bf.readLine());
            for(int i=0;i<4;i++){
                limit[i] = Integer.parseInt(st.nextToken());
            }

            char[] dnaArr = dna.toCharArray();
            int[] compareArr = new int[4];
            for(int i=0;i<P;i++){
                switch(dnaArr[i]){
                    case 'A':
                        compareArr[0]++;
                        break;
                    case 'C':
                        compareArr[1]++;
                        break;
                    case 'G':
                        compareArr[2]++;
                        break;
                    case 'T':
                        compareArr[3]++;
                        break;
                    default:
                        break;
                }
            }

            if(compare(compareArr, limit)){
                count++;
            }
            for(int i=0;i<S-P;i++){
                switch(dnaArr[i]){
                    case 'A':
                        compareArr[0]--;
                        break;
                    case 'C':
                        compareArr[1]--;
                        break;
                    case 'G':
                        compareArr[2]--;
                        break;
                    case 'T':
                        compareArr[3]--;
                        break;
                    default:
                        break;
                }
                switch(dnaArr[i+P]){
                    case 'A':
                        compareArr[0]++;
                        break;
                    case 'C':
                        compareArr[1]++;
                        break;
                    case 'G':
                        compareArr[2]++;
                        break;
                    case 'T':
                        compareArr[3]++;
                        break;
                    default:
                        break;
                }
                if(compare(compareArr, limit)){
                    count++;
                }
            }

            

        }catch(Exception exception) {
        }

        System.out.println(count);

    }

    static boolean compare(int[] compareArr, int[] limit){
        int ok=0;
        for(int i=0;i<4;i++){
            if(compareArr[i]>=limit[i]){
                ok++;
            }
        }

        if(ok==4){
            return true;

        }else{
            return false;
        }
    }
    
}
