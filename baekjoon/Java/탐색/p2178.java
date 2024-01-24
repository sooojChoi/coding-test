package baekjoon.Java.탐색;

import java.util.*;
import java.io.*;

// BFS 미로 탐색
public class p2178 {
    static int[][] arr;
    static boolean[][] visited;
    static int[][] route;
    static int N,M;
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new int[N+1][M+1];
            visited = new boolean[N+1][M+1];
            route = new int[N+1][M+1];

            for(int i=1;i<N+1;i++){
                String line = br.readLine();
                for(int j=1;j<M+1;j++){
                    arr[i][j] = Integer.parseInt(line.substring(j-1,j));
                }
            }

            BFS();

        }catch(Exception e){
            System.out.println(e);
        }
    }

    static void BFS(){
        Queue<Point> q = new LinkedList<Point>();
        visited[1][1] = true;
        q.add(new Point(1,1));
        Point node;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int x, y;

        while(q.size()>0){
            node = q.poll();
            if(node.x == M && node.y == N){
                System.out.println(route[node.y][node.x]+1);
                return;
            }
            for(int i=0;i<4;i++){
                x = node.x+dx[i];
                y = node.y+dy[i];
                if(x>=0 && x<=M && y>=0 && y<=N){
                    if(!visited[y][x] && arr[y][x]==1){
                        q.add(new Point(x, y));
                        visited[y][x] = true;
                        route[y][x] = route[node.y][node.x]+1;
                    }
                }
            }
            
        }
    }
}


class Point{
    int x;
    int y;

    Point(int x,int y){
        this.x = x;
        this.y = y;
    }
}