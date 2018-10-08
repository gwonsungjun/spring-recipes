package ch09.com.springrecipes.dao;

import ch09.com.springrecipes.domin.Vehicle;

import java.util.List;

public interface VehicleDao {
    void insert(Vehicle vehicle);

    void insert(Iterable<Vehicle> vehicles);

    void update(Vehicle vehicle);

    void delete(Vehicle vehicle);

    Vehicle findByVehicleNo(String vehicleNo);

    List<Vehicle> findByAll();
}
