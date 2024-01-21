package baekjoon.Java.탐색;

import java.util.*;
import java.io.*;

// DFS
public class p2023 {
    public static void main(String[] args){

    }



    boolean primeTest(int n){
        if(n==1)
            return false;
        if(n==2)
            return true;

        int mid = n/2;
        for(int i=2;i<mid;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
