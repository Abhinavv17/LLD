package org.example.ParkingLot.repositories;

import org.example.ParkingLot.models.ParkingLot;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ParkingLotRepository {
    private Map<Long, ParkingLot> parkingLotMap=new HashMap<>();

    public Optional<ParkingLot> findByGateId(Long id){
        if (parkingLotMap.containsKey(id)){
            return Optional.of(parkingLotMap.get(id));
        } else {
            return Optional.empty();
        }

    }
}
