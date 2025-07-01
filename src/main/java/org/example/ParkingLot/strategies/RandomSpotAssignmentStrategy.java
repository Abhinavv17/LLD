package org.example.ParkingLot.strategies;

import org.example.ParkingLot.models.*;
import org.example.ParkingLot.repositories.ParkingLotRepository;

import java.util.Optional;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{
    private ParkingLotRepository parkingLotRepository;

    public RandomSpotAssignmentStrategy(ParkingLotRepository parkingLotRepository){
        this.parkingLotRepository=parkingLotRepository;
    }
    @Override
    public ParkingSpot assignSpot(Gate gate, VehicleType vehicleType) {
        //findParkingLotByGateId
        Optional<ParkingLot> optionalParkingLot=parkingLotRepository.findByGateId(gate.getId());
        ParkingLot parkingLot=null;
        if (optionalParkingLot.isPresent()){
            parkingLot=optionalParkingLot.get();

        } else {
            //ToDO
            //throw ParkingLotNotFoundException
            
        }
        for (ParkingFloor parkingFloor :parkingLot.getParkingFloors()){
            for (ParkingSpot parkingSpot: parkingFloor.getParkingSpots()){
                if (parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY) &&
                        parkingSpot.getVehicleTypes().contains(vehicleType)){
                    return parkingSpot;
                }
            }

        }


        return null;
    }
}
