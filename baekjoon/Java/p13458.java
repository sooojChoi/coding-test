package baekjoon.Java;
import java.util.*;
import java.io.*;

public class p13458 {
    public static void main(String[] args){
        int N;
        int[] applyList;
        int inspector;
        int deputy;
        long answer=0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            N = Integer.parseInt(br.readLine());
            applyList = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                applyList[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            inspector = Integer.parseInt(st.nextToken());
            deputy = Integer.parseInt(st.nextToken());

            for(int i=0;i<N;i++){
                int numOfApply = applyList[i];

                // 총감독관 1명으로 충분할 경우
                if(numOfApply <= inspector){
                    answer++;
                    continue;
                }else{
                    // 총감독관 1명 추가
                    answer++;
                    // 부감독관 추가
                    int last = numOfApply - inspector;
                    answer += (last/deputy);
                    if(last%deputy!=0){
                        answer++;
                    }
                }
            }

            System.out.println(answer);

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
