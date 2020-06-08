package com.igor.votos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igor.votos.domain.Pauta;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Integer>{

}
