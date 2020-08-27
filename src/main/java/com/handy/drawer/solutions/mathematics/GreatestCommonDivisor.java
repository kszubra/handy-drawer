package com.handy.drawer.solutions.mathematics;

public class GreatestCommonDivisor {
    public static int getGCDRecursively(int a, int b){
        if(a%b == 0){
            return b;
        } else {
            return getGCDRecursively(b, a%b); // new pair is "b" and rest from "a mod b"
        }
    }

    public static int getGCDWithWhile(int a, int b) {
        while(a != b){

            if(a>b){
                a -= b;
            } else{
                b -=a;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 158652;
        int b = 1242;
        System.out.println("For values A: " + a + ", B: " + b + ", Expected: 54");
        System.out.println("Recursively: " + getGCDRecursively(a, b));
        System.out.println("While: " + getGCDWithWhile(a, b));
    }
}
