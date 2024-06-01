package machinecoding.parkinglot.factories;

import machinecoding.parkinglot.models.ParkingSpotStrategyType;
import machinecoding.parkinglot.strategies.NearestSpotAssignmentStrategy;
import machinecoding.parkinglot.strategies.ParkingSpotAssignmentStrategy;

public class ParkingSpotAssignmentFactory {

    public static ParkingSpotAssignmentStrategy getParkingLotStrategy(ParkingSpotStrategyType parkingSpotStrategyType) {
        if (parkingSpotStrategyType.equals(ParkingSpotStrategyType.NEAREST)) {
            return new NearestSpotAssignmentStrategy();
        }
        return null;
    }
}
