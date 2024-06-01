package machinecoding.tictactoe.controllers;

import machinecoding.parkinglot.dtos.IssueTicketRequestDto;
import machinecoding.parkinglot.dtos.IssueTicketResponseDto;
import machinecoding.parkinglot.dtos.ResponseStatus;
import machinecoding.parkinglot.exceptions.GateNotFoundException;
import machinecoding.parkinglot.models.Ticket;
import machinecoding.parkinglot.models.Vehicle;
import machinecoding.tictactoe.services.TicketService;

public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto issueTicketRequestDto) {
        IssueTicketResponseDto issueTicketResponseDto = new IssueTicketResponseDto();

        try {
            Ticket ticket =  ticketService.issueTicket(
                    issueTicketRequestDto.getVehicleNumber(),
                    issueTicketRequestDto.getOwnerName(),
                    issueTicketRequestDto.getGateId(),
                    issueTicketRequestDto.getOperatorId()
            );
            issueTicketResponseDto.setTicket(ticket);
            issueTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (GateNotFoundException | Exception e) {
            issueTicketResponseDto.setResponseStatus(ResponseStatus.FAIL);
        }

        return issueTicketResponseDto;
    }
}
