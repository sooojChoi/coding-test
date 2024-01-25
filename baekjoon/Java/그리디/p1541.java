package baekjoon.Java.그리디;

import java.io.*;

public class p1541 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            String input = br.readLine();
            String[] list = input.split("-");
            int sum=0;
    
            for(int i=0;i<list.length;i++){
                if(i==0){
                    sum=getSum(list[0]);
                }else{
                    sum-=getSum(list[i]);
                }
            }

            System.out.println(sum);
        }catch(Exception e){
            System.out.println(e);
        }

    }

    static int getSum(String str){
        String[] list = str.split("\\+");
        int sum=0;
        for(int i=0;i<list.length;i++){
            sum += Integer.parseInt(list[i]);
        }
        return sum;
    }
    
}
