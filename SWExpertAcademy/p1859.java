package SWExpertAcademy;

import java.util.*;

public class p1859 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
        int[] inputList;
        int N;
        long answer=0;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = sc.nextInt();
            inputList = new int[N];
            
            int[] max=new int[N];
            for(int i=0;i<N;i++){
             inputList[i] = sc.nextInt();
                
            }
            max[N-1]=inputList[N-1];
            for(int i=N-2;i>=0;i--){
                if(inputList[i]>max[i+1]){
                	max[i] = inputList[i];
                }else{
                    max[i] = max[i+1];
                }
            }
            
            for(int i=0;i<N;i++){
            	answer = answer + (max[i]-inputList[i]);
            }
            
            System.out.println("#"+test_case+" "+answer);
            answer=0;
              
		}
    }
}
