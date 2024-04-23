package SWExpertAcademy;

import java.util.*;

public class sw1206 {
    public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int N;
        int[] height;
        int answer = 0;
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			N = sc.nextInt();
            height = new int[N];
            for(int i=0; i<N; i++){
                height[i] = sc.nextInt();
            }
            for(int i=2;i<N-2; i++){
            	int left_max = Math.max(height[i-1], height[i-2]);
                int right_max = Math.max(height[i+1], height[i+2]);
                int side_max = Math.max(left_max, right_max);
                if(side_max< height[i]){
                    answer += (height[i]-side_max);
                }
    
            }
            
            System.out.println("#"+test_case+" "+answer);
            answer=0;
			
		}
	}
}
