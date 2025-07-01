package org.example;

import org.example.ParkingLot.controllers.TicketController;
import org.example.ParkingLot.dtos.IssueTicketRequestDto;
import org.example.ParkingLot.dtos.IssueTicketResponseDto;
import org.example.ParkingLot.dtos.ResponseStatus;
import org.example.ParkingLot.models.Gate;
import org.example.ParkingLot.models.Operator;
import org.example.ParkingLot.models.Ticket;
import org.example.ParkingLot.models.VehicleType;
import org.example.ParkingLot.repositories.GateRepository;
import org.example.ParkingLot.repositories.ParkingLotRepository;
import org.example.ParkingLot.repositories.TicketRepository;
import org.example.ParkingLot.repositories.VehicleRepository;
import org.example.ParkingLot.services.TicketService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        TicketRepository ticketRepository = new TicketRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();

        Gate gate=new Gate();
        gate.setId(123L);
        gate.setGateNumber(1);
        Operator operator=new Operator();
        operator.setName("Stark guard");

        gate.setCurrentOperator(operator);
        gateRepository.addGate(gate);

        TicketService ticketService = new TicketService(
                gateRepository, vehicleRepository, parkingLotRepository, ticketRepository);


        TicketController ticketController = new TicketController(ticketService);

        IssueTicketRequestDto requestDto= new IssueTicketRequestDto();
        requestDto.setGateID(123l);
        requestDto.setVehicleNumber("BR12345");
        requestDto.setVehicleOwnerName("Stark");
        requestDto.setVehicleType(VehicleType.SUV);



        Ticket ticket=null;
        IssueTicketResponseDto responseDto=ticketController.issueTicket(requestDto);
        if (responseDto.getResponseStatus().equals(ResponseStatus.SUCCESS)){
            ticket=responseDto.getTicket();
            System.out.println("Ticked issued"+ticket);

        }else {
            System.out.println("Issue ticket method failed for some reason");
        }
    }
}