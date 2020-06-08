package com.igor.votos;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.igor.votos.domain.Associado;
import com.igor.votos.domain.Pauta;
import com.igor.votos.domain.Sessao;
import com.igor.votos.repositories.AssociadoRepository;
import com.igor.votos.repositories.PautaRepository;
import com.igor.votos.repositories.SessaoRepository;

@SpringBootApplication
public class VotosApplication implements CommandLineRunner {
	
	@Autowired
	private AssociadoRepository associadoRepository ;
	@Autowired
	private PautaRepository pautaRepository ;
	@Autowired
	private SessaoRepository sessaoRepository ;

	public static void main(String[] args) {
		SpringApplication.run(VotosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Associado assoc1 = new Associado(null,"Igor","12345678998");
		Associado assoc2 = new Associado(null,"Luis","98765432112");
		
		associadoRepository.saveAll(Arrays.asList(assoc1, assoc2));
		
		Pauta pauta1 = new Pauta(null,"Pauta de teste 1");
		Pauta pauta2 = new Pauta(null,"Pauta de teste 2");
		
		pautaRepository.saveAll(Arrays.asList(pauta1,pauta2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//		Integer id, Integer duracao, Date inicio_sessao, Date fim_sessao
		Sessao sessao1 = new Sessao(null, 10, sdf.parse("08/06/2020 01:06"), sdf.parse("08/06/2020 01:16"));

		sessaoRepository.saveAll(Arrays.asList(sessao1));
	}

}
