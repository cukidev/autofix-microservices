package autofix.microservices.msrepairvehicle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import autofix.microservices.msrepairvehicle.entities.RepairVehicleEntity;
import autofix.microservices.msrepairvehicle.repositories.RepairVehicleRepository;

import java.util.List;

@Service
public class RepairVehicleService {

    @Autowired
    private RepairVehicleRepository repairVehicleRepository;
    
    public RepairVehicleEntity createRepair(RepairVehicleEntity repair) {
        return repairVehicleRepository.save(repair);
    }

    public List<RepairVehicleEntity> getRepairsByLicensePlate(String licensePlate) {
        return repairVehicleRepository.findByLicensePlate(licensePlate);
    }

    public List<RepairVehicleEntity> getAllRepairs() {
        return repairVehicleRepository.findAll();
    }
}
