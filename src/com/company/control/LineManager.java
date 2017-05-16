package com.company.control;

import com.company.Model.Line;
import com.company.Model.Link;
import com.company.Model.Stop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * Created by timme on 16.05.2017.
 */
public class LineManager {

    ArrayList<Line> lineList = new ArrayList<>();
    Map<String, Stop> stopList = new HashMap<>();

    public LineManager()
    {

        File folder = new File("res\\lines\\");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                //System.out.println(file.getName());
                Line templine = new Line(file.getName().substring(0,file.getName().length()-4));
                lineList.add(templine);
                readStopfromTxt(file,templine);
            }
        }


        //showLine("Duckwitzstr");
    }

    public void printLines()
    {
        for (Line line: lineList)
        {
            System.out.println(line.getName());
            for (Map.Entry<String, Stop> stop : line.getStopList().entrySet())
            {
                System.out.print( " " +stop.getValue().getName());
            }
            System.out.println();
        }
    }


    private  void readStopfromTxt(File file, Line line)
    {


        String txtline;
        Stop lastStop = null;
        try {
            Scanner fileIn = new Scanner(file);

            while(fileIn.hasNext())
            {
               txtline = fileIn.nextLine();
               String name = txtline.split(";")[0];

               Stop tempstop = getStop(name);
               line.getStopList().put(name,tempstop);

               if(lastStop != null)
               {
                   Link link = findLink(lastStop,tempstop);
                   if(!lastStop.getLinks().contains(link))
                       lastStop.getLinks().add(link);

                   if(!tempstop.getLinks().contains(link))
                        tempstop.getLinks().add(link);
               }
               lastStop = tempstop;



              // System.out.println(tempstop.getName());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Link findLink(Stop from, Stop to)
    {
        for(Link link:from.getLinks())
        {
            if(link.getTo().equals(to))
                return link;
        }
        return new Link(from,to,2);

    }

    private Stop getStop(String name)
    {
        if(stopList.containsKey(name))
        {
            return stopList.get(name);
        }
        else
        {
            Stop tempStop = new Stop(name);
            stopList.put(name,tempStop);
            return tempStop;
        }
    }

    public void showLine(String from)
    {
        iterate(stopList.get(from),new ArrayList<Stop>(),0,"    ");
        System.out.println(output);


    }

    String output = "";
    public void iterate(Stop stop,ArrayList<Stop> visited,int heat,String spacing)
    {
        int count = 0;

        System.out.println(stop.getName());
        for(Link link:stop.getLinks()) {
            if(!stop.equals(link.getTo()))
                System.out.println("    |-> " + link.getTo().getName());
        }



        for(Link link:stop.getLinks())
        {

            if (!visited.contains(link.getTo())) {
                visited.add(link.getTo());
                iterate(link.getTo(),visited, new Integer(heat + 1), new String(spacing));
            }
        }
    }

    public ArrayList<Line> getLineList() {
        return lineList;
    }
}
