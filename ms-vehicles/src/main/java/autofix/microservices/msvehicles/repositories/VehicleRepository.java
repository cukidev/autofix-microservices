package autofix.microservices.msvehicles.repositories;

import autofix.microservices.msvehicles.entities.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface VehicleRepository extends JpaRepository<VehicleEntity, Long>{

}

