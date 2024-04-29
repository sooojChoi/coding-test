package baekjoon.Java.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1946 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T; // 테스트케이스
        int N; // 직원 수
        Applicant[] ranks;  // 직원들의 채용 순위
        int answer=0; 
        StringBuilder sb = new StringBuilder();

        try{
            T = Integer.parseInt(br.readLine());

            for(int test_case=1;test_case<=T;test_case++){
                // 초기화
                N = Integer.parseInt(br.readLine());
                ranks = new Applicant[N];
                answer=0;
                int min;

                // 입력받기
                for(int i=0;i<N;i++){
                    st = new StringTokenizer(br.readLine());
                    int paper = Integer.parseInt(st.nextToken());
                    int interview = Integer.parseInt(st.nextToken());
                    ranks[i] = new Applicant(paper, interview);
                }

                // 서류 순위 기준으로 오름차순 정렬
                Arrays.sort(ranks);

                // 서류 1순위는 무조건 통과
                answer++;
                min = ranks[0].interviewRank;

                // 나보다 서류도 높은데 면접 순위가 높은 사람이 있으면, 불통
                for(int i=1;i<ranks.length;i++){
                    if(ranks[i].interviewRank < min){
                        answer++;
                        min = ranks[i].interviewRank;
                    }
                }

                sb.append(answer+"\n");
            }
            
            System.out.println(sb);

        }catch(Exception e){
            System.out.println(e);
        }
    }

}

class Applicant implements Comparable<Applicant>{
    int paperRank;
    int interviewRank;
    Applicant(int paperRank, int interviewRank){
        this.paperRank = paperRank;
        this.interviewRank = interviewRank;
    }

    @Override
    public int compareTo(Applicant o) {
        if(this.paperRank < o.paperRank){
            return -1;
        }else{
            return 1;
        }
    }
    
}