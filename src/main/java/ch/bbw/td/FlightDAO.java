package ch.bbw.td;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author RiceDefender
 *
 */

public class FlightDAO {


    //Kann lange andauern, da ein array mit ca. 4450Arrays geruffen wird
    public Flight getAllStates() {
        Flight flight = null;
        try {
            StringBuilder url = new StringBuilder("https://opensky-network.org/api/states/all");
            HttpURLConnection conn = (HttpURLConnection) new URL(url.toString()).openConnection();
            int respCode = conn.getResponseCode();
            if (respCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                Gson gson = new Gson();
                flight = gson.fromJson(reader, Flight.class);
            } else {
                System.err.println("Response Problem:" + conn);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flight;
    }

    //test epoch Begin = 1624176000, End = 1624183200
    public Flighttimeplane[] getFlight(String begin, String end) {
        Flighttimeplane[] flight = null;
        try {   //Date in epoch
            StringBuilder url = new StringBuilder("https://opensky-network.org/api/flights/all?begin="+begin+"&end="+end);
            HttpURLConnection conn = (HttpURLConnection) new URL(url.toString()).openConnection();
            int respCode = conn.getResponseCode();
            if (respCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                Gson gson = new Gson();
                flight = gson.fromJson(reader, Flighttimeplane[].class);
            } else {
                System.err.println("Response Problem:" + conn);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flight;
    }

    //test data ICAO = LSZH, Begin = 1624176000, End = 1624722289
    public FlightfromAirport[] getFlightAirport(String icao, String begin, String end){
        FlightfromAirport[] flight = null;
        try {   //Date in epoch Airport in ICAO not in IATA Zurich airport ICAO = LSZH, IATA =ZRH
            StringBuilder url = new StringBuilder("https://opensky-network.org/api/flights/departure?airport="+icao+"&begin="+begin+"&end="+end);
            HttpURLConnection conn = (HttpURLConnection) new URL(url.toString()).openConnection();
            int respCode = conn.getResponseCode();
            if (respCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                Gson gson = new Gson();
                flight = gson.fromJson(reader, FlightfromAirport[].class);
            } else {
                System.err.println("Response Problem:" + conn);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flight;
    }
}
