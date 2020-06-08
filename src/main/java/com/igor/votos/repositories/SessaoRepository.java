package com.igor.votos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igor.votos.domain.Sessao;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Integer>{

}
