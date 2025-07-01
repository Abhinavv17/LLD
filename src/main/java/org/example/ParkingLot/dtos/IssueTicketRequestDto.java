package org.example.ParkingLot.dtos;

import org.example.ParkingLot.models.Gate;
import org.example.ParkingLot.models.VehicleType;

public class IssueTicketRequestDto {
    private String VehicleNumber;
    private VehicleType vehicleType;
    private String vehicleOwnerName;
    private Long gateID;

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleOwnerName() {
        return vehicleOwnerName;
    }

    public void setVehicleOwnerName(String vehicleOwnerName) {
        this.vehicleOwnerName = vehicleOwnerName;
    }

    public Long getGateID() {
        return gateID;
    }

    public void setGateID(Long gateID) {
        this.gateID = gateID;
    }
}
