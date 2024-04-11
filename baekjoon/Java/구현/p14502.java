package baekjoon.Java.구현;
import java.io.*;
import java.util.*;

class p14502 {
    static int[][] map;
    static boolean[][] visited;
    static int numOfVirusPoint;
    static ArrayList<Point> zeroPoint;  // 빈 칸의 위치들을 저장
    static ArrayList<Point> virusPoint;  // original 바이러스 칸의 위치들을 저장
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        zeroPoint = new ArrayList<Point>();
        virusPoint = new ArrayList<Point>();
        int answer = 0; 

        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new int[n][m];

            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<m;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j]==0){
                        zeroPoint.add(new Point(i, j));
                    }else if(map[i][j]==2){
                        virusPoint.add(new Point(i, j));
                    }
                }
            }

            // 벽을 세운 위치를 저장해두는 스택 
            Stack<Point> wallPoints = new Stack<>();

            for( int i=0; i<zeroPoint.size() - 2; i++){
                wallPoints.add(zeroPoint.get(i));
                for(int j=i+1; j<zeroPoint.size()-1; j++){
                    wallPoints.add(zeroPoint.get(j));
                    for(int k=j+1; k<zeroPoint.size(); k++){
                        wallPoints.add(zeroPoint.get(k));
                        // 이 스택의 내용을 가지고 0의 개수 구하기
                        int numOfZeroPoints = getNumOfZeroPoints(wallPoints);
                        if(answer < numOfZeroPoints){
                            answer = numOfZeroPoints;
                        }
                        
                        wallPoints.pop();
                    }
                    wallPoints.pop();
                }
                wallPoints.pop();
            }
            
            System.out.println(answer);

        }catch(Exception e){
            System.out.println(e);
        }

    }

    // 바이러스 위치와 벽의 위치가 주어졌을 때, 
    // 바이러스가 퍼진 후 남은 빈칸의 개수를 리턴하는 함수
    static int getNumOfZeroPoints(Stack<Point> wallPoints) {
        // 벽 세우기
        Point p;
        for(int i=0;i<3;i++){
            p = wallPoints.get(i);
            map[p.x][p.y] = 1;
        }

        // 바이러스 퍼뜨리기
        visited = new boolean[map.length][map[0].length]; // 방문 배열 초기화
        numOfVirusPoint=0;  // 바이러스 개수 초기화

        // DFS 탐색을 통해 바이러스를 퍼뜨리고 그 개수를 구하기.
        for(int i=0;i<virusPoint.size();i++){
            p = virusPoint.get(i);
            if(!visited[p.x][p.y]){
                virusDFS(p.x, p.y);
            }
        }

        // 다음 계산을 위해 벽 허물기
        for(int i=0;i<3;i++){
            p = wallPoints.get(i);
            map[p.x][p.y] = 0;
        }

        // 전체 빈 칸의 수에서, 벽의 개수와 바이러스가 퍼진 칸의 개수를 뺀다. 
        return zeroPoint.size()-(3+numOfVirusPoint)+virusPoint.size();
    }

    static void virusDFS(int x, int y){
        if(visited[x][y]){
            return;
        }
        visited[x][y] = true;
        numOfVirusPoint++;
        

        // 상하좌우에 대해서 탐색해준다. 
        if(x>0){
            if(!visited[x-1][y] && map[x-1][y]==0){
                virusDFS(x-1, y);
            }
        }
        if(y>0){
            if(!visited[x][y-1] && map[x][y-1]==0){
                virusDFS(x, y-1);
            }
        }
        if(x<map.length-1){
            if(!visited[x+1][y] && map[x+1][y]==0){
                virusDFS(x+1, y);
            }
        }
        if(y<map[0].length-1){
            if(!visited[x][y+1] && map[x][y+1]==0){
                virusDFS(x, y+1);
            }
        }
    }

    static class Point { 
        int x, y;
    
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
}
