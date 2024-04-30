package baekjoon.Java.탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p10026 {
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        char[][] map = new char[N][N];
        int areaCount=0;
        boolean[][] visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            String str = sc.nextLine();
            for(int j=0;j<N;j++){
                map[i][j] = str.charAt(j);
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    BFS_normal(new Point(i, j), visited, map);
                    areaCount++;
                }
            }
        }
        System.out.print(areaCount+" ");

        visited = new boolean[N][N];
        areaCount = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    BFS_blind(new Point(i, j), visited, map);
                    areaCount++;
                }
            }
        }

        System.out.println(areaCount);



        sc.close();
    }

    static void BFS_normal(Point p,boolean[][] visitied, char[][] map){
        if(visitied[p.x][p.y]){
            return;
        }
        visitied[p.x][p.y]=true;

        Queue<Point> q = new LinkedList<Point>();
        q.add(p);

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while(!q.isEmpty()){
            Point v = q.poll();
            
            // v에 대하여, 상하좌우 탐색하면서 큐에 넣기
            for(int i=0;i<4;i++){
                int x = v.x + dx[i];
                int y = v.y + dy[i];
                if(x>=0 && x<map.length && y>=0 && y<map.length && visitied[x][y]==false){
                    if(map[p.x][p.y] == map[x][y]){
                        visitied[x][y] = true;
                        q.add(new Point(x, y));
                    }
                }
            }
        }

    }

    static void BFS_blind(Point p,boolean[][] visitied, char[][] map){
        if(visitied[p.x][p.y]){
            return;
        }
        visitied[p.x][p.y]=true;

        Queue<Point> q = new LinkedList<Point>();
        q.add(p);

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while(!q.isEmpty()){
            Point v = q.poll();
            
            // v에 대하여, 상하좌우 탐색하면서 큐에 넣기
            for(int i=0;i<4;i++){
                int x = v.x + dx[i];
                int y = v.y + dy[i];
                if(x>=0 && x<map.length && y>=0 && y<map.length && visitied[x][y]==false){
                    if(map[p.x][p.y]=='G' || map[p.x][p.y]=='R'){
                        if(map[x][y]=='G' || map[x][y]=='R'){
                            visitied[x][y] = true;
                            q.add(new Point(x, y));
                        }
                    }else{
                        if(map[p.x][p.y] == map[x][y]){
                            visitied[x][y] = true;
                            q.add(new Point(x, y));
                        }
                    }
                }
            }
        }

    }
}

class Point{
    int x; int y;
    Point(int x, int y){
        this.x = x; this.y = y;
    }
}
