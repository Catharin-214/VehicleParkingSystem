package com.parking.model;

public class ParkingSlot {
    private int slotID;
    private String slotNumber;
    private String slotType;
    private String status; // 'Occupied' or 'Available'

    // Constructor
    public ParkingSlot(int slotID, String slotNumber, String slotType, String status) {
        this.slotID = slotID;
        this.slotNumber = slotNumber;
        this.slotType = slotType;
        this.status = status;
    }

    // Getters and Setters
    public int getSlotID() { return slotID; }
    public void setSlotID(int slotID) { this.slotID = slotID; }

    public String getSlotNumber() { return slotNumber; }
    public void setSlotNumber(String slotNumber) { this.slotNumber = slotNumber; }

    public String getSlotType() { return slotType; }
    public void setSlotType(String slotType) { this.slotType = slotType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
