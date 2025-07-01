package org.example.ParkingLot.controllers;

import org.example.ParkingLot.dtos.IssueTicketRequestDto;
import org.example.ParkingLot.dtos.IssueTicketResponseDto;
import org.example.ParkingLot.dtos.ResponseStatus;
import org.example.ParkingLot.models.Ticket;
import org.example.ParkingLot.services.TicketService;

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;

    }
    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto requestDto){
        IssueTicketResponseDto responseDto=new IssueTicketResponseDto();

        try {
            Ticket ticket=ticketService.issueTicket(requestDto.getGateID(),
                    requestDto.getVehicleOwnerName(),
                    requestDto.getVehicleType(),
                    requestDto.getVehicleNumber());

            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            responseDto.setTicket(ticket);
        } catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            //System.out.println("Exception while issuing ticket" + e.getMessage());
        }

        return responseDto;

    }
}
