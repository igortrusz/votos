package com.igor.votos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igor.votos.domain.Voto;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Integer>{

}
