package autofix.microservices.msrepairvehicle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import autofix.microservices.msrepairvehicle.entities.RepairVehicleEntity;
import autofix.microservices.msrepairvehicle.services.RepairVehicleService;

import java.util.List;

@RestController
@RequestMapping("/api/repairvehicles")
public class RepairVehicleController {

    @Autowired
    private RepairVehicleService repairVehicleService;

    @PostMapping
    public ResponseEntity<RepairVehicleEntity> createRepair(@RequestBody RepairVehicleEntity repair) {
        RepairVehicleEntity newRepair = repairVehicleService.createRepair(repair);
        return ResponseEntity.ok(newRepair);
    }

    @GetMapping("/{licensePlate}")
    public ResponseEntity<List<RepairVehicleEntity>> getRepairsByLicensePlate(@PathVariable String licensePlate) {
        List<RepairVehicleEntity> repairs = repairVehicleService.getRepairsByLicensePlate(licensePlate);
        return ResponseEntity.ok(repairs);
    }

    @GetMapping
    public ResponseEntity<List<RepairVehicleEntity>> getAllRepairs() {
        List<RepairVehicleEntity> repairs = repairVehicleService.getAllRepairs();
        return ResponseEntity.ok(repairs);
    }

}
