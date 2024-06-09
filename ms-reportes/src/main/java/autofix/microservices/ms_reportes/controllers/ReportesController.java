package autofix.microservices.msreportes.controllers;

import autofix.microservices.msreportes.services.ReportesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reportes")
public class ReportesController {

    @Autowired
    private ReportesService reportesService;

    @GetMapping("/reporte1")
    public ResponseEntity<List<Map<String, Object>>> getReporte1(@RequestParam String month, @RequestParam String year) {
        List<Map<String, Object>> reporte1 = reportesService.getReporte1(month, year);
        return ResponseEntity.ok(reporte1);
    }

    @GetMapping("/reporte2")
    public ResponseEntity<List<Map<String, Object>>> getReporte2(@RequestParam String month) {
        List<Map<String, Object>> reporte2 = reportesService.getReporte2(month);
        return ResponseEntity.ok(reporte2);
    }
}
