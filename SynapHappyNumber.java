
import java.util.*;

public class SynapHappyNumber {
    public static void main(String[] args){
        // 각 범위의 최댓값
        int[] range = {9, 99, 999, 9999};  
        // 순환되는 수, 그 과정에 있는 수를 저장하는 배열
        // -1 순환 수(sad 수), 1이면 행복 수이다. 초기값은 0
        int[] decision = new int[10000]; 
        boolean[] visit = new boolean[10000];

        visit[1]=true;
        decision[1]=1;

        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=2;i<=9999;i++){
            // 이미 판정된 수이면 또 판정하지 않기
            if(decision[i]!=0){
                continue;
            }
            int number=i;
            list.add(number);
            visit[number]=true;

            while(true){
                // 몇 자리 수인지 구하기
                int place = String.valueOf(number).length();
                int sum=0;
                int temp;
                
                // 자리수마다 제곱하여 sum에 더하기.
                if(place>=1){
                    temp=number%10;
                    sum+= temp*temp;
                }
                if(place>=2){
                    temp=number%100/10;
                    sum+= temp*temp;
                }
                if(place>=3){
                    temp=number%1000/100;
                    sum+= temp*temp;
                }
                if(place==4){
                    temp=number/1000;
                    sum+= temp*temp;
                }

                list.add(sum);
                // 이미 나왔던 값일 때
                if(visit[sum]){
                    // 행복 수로 판정된 수인 경우
                    if(decision[sum]==1){
                        for(int n: list){
                            decision[n]=1;
                        }
                    }
                    // 슬픈 수로 판정된 수, 아직 판정되지 않았지만 이제 판정될 수인 경우
                    else if(decision[sum]==-1){
                        for(int n: list){
                            decision[n]=-1;
                        }
                    }
                    list.clear();
                    break;
                }else{
                    // 방문표시
                    visit[sum]=true;
                    // 행복수로 판정
                    if(sum==1){
                        for(int n: list){
                            decision[n]=1;
                        }
                        list.clear();
                        break;
                    }else{
                        number=sum;
                    }
                    
                }
            }
        }

        int num=0;
        int sum=0;
        int start=1;
        for(int i=0;i<range.length;i++){
            for(int j=start;j<=range[i];j++){
                if(decision[j]==1){
                    num++;
                    sum+=j;
                }
            }
            System.out.print("1 ~ "+range[i]+" 범위의 ");
            System.out.println("행복 수는 "+num+"개이고 총합은 "+sum+"입니다.");
            start=range[i]+1;
        }
    }

}
