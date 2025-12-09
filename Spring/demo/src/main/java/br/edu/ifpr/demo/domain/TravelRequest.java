package br.edu.ifpr.demo.domain;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data
public class TravelRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_travel;

    private Long passengerId;
    private Long driverId;

    private String origem;
    private String destino;

    @Enumerated(EnumType.STRING)
    private TravelRequestStatus status = TravelRequestStatus.CREATED;
}
