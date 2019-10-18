package com.mssmfactory.microserviceexpeditions.repositories;

import com.mssmfactory.microserviceexpeditions.model.Expedition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpeditionRepository extends JpaRepository<Expedition, Integer> {
}
