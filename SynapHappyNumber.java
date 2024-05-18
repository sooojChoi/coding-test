
import java.util.*;

public class SynapHappyNumber {
    public static void main(String[] args){

        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
     
        // 각 범위의 최댓값
        int[] range = {9, 99, 999, 9999};  

        // 순환되는 수, 그 과정에 있는 수를 저장하는 배열
        // false이면 슬픈 수, true이면 행복 수
        boolean[] decision = new boolean[10000]; 
        // 각 수를 방문했었는지 확인하는 배열
        boolean[] visit = new boolean[10000];

        // 1은 1*1=1이니까 행복수이다. 
        visit[1]=true;
        decision[1]=true;

        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=2;i<=9999;i++){
            // 이미 판정된 수이면 또 판정하지 않기
            if(visit[i]==true){
                continue;
            }
            int number=i;
            list.add(number);
            visit[number]=true;

            while(true){
                int sum=0;
                
                // 자리수마다 제곱하여 sum에 더하기.
                while(number>0) {
                    int mod = number%10; 
                    sum += (mod*mod);
                    number /= 10 ; 
                }   

                list.add(sum);
                // 이미 나왔던 값일 때
                if(visit[sum]){
                    // 행복 수로 판정된 수인 경우
                    if(decision[sum]==true){
                        // 지금까지 계산된 값들 모두 행복수로 판정
                        for(int n: list){
                            decision[n]=true;
                            visit[n]=true;
                        }
                    }else{
                        for(int n: list){
                            visit[n]=true;
                        }
                    }
                    list.clear();
                    break;
                }else{
                    // 합이 1이면 행복수로 판정
                    if(sum==1){
                        for(int n: list){
                            decision[n]=true;
                            visit[n]=true;
                        }
                        list.clear();
                        break;
                    }
                    // 합이 1이 아니면 sum에 대해서 위 과정을 반복한다.
                    else{
                        number=sum;
                        visit[sum]=true;
                    }
                    
                }
            }
        }

        // 답을 출력한다. 
        int num=0, sum=0;
        int start=1;
        for(int i=0;i<range.length;i++){
            for(int j=start;j<=range[i];j++){
                if(decision[j]==true){
                    num++;
                    sum+=j;
                }
            }
            System.out.print("1 ~ "+range[i]+" 범위의 ");
            System.out.println("행복 수는 "+num+"개이고 총합은 "+sum+"입니다.");
            start=range[i]+1;
        }

        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    
}
