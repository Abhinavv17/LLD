package org.example.ParkingLot.models;

import java.util.List;

public class ParkingLot extends BaseModel{
    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;
    private ParkingLotStatus parkingLotStatus;
    private FeesCalculationStrategyType feesCalculationStrategyType;
    private SpotAsssignmentStrategyType spotAsssignmentStrategyType;

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public FeesCalculationStrategyType getFeesCalculationStrategyType() {
        return feesCalculationStrategyType;
    }

    public void setFeesCalculationStrategyType(FeesCalculationStrategyType feesCalculationStrategyType) {
        this.feesCalculationStrategyType = feesCalculationStrategyType;
    }

    public SpotAsssignmentStrategyType getSpotAsssignmentStrategyType() {
        return spotAsssignmentStrategyType;
    }

    public void setSpotAsssignmentStrategyType(SpotAsssignmentStrategyType spotAsssignmentStrategyType) {
        this.spotAsssignmentStrategyType = spotAsssignmentStrategyType;
    }
}
