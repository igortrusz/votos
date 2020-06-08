package com.igor.votos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor.votos.domain.Sessao;
import com.igor.votos.repositories.SessaoRepository;

@Service
public class SessaoService {
	
	@Autowired
	private SessaoRepository repo;
	
	public Sessao find(Integer id) {
		Optional<Sessao> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
