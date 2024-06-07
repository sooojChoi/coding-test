package baekjoon.Java;
import java.util.*;

public class p1038 {
    public static void main(String[] args){
        int N;
        Scanner sc = new Scanner(System.in);
        // 9번째 다음 수부터 체크한다. 
        int order = 9;
        // 아래 수보다 큰 '감소하는 수'는 없다. 
        final long redLight = 9876543210l;
        N = sc.nextInt();


        if(N<=9){
            System.out.println(N);
            sc.close();
            return;
        }
        
        Queue<Long> temp = new LinkedList<Long>();
        
        // 0부터 9까지는 확인한 것으로 간주하고 큐에 넣는다. 
        // 0은 첫번째 자리에 올 수 없는 수 이므로 1부터 넣는다. 
        for(long i=1;i<=9;i++){
            temp.add(i);
        }

    
        while(temp.size()>0){
            // 큐에서 poll한 수 v에 대하여
            // 0부터 9 중에서, v의 1의 자리 수보다 작은 수를 체크하고, 
            // 체크하면서 (v*10+작은 수)를 큐에 넣는다.
            long v = temp.poll();
            for(long i=0;i<=9;i++){
                long nv;
                if(v%10>i){
                    nv = v*10+i;

                    // redLight 가 나왔다면, 가장 큰 '감소하는 수'까지 구한 것.
                    // N만큼 구한 것이면 답을 return하고
                    // 아직 N이 안 되었다면 그 순번의 감소하는 수는 없는 것이므로 -1 출력하고 리턴.
                    if(nv==redLight){
                        order++;
                        if(N==order){
                            System.out.println(nv);
                        }else{
                            System.out.println("-1");
                        }
                        return;
                    }
                    temp.add(v*10+i);
                    order++;

                    if(order==N){
                        System.out.println(nv);
                        return;
                    }
                }else{
                    break;
                }
            }
        }
        
        sc.close();
        
    }

}
