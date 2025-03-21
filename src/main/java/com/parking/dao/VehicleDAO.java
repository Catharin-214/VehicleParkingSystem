package com.parking.dao;

import com.parking.database.DatabaseConnection;
import com.parking.model.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {
    public boolean addVehicle(Vehicle vehicle) {
        String query = "INSERT INTO Vehicle (LicensePlate, VehicleType, OwnerName, ContactNumber) VALUES (?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.connect();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, vehicle.getLicensePlate());
            ps.setString(2, vehicle.getVehicleType());
            ps.setString(3, vehicle.getOwnerName());
            ps.setString(4, vehicle.getContactNumber());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT * FROM Vehicle";
        try (Connection con = DatabaseConnection.connect();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                vehicles.add(new Vehicle(
                        rs.getInt("VehicleID"),
                        rs.getString("LicensePlate"),
                        rs.getString("VehicleType"),
                        rs.getString("OwnerName"),
                        rs.getString("ContactNumber")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }
}
