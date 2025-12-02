package com.gdstruc.quiz6;

public class Tree
{
    private Node root;

    public void insert(int value)
    {
        if (root == null)
        {
            root = new Node(value);
        }
        else
        {
            root.insert(value);
        }
    }

    public void traverseInOrder()
    {
        if (root != null)
        {
            root.traverseInOrder();
        }
        else
        {
            System.out.println("There are no nodes to traverse to.");
        }
    }

    public void traverseInOrderDescending()
    {
        if (root != null)
        {
            root.traverseInOrderDescending();
        }
        else
        {
            System.out.println("There are no nodes to traverse to.");
        }
    }

    public Node get(int value)
    {
        if (root != null)
        {
            return root.get(value);
        }
        else
        {
            System.out.println("There are no nodes to get values from.");
        }

        return null;
    }

    public Node getMin()
    {
        if (root != null)
        {
            return root.getMin();
        }

        System.out.println("There is no min value in this tree.");
        return null;
    }

    public Node getMax()
    {
        if (root != null)
        {
            return root.getMax();
        }

        System.out.println("There is no max value in this tree.");
        return null;
    }
}
