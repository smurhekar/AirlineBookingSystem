package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 11/30/2015.
 */
public class Location {
    private final String name;
    private List<Location> neighbours;

    public Location(String name) {
        this.name = name;
        this.neighbours = new ArrayList<>();
    }

    public boolean reach(Location destination, List<Location> visitedLocations) {
        if(name.equalsIgnoreCase(destination.name)){
            return true;
        }
        for (Location neighbour : neighbours) {
            if(!visitedLocations.contains(neighbour)) {
                visitedLocations.add(neighbour);
                return neighbour.reach(destination, visitedLocations);
            }
        }
        return false;
    }

    public void connectTo(Location neighbour) {
        this.neighbours.add(neighbour);
    }
}
