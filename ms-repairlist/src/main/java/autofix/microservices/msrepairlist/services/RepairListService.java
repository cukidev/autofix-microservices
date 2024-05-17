package autofix.microservices.msrepairlist.services;

import autofix.microservices.msrepairlist.entities.RepairListEntity;
import autofix.microservices.msrepairlist.repository.RepairListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class RepairListService {
    @Autowired
    private RepairListRepository repairListRepository;

    public RepairListEntity createRepair(RepairListEntity repair) {
        return repairListRepository.save(repair);
    }

    public List<RepairListEntity> getAllRepairs() {
        return repairListRepository.findAll();
    }

    public Optional<RepairListEntity> findRepairListById(Long repairListId) {
        return repairListRepository.findById(Long.valueOf(String.valueOf(repairListId)));
    }

    public boolean deleteRepair(Long id) throws Exception{
        try{
            repairListRepository.deleteById(id);
            return true;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}