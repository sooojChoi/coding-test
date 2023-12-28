package baekjoon.Java.자료구조;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p11720 {
    
    public static void main(String[] args) {
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String realNum = br.readLine();
        int sum=0;

        char[] charnum = realNum.toCharArray();
        for(int i=0;i<charnum.length;i++){
            sum+=charnum[i]-'0';
        }
        System.out.println(sum);    
        

       // StringTokenizer st = new StringTokenizer(s);
      //  int a = Integer.parseInt(st.nextToken());

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
