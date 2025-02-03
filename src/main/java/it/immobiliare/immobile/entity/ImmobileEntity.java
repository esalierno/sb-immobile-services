package it.immobiliare.immobile.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.stream.Collectors;


@Entity
@Table(name = "IMMOBILE")
@Getter
@Setter
@NoArgsConstructor
public class ImmobileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "shortDescription", nullable = false)
    private String shortDescription;
    private String description;
    private String city;
    private Integer baths;
    private Integer rooms;
    private Integer floor;

}
