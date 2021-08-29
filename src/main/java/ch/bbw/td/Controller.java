package ch.bbw.td;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

/**
 * @author RiceDefender
 *
 */

public class Controller {
    @FXML
    TextField airport, begin, end;

    @FXML
    ListView<String> view;

    FlightDAO flightDAO = new FlightDAO();

    @FXML
    public void allflights(){
        view.getItems().add(flightDAO.getAllStates().toString());
    }

    @FXML
    public void flightsintime(){
        for (Flighttimeplane f: flightDAO.getFlight(begin.getText(),end.getText()))
        view.getItems().add(f.toString());
    }

    @FXML
    public void flightairport(){
        for (FlightfromAirport f: flightDAO.getFlightAirport(airport.getText(), begin.getText(), end.getText())){
            view.getItems().add(f.toString());
        }

    }

}
