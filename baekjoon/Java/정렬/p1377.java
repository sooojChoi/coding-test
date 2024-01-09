package baekjoon.Java.정렬;


import java.util.*;
import java.io.*;

class Point implements Comparable<Point> {
    int num; // 숫자
    int idx; // 인덱스
 
    Point(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }
 
    @Override
    public int compareTo(Point o) {
        return num - o.num;
    }
 
}
// 다시 하기!!!
public class p1377 {
    public static void main(String[] args){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try{
            int N = Integer.parseInt(bf.readLine());
            Point[] points = new Point[N + 1];
            for (int i = 1; i <= N; i++) {
                int temp = Integer.parseInt(bf.readLine());
                points[i] = new Point(temp, i);
            }
            Arrays.sort(points, 1, N + 1); // 숫자를 기준으로 오름차순 정렬
     
            int max = 0;
            for (int i = 1; i <= N; i++) { // 해당 숫자의 인덱스가 몇 칸 움직였는지 계산
                max = Math.max(max, points[i].idx - i); // -> (이동한 횟수 - 1)번
            }

            System.out.println(max+1);
        }catch(Exception e){
        }
    }
}
