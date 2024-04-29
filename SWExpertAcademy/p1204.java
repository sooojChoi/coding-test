package SWExpertAcademy;

import java.io.*;
import java.util.*;


public class p1204 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] scoreList;
        int max=-1;  // 가장 많이 나온 점수의 빈도 수
        int answer=0;  // 가장 많이 나온 점수
        StringBuilder sb = new StringBuilder();

        try{
            int T = Integer.parseInt(br.readLine());

            for(int test_case = 1; test_case <= T; test_case++){
                br.readLine();
                st = new StringTokenizer(br.readLine());

                // 초기화
                int score;
                scoreList = new int[101];
                max=-1;

                // 입력을 받으면서, 최댓값을 구한다. 
                for(int i=0;i<1000;i++){
                    score = Integer.parseInt(st.nextToken());
                    scoreList[score]+=1;
                    if(scoreList[score] > max){
                        max = scoreList[score];
                        answer = score;
                    }
                    // 최빈수가 여러 개일 때는 가장 큰 점수를 출력한다.
                    else if(scoreList[score] == max){
                        if(score>answer){
                            answer = score;
                        }
                    }
                }

                sb.append("#"+test_case+" "+answer+"\n");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println(sb);
       
    }
}
