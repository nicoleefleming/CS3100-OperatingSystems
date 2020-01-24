package main.java;

import java.lang.*;
import java.util.*;
import java.io.*;
import java.math.*;
import java.time.*;

public class Main {

    static void main(String[] args)
    {
        //create instances of ResultTable, TaskQueue
        ResultTable resultTable = new ResultTable();
        TaskQueue taskQueue = new TaskQueue();
        ArrayList<Thread> threading = new ArrayList<>();
        long duration = System.currentTimeMillis();

        for(int i = 0; i < Runtime.getRuntime().availableProcessors(); i++)
        {
            Thread myThread = new Thread(new WorkerThread(taskQueue, resultTable));
            threading.add(myThread);
            myThread.start();
        }
        for(int j = 0; j < threading.size(); j++)
        {
            try {
                threading.get(j).join();
            }catch(InterruptedException ie){
                System.out.println("Interrupted Exception");
            }
        }
        resultTable.display();
        duration = System.currentTimeMillis() - duration;
        System.out.println("Computing pi -> " + duration + " ms");
    }
}
