package it.immobiliare.immobile.mapper;

import it.immobiliare.immobile.dto.ImmobileDTO;
import it.immobiliare.immobile.entity.ImmobileEntity;
import org.springframework.stereotype.Component;

@Component
public class ImmobileMapper {

    public ImmobileEntity toEntity(ImmobileDTO immobileDTO){

        ImmobileEntity immobileEntity = new ImmobileEntity();
        immobileEntity.setShortDescription(immobileDTO.getShortDescription());
        immobileEntity.setDescription(immobileDTO.getDescription());
        immobileEntity.setCity(immobileDTO.getCity());

        return immobileEntity;
    }

    public ImmobileDTO toDTO(ImmobileEntity immobileEntity){

        ImmobileDTO immobileDTO =  new ImmobileDTO();
        immobileDTO.setId(immobileEntity.getId());
        immobileDTO.setShortDescription(immobileEntity.getShortDescription());
        immobileDTO.setDescription(immobileEntity.getDescription());
        immobileDTO.setCity(immobileEntity.getCity());

        return immobileDTO;
    }

}
