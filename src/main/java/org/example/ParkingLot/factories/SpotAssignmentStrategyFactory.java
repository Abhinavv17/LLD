package org.example.ParkingLot.factories;

import org.example.ParkingLot.models.SpotAsssignmentStrategyType;
import org.example.ParkingLot.repositories.ParkingLotRepository;
import org.example.ParkingLot.strategies.CheapestSpotAssignmentStrategy;
import org.example.ParkingLot.strategies.RandomSpotAssignmentStrategy;
import org.example.ParkingLot.strategies.SpotAssignmentStrategy;

public class SpotAssignmentStrategyFactory {
    //This is the factory to create the right Strategy for the user.

    public static SpotAssignmentStrategy getSpotAssignmentStrategy(
            SpotAsssignmentStrategyType spotAsssignmentStrategyType, ParkingLotRepository parkingLotRepository){
        if (spotAsssignmentStrategyType.equals(SpotAsssignmentStrategyType.RANDOM)){
            return new RandomSpotAssignmentStrategy(parkingLotRepository);
        } else if (spotAsssignmentStrategyType.equals(SpotAsssignmentStrategyType.CHEAPEST)) {
            return new CheapestSpotAssignmentStrategy();
            
        }
        return null;
    }
}
