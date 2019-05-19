package com.markit.microservice.currencyconversion.currencyconversionservice.domain;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Stack;

public class ReverseStack {
    static int count=0;

    public static int add(int x, int y){  //method 1
        return x+y;
    }
    public static int add(int x, int y, int z){ //method 2
        return x+y+z;
    }
    public static int add(double x, int y){ //method 3
        return (int)x+y;
    }
    public static int add(int x, double y){ //method 4
        return x+(int)y;
    }

    public static void main(String[] args) {

        try {
            System.out.println(InetAddress.getLocalHost().getHostName());
            System.out.println(ReverseStack.add(2,3));
            System.out.println(ReverseStack.add(2,3,4));
            System.out.println(ReverseStack.add(2,3.4));
            System.out.println(ReverseStack.add(2.5,3));

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

       /* System.out.println(count++);
        for (int i = 0; i < 10; i++) {
            System.out.println((int) (Math.random() * (8000 - 2000)) +1000);

        }*/

        /*Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        reverseStack(stack);
        for (int i = 0, n = stack.size(); i < n; i++) {
            System.out.println(stack.elementAt(i));
        }
    }

    private static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;
        //remove the bottom element and put it on the top
        Integer bottom = popBottom(stack);
        reverseStack(stack);
        stack.push(bottom);

    }

    private static Integer popBottom(Stack<Integer> stack) {
        Integer top = stack.pop();
        if (stack.isEmpty()) {
            return top;
        }
        else{
            Integer bottom =popBottom(stack);
            stack.push(top);
            return bottom;
        }
    }*/
    }
}