package com.company.Model;

import java.util.ArrayList;

/**
 * Created by timme on 16.05.2017.
 */
public class Stop {
    ArrayList<Link> links = new ArrayList<>();
    String name;

    public Stop(String name)
    {
        this.name = name;
    }

    public ArrayList<Link> getLinks() {
        return links;
    }

    public String getName() {
        return name;
    }
}
