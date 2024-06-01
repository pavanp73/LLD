package machinecoding.parkinglot.services;

import machinecoding.parkinglot.exceptions.GateNotFoundException;
import machinecoding.parkinglot.models.*;
import machinecoding.parkinglot.repositories.GateRepository;
import machinecoding.parkinglot.repositories.VehicleRepository;
import machinecoding.parkinglot.strategies.ParkingSpotAssignmentStrategy;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

public class TicketService {

    private final GateRepository gateRepository;
    private final VehicleRepository vehicleRepository;
    private final ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy;

    public TicketService(GateRepository gateRepository,
                         VehicleRepository vehicleRepository,
                         ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingSpotAssignmentStrategy = parkingSpotAssignmentStrategy;
    }

    public Ticket issueTicket(String vehicleNumber,
                              VehicleType vehicleType,
                              String ownerName,
                              Long gateId,
                              Long operatorId) throws GateNotFoundException {
        Ticket ticket = new Ticket();
        // get gate object
        Optional<Gate> optionalGate = gateRepository.findGateById(gateId);
        if (optionalGate.isEmpty()) {
            throw new GateNotFoundException("Invalid gate Id passed");
        }
        Gate gate = optionalGate.get();
        ticket.setGate(gate);
        ticket.setOperator(gate.getOperator());

        Optional<Vehicle> optionalVehicle = vehicleRepository.findVehicleByNumber(vehicleNumber);
        Vehicle vehicle;
        if (optionalVehicle.isEmpty()) {
            // Vehicle is not present in DB
            // Create a new Vehicle and save in the DB
            vehicle = new Vehicle();
            vehicle.setNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle.setOwnerName(ownerName);
            vehicle = vehicleRepository.save(vehicle);
        } else {
            vehicle = optionalVehicle.get();
        }
        ticket.setVehicle(vehicle);

        ParkingLot parkingLot = gate.getParkingLot();
        ticket.setParkingSpot(parkingSpotAssignmentStrategy.assignParkingSpot(parkingLot, vehicle));
        Date currentDate = new Date();
        ticket.setEntryTime(currentDate);
        ticket.setCreatedAt(currentDate);
        ticket.setUpdatedAt(currentDate);

        return ticket;
    }
}
