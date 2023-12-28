package baekjoon.Java.자료구조;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1546 {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int num_of_score = Integer.parseInt(br.readLine());
            String scores = br.readLine();
            double[] scoresArr = new double[num_of_score];
            double sum=0;
            double maxScore=0;
            StringTokenizer st = new StringTokenizer(scores);
            for(int i=0;i<num_of_score;i++){
                scoresArr[i] = Integer.parseInt(st.nextToken());
                if(maxScore < scoresArr[i]) {
                    maxScore=scoresArr[i];
                }
            }
            for(int i=0;i<num_of_score;i++){
                sum += (scoresArr[i]/maxScore*100);
            }
            System.out.println(sum/num_of_score);


        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
