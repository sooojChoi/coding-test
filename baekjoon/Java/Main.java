package baekjoon.Java;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] list = new int[2];
        list[0]=1;
        list[1]=2;
        listToZero(list);
        for(int i=0;i<list.length;i++){
            System.out.println(list[i]);
        }
        
    }
    static void listToZero(int[] list) {
        for(int i=0;i<list.length;i++){
            list[i]=0;
        }
    }
}
