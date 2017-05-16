package com.company.Model;

/**
 * Created by timme on 16.05.2017.
 */
public class Link {
    private Stop from ,to;
    private int time;

    public Link(Stop from, Stop to, int time)
    {
        this.from = from;
        this.to = to;

        this.time = time;
    }

    public Stop getFrom() {
        return from;
    }

    public Stop getTo() {
        return to;
    }
}
