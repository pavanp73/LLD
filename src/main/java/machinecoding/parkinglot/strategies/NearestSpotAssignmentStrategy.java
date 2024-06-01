package machinecoding.parkinglot.strategies;

import machinecoding.parkinglot.models.ParkingLot;
import machinecoding.parkinglot.models.ParkingSpot;
import machinecoding.parkinglot.models.Vehicle;

public class NearestSpotAssignmentStrategy implements ParkingSpotAssignmentStrategy {

    @Override
    public ParkingSpot assignParkingSpot(ParkingLot parkingLot, Vehicle vehicle) {
        return new ParkingSpot();
    }
}
