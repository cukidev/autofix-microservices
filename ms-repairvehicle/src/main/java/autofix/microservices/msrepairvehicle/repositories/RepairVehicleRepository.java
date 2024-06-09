package autofix.microservices.msrepairvehicle.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import autofix.microservices.msrepairvehicle.entities.RepairVehicleEntity;
import java.util.List;

@Repository
public interface RepairVehicleRepository extends JpaRepository<RepairVehicleEntity, Long>{
    List<RepairVehicleEntity> findByLicensePlate(String licensePlate);
}
