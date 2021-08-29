package ch.bbw.td;

import java.util.List;

/**
 * @author RiceDefender
 */

public class Flight {

    Integer time;
    List<List<String>> states;


    @Override
    public String toString() {
        return "Flight{" +
                "time=" + time +
                ", states=" + states +
                '}';
    }
}
