package baekjoon.Java;

import java.util.*;
import java.io.*;

public class p13164 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N, K;
        int[] student;

        
        try{
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            student = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                student[i] = Integer.parseInt(st.nextToken());
            }

            if(N==1){
                System.out.println(0);
                return;
            }

            ArrayList<Student> students = new ArrayList<>();
            for(int i=0;i<N;i++){
                if(i==0){
                    students.add(new Student(Integer.MAX_VALUE, student[i+1]-student[i], 0));
                }else if(i==N-1){
                    students.add(new Student(student[i]-student[i-1], Integer.MAX_VALUE, 0));
                }else{
                    students.add(new Student(student[i]-student[i-1], student[i+1]-student[i], 0));
                }
            }

            // 조가 K개가 될 때까지 반복한다. 
            while(students.size()>K){
                // 가장 최소값을 찾아서 조를 합친다. 
                students = makeGroup(students);
            }

            int answer = 0;
            for(int i=0;i<students.size();i++){
                answer += students.get(i).cost;
            }

            System.out.println(answer);

            
            // (0, 2) (2, 2) (2, 1) (1, 4), (4, 0)
            // (0, 2) (2, 3) (3, 5, 1) (5, 0)
            // (0, 5, 2) (3, 5, 1) (5, 0)
            
            // 최소값부터 해야 하는데..
            
            
        }catch(Exception e){
            System.out.println(e);
        }           

    }

    static class Student{
        int left_v;  // 왼쪽 학생과 한 조가 될 경우 드는 비용
        int right_v;  // 오른쪽 학생과 한 조가 될 경우 드는 비용
        int cost;  // 현재 내가 속한 그룹의 비용

        Student(int left_v, int right_v, int cost){
            this.left_v = left_v;
            this.right_v = right_v;
            this.cost = cost;
        }
    }

    static ArrayList<Student> makeGroup(ArrayList<Student> students){
        ArrayList<Student> result = new ArrayList<>();

        // right_value 중 최솟값을 찾아서 합친다. (right 또는 left 중 하나만 찾으면 됨)
        int min = Integer.MAX_VALUE;
        for(Student st : students){
            if(st.right_v < min){
                min=st.right_v;
            }
        }

        // right_value가 min인 애들에 대해 조를 합친다.
        for(int i=0;i<students.size()-1;i++){
            if(students.get(i).right_v == min){
                // 1. 이 다음 것까지 합쳐서, result에 추가
                int left = students.get(i).left_v + students.get(i).right_v;
                int right = students.get(i+1).left_v + students.get(i+1).right_v;
                int cost = min;
                result.add(new Student(left, right, cost));

                // 2. 이 이전 것의 right_v, 이 다다음 것의 left_v를 수정
                if(result.size()>1){
                    result.get(result.size()-2).right_v = left;
                }
                
                students.get(i+1).left_v = right;
            }else{
                result.add(students.get(i));
            }
        }
         

        return result;
    }
}
