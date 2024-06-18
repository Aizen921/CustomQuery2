package com.customquery2.customquery2.controllers;

import com.customquery2.customquery2.entities.Flight;
import com.customquery2.customquery2.enums.StatusEnum;
import com.customquery2.customquery2.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;
    @PostMapping("/")
    public ResponseEntity<List<Flight>> addFlight(@RequestParam int numberOfFlights){
        List<Flight> newFlights = flightService.createFlights(numberOfFlights);
        return ResponseEntity.status(HttpStatus.CREATED).body(newFlights);
    }
    @GetMapping("/list")
    public List<Flight> getAllFlight(){
        return flightService.searchAllFlights();
    }
    @GetMapping("list/statuses")
    public List<Flight> getFlightsByStatuses(@RequestParam String status1, @RequestParam String status2){
        return flightService.serachByStatuses(status1, status2);
    }
    @GetMapping("/ontime")
    public List<Flight> getFlightOnTime(){
        return flightService.searchWithoutQuery();
    }
}