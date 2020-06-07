package com.igor.votos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igor.votos.domain.Associado;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Integer>{

}
