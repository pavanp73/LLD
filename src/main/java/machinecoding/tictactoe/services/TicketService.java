package machinecoding.tictactoe.services;

import machinecoding.parkinglot.exceptions.GateNotFoundException;
import machinecoding.parkinglot.models.Gate;
import machinecoding.parkinglot.models.Ticket;
import machinecoding.tictactoe.repositories.GateRepository;

import java.util.Optional;

public class TicketService {

    private final GateRepository gateRepository;

    public TicketService(GateRepository gateRepository) {
        this.gateRepository = gateRepository;
    }

    public Ticket issueTicket(String vehicleNumber,
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





        return null;
    }
}
