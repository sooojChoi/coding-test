package baekjoon.Java.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p3109 {
    static boolean[][] visited;
    static char[][] map;
    
    public static void main(String[] args){
        // -1이면 건물있는 곳, 0이면 빈칸, 1~10,000 사이의 수라면 이미 방문한 곳
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int R=1, C=1;
        int answer=0;

        try{
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new char[R][C];
            visited = new boolean[R][C];

            String str = "";
            for(int i=0;i<R;i++){
                str = br.readLine();
                for(int j=0;j<C;j++){
                    map[i][j] = str.charAt(j);
                }
            }


            for(int i=0;i<R;i++){
                // 건물이 있는 경우는 패스!
                if(map[i][0]==-1){
                    continue;
                }else{
                    boolean found = DFS(i, 0);
                    if(found){
                        answer++;
                    }
                }
            }

            System.out.println(answer);

        }catch(Exception e){
            System.out.println(e);
        }

      


    }

    static boolean DFS(int r, int c){
        if(visited[r][c]){
            return false;
        }
    
        visited[r][c]=true;

        // 마지막 열이라면 탐색 종료
        if(c==map[0].length-1){
            return true;
        }

        boolean found = false;
        for(int i=r-1;i<=r+1;i++){
            if(i<0 || i>map.length-1){
                continue;
            }
            if(!visited[i][c+1] && map[i][c+1]!='x'){
                found = DFS(i, c+1);
            }
            if(found){
                break;
            }
        }
        return found;
    }
}
