package machinecoding.tictactoe.repositories;

import machinecoding.parkinglot.models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {

    // Gate table
    private Map<Long, Gate> gates = new HashMap<>();

    // CRUD operations on Gate table

    public Optional<Gate> findGateById(Long gateId) {
        return Optional.of(gates.get(gateId));
    }

}
