package com.customquery2.customquery2.DAO;

import com.customquery2.customquery2.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightDAO extends JpaRepository<Flight, Long> {
    @Query("SELECT f FROM Flight f ORDER BY fromAirport")
    List<Flight> findAllFlightOrderByFromAirport();
    @Query("SELECT f FROM Flight f WHERE f.status = :status1 OR f.status = :status2")
    List<Flight> findFlightsByStatusEnum(String status1, String status2);
}
