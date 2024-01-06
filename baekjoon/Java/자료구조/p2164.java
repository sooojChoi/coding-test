package baekjoon.Java.자료구조;

import java.util.*;
// 큐
public class p2164 {
    public static void main(String[] args){
        int N;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        scanner.close();

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=N;i++){
            queue.add(i);
        }

        while(queue.size()!=1){
            queue.poll();
            queue.add(queue.poll());
        }

        System.out.println(queue.peek());

    }
}
