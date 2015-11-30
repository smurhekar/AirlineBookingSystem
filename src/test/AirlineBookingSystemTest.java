package test;

import main.Location;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lenovo on 11/30/2015.
 */
public class AirlineBookingSystemTest {

    @Test
    public void canReachOutToOurself(){
        Location mumbai = new Location("Mumbai");
        List<Location> visitedLocations = new ArrayList<>();
        assertEquals(true, mumbai.reach(new Location("Mumbai"), visitedLocations));
    }

    @Test
    public void canReachOutToNeighbours(){
        Location mumbai = new Location("Mumbai");
        Location pune = new Location("Pune");
        mumbai.connectTo(pune);
        List<Location> visitedLocations = new ArrayList<>();
        assertEquals(true, mumbai.reach(pune, visitedLocations));
    }

    @Test
    public void canReachOutToNeighboursNeighbour(){
        Location mumbai = new Location("Mumbai");
        Location pune = new Location("Pune");
        Location nagpur = new Location("Nagpur");
        mumbai.connectTo(pune);
        pune.connectTo(nagpur);
        List<Location> visitedLocations = new ArrayList<>();
        assertEquals(true, mumbai.reach(nagpur, visitedLocations));
    }

    @Test
    public void canAvoidCyclicMess(){
        Location mumbai = new Location("Mumbai");
        Location pune = new Location("Pune");
        Location nagpur = new Location("Nagpur");
        mumbai.connectTo(pune);
        pune.connectTo(mumbai);
        List<Location> visitedLocations = new ArrayList<>();
        assertEquals(false, mumbai.reach(nagpur, visitedLocations));
    }
}
