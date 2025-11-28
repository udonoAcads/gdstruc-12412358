package com.gdstruc.stack_practice;

import java.util.EmptyStackException;

public class ArrayStack {

    private Player[] stack;
    private int top;

    public ArrayStack(int capacity)
    {
        stack = new Player[capacity];
    }

    public void push(Player player)
    {
        //For resizing the array for when it's full
        if (top == stack.length) //stack is full
        {
            Player[] newStack = new Player[stack.length * 2];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }

        stack[top++] = player;
    }

    public Player pop()
    {
        if (IsEmpty())
        {
            throw new EmptyStackException();
        }

        Player poppedPlayer = stack[--top];
        stack[top] = null;
        return poppedPlayer;
    }

    public Player peek()
    {
        if (IsEmpty())
        {
            throw new EmptyStackException();
        }

        return stack[top - 1];
    }

    public void PrintStack()
    {
        System.out.println("Printing Stack:");
        for (int i = top - 1; i >= 0; i--)
        {
            System.out.println(stack[i]);
        }
    }

    public boolean IsEmpty()
    {
        return top == 0;
    }

}
