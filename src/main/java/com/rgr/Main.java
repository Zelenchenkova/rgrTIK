package com.rgr;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        double dx = 1;
        double x = in.nextInt();
        double v;
        double y;
        while(x<10){
            v = (9 * x * b) / (b - x);
            y = 2*(Math.atan((25*a)/b))+ 3*(Math.cos((9 * x * b) / (b - x))*Math.cos((9 * x * b) / (b - x)));
            System.out.println(x+"  "+Math.cos(18));
            x = x+dx;
        }


    }

    }
