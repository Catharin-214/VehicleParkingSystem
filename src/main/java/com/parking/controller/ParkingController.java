package com.parking.controller;

import com.parking.model.ParkingSlot;
import com.parking.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
@CrossOrigin(origins = "*") // Allow frontend access
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    // Get available parking slots
    @GetMapping("/slots")
    public List<ParkingSlot> getAvailableSlots() {
        return parkingService.getAvailableSlots();
    }

    // Park a vehicle in an available slot
    @PostMapping("/park/{vehicleId}/{slotId}")
    public String parkVehicle(@PathVariable int vehicleId, @PathVariable int slotId) {
        return parkingService.parkVehicle(vehicleId, slotId);
    }
}
