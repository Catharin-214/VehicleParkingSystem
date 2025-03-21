package com.parking.service;

import com.parking.model.ParkingSlot;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingService {
    private final List<ParkingSlot> parkingSlots = new ArrayList<>();

    // Constructor - Initialize some sample slots
    public ParkingService() {
        parkingSlots.add(new ParkingSlot(1, "A1", "Car", "Available"));
        parkingSlots.add(new ParkingSlot(2, "A2", "Bike", "Occupied"));
    }

    // Get available slots
    public List<ParkingSlot> getAvailableSlots() {
        List<ParkingSlot> available = new ArrayList<>();
        for (ParkingSlot slot : parkingSlots) {
            if ("Available".equals(slot.getStatus())) {
                available.add(slot);
            }
        }
        return available;
    }

    // Park a vehicle
    public String parkVehicle(int vehicleId, int slotId) {
        for (ParkingSlot slot : parkingSlots) {
            if (slot.getSlotID() == slotId && "Available".equals(slot.getStatus())) {
                slot.setStatus("Occupied");
                return "Vehicle parked successfully in slot " + slot.getSlotNumber();
            }
        }
        return "No available slot found!";
    }
}
