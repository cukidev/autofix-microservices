package autofix.microservices.msvehicles.entities;

import autofix.microservices.msvehicles.enums.EngineTypeEnum;
import autofix.microservices.msvehicles.enums.VtypeEnum;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String licensePlate;
    private String brand;
    private String model;
    private VtypeEnum v_type;
    private Integer year_of_manufacture;
    private EngineTypeEnum engine_type;
    private Integer seats;
    private Integer mileage;
}
