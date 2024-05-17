package autofix.microservices.msrepairlist.repository;

import autofix.microservices.msrepairlist.entities.RepairListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairListRepository extends JpaRepository<RepairListEntity, Long> {
}