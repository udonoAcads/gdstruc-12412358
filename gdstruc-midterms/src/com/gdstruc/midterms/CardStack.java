package com.gdstruc.midterms;

import java.util.LinkedList;
import java.util.EmptyStackException;

public class CardStack
{
    private String name;
    private Card[] cardStack;
    private int top; // Top in this case will refer to the next element to the last instead of the last element itself.

    CardStack(String name)
    {
        this.name = name;
        cardStack = new Card[30];
        top = 0;
    }

    public void FillStack()
    {
        for (int i = 0; i < cardStack.length; i++)
        {
            cardStack[i] = new Card(i + 1);
        }

        top = cardStack.length;
    }

    public void Push(Card card)
    {
        //No need to check for stack overflow as there can only be 30 instantiated cards for this quiz
        cardStack[top++] = card;
    }

    public Card Pop()
    {
        if (IsEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            Card poppedCard = cardStack[--top];
            cardStack[top] = null;
            return poppedCard;
        }

    }

    public LinkedList<Card> PopBatch(int count)
    {
        LinkedList<Card> cardBatch = new LinkedList<Card>();

        for (int i = 0; i < count; i++)
        {
            try
            {
                cardBatch.push(Pop());
            }
            catch(Exception e)
            {

                if (i == 0)
                {
                    System.out.println("No more cards in " + name + "!");
                }

                break;
            }
        }

        return cardBatch;
    }

    public Card Peek()
    {
        if (IsEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            return cardStack[top - 1];
        }

    }

    public boolean IsEmpty()
    {
        return top == 0;
    }

    public void PrintCount()
    {

        if (IsEmpty())
        {
            System.out.println(name + " is empty!");
        }
        else
        {
            System.out.println("Current number of cards in " + name + ": " + (top));
        }
    }

    public void PrintStack()
    {
        System.out.println("Current cards in " + name + ": \n");

        if (IsEmpty())
        {
            System.out.println("None.");
            return;
        }

        for (int i = top - 1; i >= 0; i--)
        {
            System.out.println(cardStack[i]);
        }
    }


}
