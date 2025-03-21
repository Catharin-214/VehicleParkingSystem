package com.parking.controller;

import com.parking.dao.VehicleDAO;
import com.parking.model.Vehicle;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleDAO vehicleDAO = new VehicleDAO();

    @PostMapping("/add")
    public String addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleDAO.addVehicle(vehicle) ? "Vehicle Added Successfully" : "Error Adding Vehicle";
    }

    @GetMapping("/all")
    public List<Vehicle> getAllVehicles() {
        return vehicleDAO.getAllVehicles();
    }
}
