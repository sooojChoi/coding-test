package programmers.Java;

import java.util.*;

// 연속된 부분 수열의 합
public class sumOfSubs {
    public static void main(String[] args){
        Solution_sumOfSubs sol = new Solution_sumOfSubs();

        int[] seq = new int[]{2, 2, 2, 2, 2};
        int[] answer = sol.solution(seq , 6);

        System.out.println("["+answer[0]+", "+answer[1]+"]");
    }
}

class Solution_sumOfSubs {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        PriorityQueue<Partition> q = new PriorityQueue();
        
        int first=0;
        int second=0;
        long sum=sequence[first];
        
        while(second<sequence.length && first<sequence.length){
            if(sum==k){
                q.add(new Partition(first, second));
                second++;
                if(second>=sequence.length){
                    break;
                }
                sum+=sequence[second];
            }else if(sum>k){
                if(first<second){
                    sum-=sequence[first++];
                }else{
                    second++;  
                    if(second>=sequence.length){
                        break;
                    }      
                    sum+=sequence[second];
                }
            }else{
                second++;
                if(second>=sequence.length){
                    break;
                }   
                sum+=sequence[second];
            }
            
        }
        
        Partition p = q.poll();
        answer[0]  = p.startIndex;
        answer[1] = p.endIndex;
        
        return answer;
    }
}

// 부분 수열 클래스
class Partition implements Comparable<Partition> {
    int startIndex;  //시작 인덱스
    int endIndex;  // 끝 인덱스
    
    Partition(int startIndex, int endIndex){
        this.startIndex=startIndex;
        this.endIndex=endIndex;
    }
    
    @Override
    public int compareTo(Partition p){
        // 수열 길이가 짧은 것이 우선
        // 길이가 같으면 시작 인덱스가 더 작은 것이 우선
        int a = p.endIndex-p.startIndex;
        int b = this.endIndex-this.startIndex;
        if(a<b){
            return 1;
        }else if(a==b){
            if(p.startIndex<this.startIndex){
                return 1;
            }else{
                return -1;
            }
        }else{
            return -1;
        }
    }
    
}