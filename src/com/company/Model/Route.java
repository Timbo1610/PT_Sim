package com.company.Model;

/**
 * Created by timme on 16.05.2017.
 */
public class Route {
    private Line line;
    private Vehicle vehicle;
    private int startTime;
    private Stop startBusStop;

    public Route(Line line,Stop startBusStop, int startTime)
    {
        this.line = line;
        this.startBusStop = startBusStop;
        this.startTime = startTime;
    }


}
