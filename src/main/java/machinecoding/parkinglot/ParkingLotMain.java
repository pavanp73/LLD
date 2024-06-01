package machinecoding.parkinglot;

import machinecoding.parkinglot.controllers.TicketController;
import machinecoding.parkinglot.dtos.IssueTicketRequestDto;
import machinecoding.parkinglot.dtos.IssueTicketResponseDto;
import machinecoding.parkinglot.factories.ParkingSpotAssignmentFactory;
import machinecoding.parkinglot.models.ParkingSpotStrategyType;
import machinecoding.parkinglot.models.VehicleType;
import machinecoding.parkinglot.repositories.GateRepository;
import machinecoding.parkinglot.repositories.VehicleRepository;
import machinecoding.parkinglot.services.TicketService;
import machinecoding.parkinglot.strategies.ParkingSpotAssignmentStrategy;

public class ParkingLotMain {

    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy =
                ParkingSpotAssignmentFactory.getParkingLotStrategy(ParkingSpotStrategyType.NEAREST);

        TicketService ticketService = new TicketService(
                gateRepository,
                vehicleRepository,
                parkingSpotAssignmentStrategy
        );
        TicketController ticketController = new TicketController(ticketService);

        IssueTicketRequestDto requestDto = new IssueTicketRequestDto();
        requestDto.setGateId(123L);
        requestDto.setVehicleNumber("KA01X1234");
        requestDto.setOwnerName("Pavan");
        requestDto.setOperatorId(34L);
        requestDto.setVehicleType(VehicleType.HATCHBACK);

        IssueTicketResponseDto responseDto = ticketController.issueTicket(requestDto);
        System.out.println("Ticket = " + responseDto.getTicket());
    }
}
