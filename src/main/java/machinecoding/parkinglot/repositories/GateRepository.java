package machinecoding.parkinglot.repositories;

import machinecoding.parkinglot.models.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {

    // Gate table
    private Map<Long, Gate> gates = new HashMap<>();

    // CRUD operations on Gate table

    public Optional<Gate> findGateById(Long gateId) {
        Gate gate = new Gate();
        gate.setGateType(GateType.ENTRY);
        gate.setParkingLot(new ParkingLot());
        gate.setGateStatus(GateStatus.OPEN);
        gate.setGateNumber(1);
        gate.setId(123L);
        gate.setOperator(new Operator());
        gates.put(123L, gate);
        return Optional.of(gates.get(gateId));
    }

}
