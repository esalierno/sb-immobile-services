package it.immobiliare.immobile.repository;

import it.immobiliare.immobile.entity.ImmobileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImmobileRepository extends JpaRepository<ImmobileEntity, Long> {


}
