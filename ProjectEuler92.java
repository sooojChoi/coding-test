
import java.util.*;

public class ProjectEuler92 {
    public static void main(String[] args){
        
        final int range = 10000000;

        // 순환되는 수, 그 과정에 있는 수를 저장하는 배열
        // -1 순환 수(sad 수), 1이면 행복 수이다. 초기값은 0
        boolean[] decision = new boolean[range+1];
        // 각 수를 방문했었는지 확인하는 배열
        boolean[] visit = new boolean[range+1];

        // 1은 1*1=1이니까 행복수이다. 
        visit[1]=true;
        decision[1]=true;
        int answer = 0;

        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=2;i<=range;i++){
            // 이미 판정된 수이면 또 판정하지 않기
            if(visit[i]){
                continue;
            }
            int number=i;
            list.add(number);
            visit[number]=true;

            while(true){
                // 몇 자리 수인지 구하기
                int sum=0;
                int temp;
                
                // 자리수마다 제곱하여 sum에 더하기.
                while(number>0){
                    temp = number%10;
                    sum += temp*temp;
                    number/=10;
                }

                list.add(sum);
                // 이미 나왔던 값일 때
                if(visit[sum]){
                    // 행복 수로 판정된 수인 경우
                    if(decision[sum]==true){
                        // 지금까지 계산된 값들 모두 행복수로 판정
                        for(int n: list){
                            decision[n]=true;
                        }
                    }
                    list.clear();
                    break;
                }else{
                    // 방문표시
                    visit[sum]=true;
                    // 합이 1이면 행복수로 판정
                    if(sum==1){
                        for(int n: list){
                            decision[n]=true;
                        }
                        list.clear();
                        break;
                    }else{
                        number=sum;
                    }
                    
                }
            }
        }



        for(int i=1;i<=range;i++){
            if(!decision[i]){
                answer++;
            }
        }

        System.out.println(answer);
    }

}
