package com.parking.model;

public class Vehicle {
    private int vehicleID;
    private String licensePlate;
    private String vehicleType;
    private String ownerName;
    private String contactNumber;

    // Constructor
    public Vehicle(int vehicleID, String licensePlate, String vehicleType, String ownerName, String contactNumber) {
        this.vehicleID = vehicleID;
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.ownerName = ownerName;
        this.contactNumber = contactNumber;
    }

    // Getters and Setters
    public int getVehicleID() { return vehicleID; }
    public void setVehicleID(int vehicleID) { this.vehicleID = vehicleID; }

    public String getLicensePlate() { return licensePlate; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }

    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
}

