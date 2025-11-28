package com.gdstruc.stack_practice;

public class Main {
    public static void main(String[] args)
    {

        ArrayStack stack = new ArrayStack(5);

        stack.push(new Player(1, "Will", 1));
        stack.push(new Player(2, "Soleil", 10));
        stack.push(new Player(3, "Felix", 100));
        stack.push(new Player(4, "Kai", 1000));

        stack.PrintStack();

        System.out.println(stack.pop());


    }
}