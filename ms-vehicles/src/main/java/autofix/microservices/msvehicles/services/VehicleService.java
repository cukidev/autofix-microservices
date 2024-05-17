package autofix.microservices.msvehicles.services;

import autofix.microservices.msvehicles.entities.VehicleEntity;
import autofix.microservices.msvehicles.repositories.VehicleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public VehicleEntity createVehicle(VehicleEntity vehicle){
        return vehicleRepository.save(vehicle);
    }

    public List<VehicleEntity> getVehicles() {
        return vehicleRepository.findAll();
    }

    public VehicleEntity getVehicleById(Long id) {
        return vehicleRepository.findById(id).get();
    }

    public VehicleEntity updateVehicle(Long id, VehicleEntity vehicleEntity){
        if(vehicleRepository.existsById(id)) {
            vehicleEntity.setId(id);
            return vehicleRepository.save(vehicleEntity);
        }
        throw new EntityNotFoundException("El vehículo con el id " + id + " no existe.");
    }
    public boolean deleteVehicle(Long id) throws Exception{
        try{
            vehicleRepository.deleteById(id);
            return true;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
