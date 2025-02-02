package it.immobiliare.immobile.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImmobileDTO {

    private Long id;
    private String shortDescription;
    private String description;
    private String city;
    private Integer baths;
    private Integer rooms;
    private Integer floor;

}
