package SWExpertAcademy;

import java.util.*;

// input
// 10
// 123 1
// 2737 1
// 757148 1
// 78466 2
// 32888 2
// 777770 5
// 436659 2
// 431159 7
// 112233 3
// 456789 10

//output
// #1 321
// #2 7732
// #3 857147
// #4 87664
// #5 88832
// #6 777770
// #7 966354
// #8 954311
// #9 332211
// #10 987645

public class sw1244 {
    static int answer=0;
    static int max;
    static boolean findAnswer = false;

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
        
            Integer[] clone = Arrays.stream(list).boxed().toArray(Integer[]::new); 
            Arrays.sort(clone, Collections.reverseOrder());
            int x=0;
            for(int k=clone.length-1;k>=0;k--){
                x += (Math.pow(10, k)*clone[Math.abs(clone.length-1-k)]);
            }
            max = x;

            changeList(list, change);
    
            System.out.println("#"+test_case+" "+answer);
            answer = 0;
            findAnswer = false;
		}

        sc.close();
        
    }
    public static void changeList(int[] list, int c){
        
        if(c==0){
            return;
        }
        c--;
        for(int i=0;i<list.length-1;i++){
            for(int j=i+1;j<list.length;j++){
                int[] cloneList = list.clone();
                int temp = cloneList[i];
                cloneList[i]=cloneList[j];
                cloneList[j] = temp;

                // 주어진 횟수만큼 다 수행했다면,
                if(c==0){
                    int x;
                    x = getIntFromArray(cloneList);
                    if(x>answer){
                        answer = x;
                        if(answer == max){
                            findAnswer = true;
                        }
                    }
                }else{
                    // 교환한 것이 최적해이면, 더 구하지 않는다.
                    int x = getIntFromArray(cloneList);
                    if(x==max){
                        // 남은 횟수가 짝수일 경우
                        if(c%2==0){
                            answer = max;
                        }else{
                            boolean duplicate = false;
                            for(int k=0;k<cloneList.length;k++){
                                for(int z=0;z<cloneList.length;z++){
                                    if(k!=z){
                                        if(k==z){
                                            duplicate = true;
                                            break;
                                        }
                                    }
                                }
                                if(duplicate){
                                    break;
                                }
                            }

                            // 남은 횟수가 홀수이고, 중복되는 값이 있는 경우
                            if(duplicate){
                                answer = max;
                            }else{
                                // 마지막 두 요소의 값을 교환한 값이 답이다. 
                                int t = cloneList[cloneList.length-1];
                                cloneList[cloneList.length-1] = cloneList[cloneList.length-2];
                                cloneList[cloneList.length-2] = t;

                                answer = getIntFromArray(cloneList);
                            }
                        }
                        findAnswer = true;
                        break;
                    }

                    changeList(cloneList.clone(), c);
                }
            }   
            // 최적해를 구했으면, 더 이상 탐색하지 않고 중단한다. 
            if(findAnswer){
                break;
            }
        }
    }

    public static int getIntFromArray(int[] array){
        int x=0;
        for(int k=array.length-1;k>=0;k--){
            x += (Math.pow(10, k)*array[Math.abs(array.length-1-k)]);
        }

        return x;
    }
}


// Java로 다르게 풀이된 코드
// 위처럼 여러 조건 생각할 필요 없이, 방문 체크하며 완전탐색하면 된다.
// 몇 번째의 특정 숫자를 이미 검사한 적 있다면 또 검사하지 않도록 한다.

// import java.util.Scanner;
// import java.io.FileInputStream;
// import java.util.*;
 
// /*
//    사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
//    이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
//  */
// class Solution
// {
//     static int exchangeCount ;
//     static int result ;
//     static boolean[][] visited;
//     public static void main(String args[]) throws Exception
//     {
//         Scanner sc = new Scanner(System.in);
//         int T;
//         T=sc.nextInt();
//         for(int test_case = 1; test_case <= T; test_case++)
//         {
//             String number = sc.next();
//             exchangeCount = sc.nextInt();
//             result = Integer.MIN_VALUE;
//             visited = new boolean[exchangeCount][(int) Math.pow(10, number.length())];
//             getMaxNumber(number, 0);
//             System.out.printf("#%d %d\n",test_case, result);
//         }
//     }
//     private static void getMaxNumber(String number, int count) {
//         if (count == exchangeCount) {
//             result = Math.max(Integer.parseInt(number), result);
//             return;
//         }
//         for (int i = 0; i < number.length(); i++) {
//             char temp1 = number.charAt(i);
//             for (int j = i + 1; j < number.length(); j++) {
//                 char temp2 = number.charAt(j);
//                 StringBuilder sb = new StringBuilder();
//                 for (int k = 0; k < number.length(); k++) {
//                     if (k == i) {
//                         sb.append(temp2);
//                     } else if (k == j) {
//                         sb.append(temp1);
//                     } else {
//                         sb.append(number.charAt(k));
//                     }
//                 }
//                 if (!visited[count][Integer.parseInt(sb.toString())]) {
//                     visited[count][Integer.parseInt(sb.toString())] = true;
//                     getMaxNumber(sb.toString(), count + 1);
//                 }
//             }
//         }
//     }
// }