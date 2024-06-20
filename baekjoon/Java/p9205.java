package baekjoon.Java;

import java.io.*;
import java.util.*;

public class p9205 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            int testCase = Integer.parseInt(br.readLine());

            for(int t=0;t<testCase;t++){
                int n = Integer.parseInt(br.readLine());
                int[][] position = new int[n+2][2];
                int[] parent = new int[n+2];
                String result = "happy";

                for(int i=0;i<n+2;i++){
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    position[i][0] = Integer.parseInt(st.nextToken());
                    position[i][1] = Integer.parseInt(st.nextToken());
                    parent[i] = i;  // 부모는 자기 자신
                }

                for(int i=0;i<n+2;i++){
                    for(int j=i+1;j<n+2;j++){
                        int distance = Math.abs(position[i][0] - position[j][0]) + Math.abs(position[i][1]-position[j][1]);
                        if(distance <= 20*50){
                            union(i, j, parent);
                        }
                    }
                }


                if(parent[0]!=parent[n+1]){
                    result = "sad";
                }
                if(find(0, parent)!=find(n+1, parent)){
                    result = "sad";
                }
                System.out.println(result);

            }


        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static boolean union(int x, int y, int[] parent) {
        x = find(x, parent); //x의 부모노드 찾기
        y = find(y, parent); //y의 부모노드 찾기

        // 이미 같은 그래프에 속해있을 때 false 반환
        if(x == y) return false;

        if(x <= y) parent[y] = x;
        else parent[x] = y;
        return true;
    }

    public static int find(int x, int[] parent) {
        if(parent[x] == x) return x;
        return find(parent[x], parent);
    }


}
