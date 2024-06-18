package com.customquery2.customquery2.services;

import com.customquery2.customquery2.DAO.FlightDAO;
import com.customquery2.customquery2.entities.Flight;
import com.customquery2.customquery2.enums.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class FlightService {
    @Autowired
    private FlightDAO flightDAO;

    public List<Flight> createFlights(int n) {
        for(int i = 0; i<n; i++) {
            Flight newFlight = new Flight();
            newFlight.setDescription("Andata e Ritorno");
            newFlight.setFromAirport(generateRandomString());
            newFlight.setToAirport(generateRandomString());
            newFlight.setStatus(GenerateRandomStatus().toString());
            flightDAO.save(newFlight);
        }
        return flightDAO.findAll();
    }

    public String generateRandomString() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Palermo");
        stringList.add("Milano");
        stringList.add("Roma");
        stringList.add("Valencia");
        stringList.add("Bari");
        stringList.add("Verona");
        Random rand = new Random();
        int casuale = rand.nextInt(stringList.size());
        String randomString = stringList.get(casuale);
        return randomString;
    }
    private StatusEnum GenerateRandomStatus() {
        Random random = new Random();
        String[] statuses = {"ONTIME", "DELAYED", "CANCELLED"};
        return StatusEnum.valueOf(statuses[random.nextInt(statuses.length)]);
    }
    public List<Flight> searchAllFlights(){
        return flightDAO.findAllFlightOrderByFromAirport();

    }
    public List<Flight> serachByStatuses(String status1, String status2){
        return flightDAO.findFlightsByStatusEnum(status1, status2);
    }
    //a quanto pare non riesco a far funzionare la cosa apparentemente più semplice,non matcha con l'enum
    public List<Flight> searchWithoutQuery(){
        List<Flight> flightList = flightDAO.findAll();
        List<Flight> flightOnTime= new ArrayList<>();
        for(Flight flight : flightList){
            if(flight.getStatus().equals(StatusEnum.ONTIME.toString())){
                flightOnTime.add(flight);
            }
        }
        return flightOnTime;
    }
}
