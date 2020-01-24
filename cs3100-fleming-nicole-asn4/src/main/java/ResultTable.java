package main.java;

import java.lang.*;
import java.util.*;
import java.io.*;
import java.math.*;
import java.time.*;


public class ResultTable
{
    //private ResultTable rt = new ResultTable();
    private Hashtable<Integer, Integer> results = new Hashtable<>();
    //put wouldn't work so added add method
    public synchronized void add(int key, int value)
    {
        this.results.put(key, value);
    }

    public void display()
    {
        System.out.println();
        System.out.println("3.");
        for (int i = 0; i < 1000; i++)
        {
            System.out.println(this.results.get(i));
        }
    }

    public synchronized void printPeriod()
    {
        if((this.results.size())%10 == 0)
        {
            System.out.println(" . ");
        }
        if((this.results.size())%250 == 0)
        {
            System.out.println();
        }
        System.out.flush();
    }
}
