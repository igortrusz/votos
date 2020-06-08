package com.igor.votos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor.votos.domain.Pauta;
import com.igor.votos.repositories.PautaRepository;

@Service
public class PautaService {
	
	@Autowired
	private PautaRepository repo;
	
	public Pauta find(Integer id) {
		Optional<Pauta> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
