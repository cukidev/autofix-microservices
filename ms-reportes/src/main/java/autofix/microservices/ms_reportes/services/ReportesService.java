package autofix.microservices.msreportes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportesService {

    @Autowired
    private RestTemplate restTemplate;

    private final String vehicleServiceUrl = "http://msvehicles/api/vehiculos";
    private final String repairListServiceUrl = "http://msrepairlist/api/repairs";
    private final String repairVehicleServiceUrl = "http://msrepairvehicle/api/repairvehicles";

    public List<Map<String, Object>> getReporte1(String month, String year) {
        // Obtener datos de los microservicios
        List<Map<String, Object>> vehicles = restTemplate.getForObject(vehicleServiceUrl, List.class);
        List<Map<String, Object>> repairs = restTemplate.getForObject(repairListServiceUrl, List.class);
        List<Map<String, Object>> repairHistory = restTemplate.getForObject(repairVehicleServiceUrl, List.class);

        // Filtrar y procesar datos para generar el reporte
        List<Map<String, Object>> filteredRepairHistory = repairHistory.stream()
                .filter(repair -> {
                    String repairDate = (String) repair.get("repairDate");
                    return repairDate.startsWith(year + "-" + month);
                })
                .collect(Collectors.toList());

        // Agregar detalles de vehículo y reparación al reporte
        List<Map<String, Object>> report = filteredRepairHistory.stream()
                .map(repair -> {
                    String licensePlate = (String) repair.get("licensePlate");
                    Map<String, Object> vehicle = vehicles.stream()
                            .filter(v -> v.get("licensePlate").equals(licensePlate))
                            .findFirst()
                            .orElse(null);
                    Map<String, Object> repairDetail = repairs.stream()
                            .filter(r -> r.get("type").equals(repair.get("type")))
                            .findFirst()
                            .orElse(null);

                    repair.put("vehicleDetails", vehicle);
                    repair.put("repairDetails", repairDetail);
                    return repair;
                })
                .collect(Collectors.toList());

        return report;
    }

    public List<Map<String, Object>> getReporte2(String month) {
        // Obtener datos de los microservicios
        List<Map<String, Object>> repairHistory = restTemplate.getForObject(repairVehicleServiceUrl, List.class);

        // Filtrar y procesar datos para generar el reporte
        List<Map<String, Object>> filteredRepairHistory = repairHistory.stream()
                .filter(repair -> {
                    String repairDate = (String) repair.get("repairDate");
                    return repairDate.startsWith(month);
                })
                .collect(Collectors.toList());

        // Generar reporte con estadísticas de reparaciones por tipo
        Map<String, Long> report = filteredRepairHistory.stream()
                .collect(Collectors.groupingBy(repair -> (String) repair.get("type"), Collectors.counting()));

        return report.entrySet().stream()
                .map(entry -> Map.of("type", entry.getKey(), "count", entry.getValue()))
                .collect(Collectors.toList());
    }
}
