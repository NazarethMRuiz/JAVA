package com.ejparteuno.demo.Service;

import com.ejparteuno.demo.exception.ResourceNotFoundException;
import com.ejparteuno.demo.Model.Airport;
import com.ejparteuno.demo.Repository.AirportRepository;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class AirportServiceImpl implements AirportService {
    @Autowired
    private AirportRepository airportRepository;

    @Override
    public Airport createAirport(Airport airport) {

        return airportRepository.save(airport);
    }

    @Override
    public Airport updateAirport(Airport airport) {
        Optional<Airport> airportDb = this.airportRepository.findById(airport.getId_airport());
        if (airportDb.isPresent()){
            Airport airportUpdate = airportDb.get();
            airportUpdate.setId_airport(airport.getId_airport());
            airportUpdate.setCode(airport.getCode());
            airportUpdate.setName(airport.getName());
            airportRepository.save(airportUpdate);
            return airportUpdate;
        }else {
            throw new ResourceNotFoundException("Record not found with id : " + airport.getId_airport());
        }
    }

    @Override
    public List<Airport> getAllAirports() {
        return this.airportRepository.findAll();
    }

    @Override
    public Airport getAirportById(long airportId) {
        Optional<Airport> airportDb = this.airportRepository.findById(airportId);

        if (airportDb.isPresent()) {
            return airportDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + airportId);
        }
    }

    @Override
    public void deleteAirport(long airportId) {
        Optional<Airport> airportDb = this.airportRepository.findById(airportId);

        if (airportDb.isPresent()) {
            this.airportRepository.delete(airportDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + airportId);
        }
    }

}
