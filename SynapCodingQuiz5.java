import java.io.*;
import java.util.*;

public class SynapCodingQuiz5 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> input = new PriorityQueue<>();

        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                input.add(Integer.parseInt(st.nextToken()));
            }

            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            
            int zeroNum=0;
            while(!input.isEmpty()){
                // 첫 번째 수
                if(sb1.length()==0 && sb2.length()==0){
                    // 0은 다 뺀다. 첫 번째 자리에 올 수 없기 때문에.
                    while(input.peek()==0 && input.size()>0){
                        input.poll();
                        zeroNum++;
                    }
                    // 0을 제외하고 남은 수가 2 미만이면 자연수를 만들 수 없다. 
                    if(input.size()<2){
                        System.out.println("-1");
                        return;
                    }else{
                        sb1.append(input.poll());
                        sb2.append(input.poll());
                    }

                    // 0을 빼둔만큼 다시 넣어준다. 
                    for(int i=0;i<zeroNum;i++){
                        input.add(0);
                    }
                }
                else{
                    if(input.size()>=2){
                        sb1.append(input.poll());
                        sb2.append(input.poll());
                    }else{
                        sb1.append(input.poll());
                    }
                    
                }
            }

            int answer = Integer.parseInt(sb1.toString())+Integer.parseInt(sb2.toString());
            System.out.println(answer);

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
