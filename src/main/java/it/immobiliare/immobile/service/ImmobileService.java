package it.immobiliare.immobile.service;

import it.immobiliare.immobile.dto.ImmobileDTO;
import it.immobiliare.immobile.entity.ImmobileEntity;
import it.immobiliare.immobile.mapper.ImmobileMapper;
import it.immobiliare.immobile.repository.ImmobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImmobileService {

    @Autowired
    private ImmobileMapper immobileMapper;
    
    @Autowired
    private ImmobileRepository immobileRepository;

    public ImmobileDTO saveImmobile(ImmobileDTO immobileDTO) {
        ImmobileEntity immobileEntity = immobileMapper.toEntity(immobileDTO);
        immobileEntity = immobileRepository.save(immobileEntity);

        return immobileMapper.toDTO(immobileEntity);
    }

    public List<ImmobileDTO> getImmobili() {

        List<ImmobileEntity> immobileEntityList = immobileRepository.findAll();
        List<ImmobileDTO> immobileDTOList = new ArrayList<>();

        for(ImmobileEntity immobileEntity : immobileEntityList){
            ImmobileDTO immobileDTO = immobileMapper.toDTO(immobileEntity);
            immobileDTOList.add(immobileDTO);
        }
        return immobileDTOList;

    }

    public ImmobileDTO getImmobile(Long id) {

        Optional<ImmobileEntity> optionalImmobileEntity = immobileRepository.findById(id);
        ImmobileDTO immobileDTO = null;
        if(optionalImmobileEntity.isPresent()){
            ImmobileEntity immobileEntity = optionalImmobileEntity.get();
            immobileDTO = immobileMapper.toDTO(immobileEntity);
        }
        return immobileDTO;
    }

}
