package machinecoding.parkinglot.strategies;

import machinecoding.parkinglot.models.ParkingLot;
import machinecoding.parkinglot.models.ParkingSpot;
import machinecoding.parkinglot.models.Vehicle;

public interface ParkingSpotAssignmentStrategy {

    ParkingSpot assignParkingSpot(ParkingLot parkingLot, Vehicle vehicle);
}