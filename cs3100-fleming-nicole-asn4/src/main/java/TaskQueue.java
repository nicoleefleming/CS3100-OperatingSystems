package main.java;

import java.lang.*;
import java.util.*;
import java.io.*;
import java.math.*;
import java.time.*;


public class TaskQueue extends ResultTable
{
    private LinkedList<Integer> tasks = new LinkedList<>(); //TODO WHEN IN USE, PROTECT AGAINST RACE CONDITIONS

    public TaskQueue()
    {
        this.setQueue(1000);
    }

    public synchronized void setQueue(int n)
    {
        ArrayList<Integer> randomNum = new ArrayList<>(n);

        //Get the 1000 tasks added into the ArrayList
        for (int index = 0; index < n; index++)
        {
            randomNum.add(index);
        }
        //Randomize the numbers in ArrayList
        Collections.shuffle(randomNum);
        //Add the random numbers from the ArrayList into the Queue
        for (int pos = 0; pos < n; pos++)
        {
            Integer temp = randomNum.get(pos);
            tasks.add(temp);
            System.out.println(temp);
        }
    }

    public synchronized int pop() {

        return tasks.pop();
    }

    public boolean isEmpty(){
        return tasks.isEmpty();
    }
}
