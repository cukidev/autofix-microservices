package autofix.microservices.msrepairlist.controllers;

import autofix.microservices.msrepairlist.entities.RepairListEntity;
import autofix.microservices.msrepairlist.services.RepairListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repairlist")
public class RepairListController {
    @Autowired
    private RepairListService repairListService;

    @PostMapping
    public ResponseEntity<RepairListEntity> createRepair(@RequestBody RepairListEntity repair) {
        RepairListEntity newRepair = repairListService.createRepair(repair);
        return ResponseEntity.ok(newRepair);
    }

    @GetMapping
    public ResponseEntity<List<RepairListEntity>> getAllRepairs() {
        List<RepairListEntity> repairs = repairListService.getAllRepairs();
        return ResponseEntity.ok(repairs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepairListEntity> getRepairListById(@PathVariable("id") Long id) {
        return repairListService.findRepairListById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /* 
    @DeleteMapping("/{id}")
    public ResponseEntity<RepairListEntity> deleteRepair(@PathVariable Long id) throws Exception{
        var isDeleted = repairListService.deleteRepair(id);
        return ResponseEntity.noContent().build();
    }
    */
}
