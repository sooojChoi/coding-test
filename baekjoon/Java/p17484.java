package baekjoon.Java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17484 {
    static int[][] map;
    static Node[][] dp;
    public static void main(String[] args){
        int N, M;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        try{
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            dp = new Node[N][M];

            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());

                for(int j=0;j<M;j++){
                    int n = Integer.parseInt(st.nextToken());
                    map[i][j] = n;
                    if(i==0){
                        dp[i][j] = new Node(n, -2);
                    }else{
                        dp[i][j] = new Node(Integer.MAX_VALUE, -2);
                    }
                }
            }

            for(int i=0;i<M;i++){
                for(int j=i-1;j<=i+1;j++){
                    if(j<0 || j>=M){
                        continue;
                    }

                    if(j==i-1){
                        searchMap(1, j, -1, map[0][i]);
                    }else if(j==i){
                        searchMap(1, j, 0, map[0][i]);
                    }else if(j==i+1){
                        searchMap(1, j, 1, map[0][i]);
                    }
                    
                }
            }


            int answer = Integer.MAX_VALUE;
            for(int i=0;i<M;i++){
                answer = Math.min(answer, dp[N-1][i].value);
            }

            System.out.println(answer);



        }catch(Exception e){
            System.out.println(e);
        }
    }

    static void searchMap(int row, int col, int direction, int value){
    
        if(dp[row][col].previous_node == direction){
            if(dp[row][col].value <= value){
                // 이전의 탐색 값이 더 작다면,
                // 더 이상 이 노드에 대해 탐색하지 않는다. 
                return;
            }
        }

        dp[row][col].previous_node = direction;
        dp[row][col].value = Math.min(dp[row][col].value, value+map[row][col]);

        for(int i=-1;i<=1;i++){
            if(i==direction){
                continue;
            }
            if(row+1 == map.length){
                break;
            }
            if(col+i <0 || col+i >=map[0].length){
                continue;
            }
            searchMap(row+1, col+i, i, value+map[row][col]);
        }
    }

    
}

class Node{
    int value;
    // 이전 행의 어느 방향에서 왔는지에 대한 정보
    // -2는 초기값, 1은 좌측 상단, 0은 중앙 상단, -1은 우측 상단에서 온 것. 
    int previous_node;

    Node(int value, int previous_node){
        this.value = value;
        this.previous_node = previous_node;
    }
}
