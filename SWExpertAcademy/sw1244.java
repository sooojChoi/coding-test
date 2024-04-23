package SWExpertAcademy;

import java.util.*;

// 완전 탐색으로 풀어도 최대 6의 10승번 이기 때문에 문제 조건에 부합함.
public class sw1244 {
    static int max=0;
    static Set set = new HashSet<Integer>();
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int T;
		T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int change = sc.nextInt();
    
            String str = String.valueOf(N);
            int[] list = new int[str.length()];
            for(int i=0;i<list.length;i++){
                list[i] = Integer.parseInt(str.substring(i, i+1));
            }
    
            changeList(list, change);
    
            System.out.println("#"+test_case+" "+max);
		}
        
    }
    public static void changeList(int[] list, int c){
        c--;
        for(int i=0;i<list.length-1;i++){
            for(int j=i+1;j<list.length;j++){
                int temp = list[i];
                list[i]=list[j];
                list[j] = temp;

                int x=0;
                for(int k=list.length-1;k>=0;k--){
                    x += (Math.pow(10, k)*list[Math.abs(list.length-1-k)]);
                }
                if(set.contains(x)){
                    continue;
                }else{
                    set.add(x);
                }

                // 주어진 횟수만큼 다 수행했다면,
                if(c==0){
                    x=0;
                    for(int k=list.length-1;k>=0;k--){
                        x += (Math.pow(10, k)*list[Math.abs(list.length-1-k)]);
                    }
                    if(x>max){
                        max = x;
                    }
                }else{
                    changeList(list.clone(), c);
                }
            }   
        }
    }
}
