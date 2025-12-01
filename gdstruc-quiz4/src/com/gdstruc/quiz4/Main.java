package com.gdstruc.quiz4;

public class Main {
    public static void main(String[] args) {

        Player ploo = new Player(1, "Plooful", 1);
        Player wardell = new Player(2, "TSM Wardell", 10);
        Player deadlyJimmy = new Player(3, "DeadlyJimmy", 100);
        Player subroza = new Player(4, "Subroza", 1000);
        Player annieDro = new Player(4, "C9 Annie", 1000);

        Player mitsunori = new Player(1, "Mitsunori", 1);

        SimpleHashtable hashtable = new SimpleHashtable();

        hashtable.put(ploo.GetUsername(), ploo);
        hashtable.put(wardell.GetUsername(), wardell);
        hashtable.put(deadlyJimmy.GetUsername(), deadlyJimmy);
        hashtable.put(subroza.GetUsername(), subroza);
        hashtable.put(annieDro.GetUsername(), annieDro);
        hashtable.put(mitsunori.GetUsername(), mitsunori);

        //Get an element
        System.out.println(hashtable.get("Subroza"));

        //Print the removed element
        System.out.println(hashtable.remove("Subroza"));

        //Attempt to remove the same element again
        System.out.println(hashtable.remove("Subroza"));
    }
}