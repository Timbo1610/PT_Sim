package com.company.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by timme on 16.05.2017.
 */
public class Line {
    private String name;

    Map<String, Stop> stopList = new HashMap<>();

    public Line(String name)
    {
        this.name = name;
    }

    public Map<String, Stop> getStopList() {
        return stopList;
    }

    public Stop getStop(String stop)
    {
        return stopList.get(stop);
    }

    public void addStop(Stop stop)
    {
       stopList.put(stop.getName(),stop);
    }

    public String getName() {
        return name;
    }
}
