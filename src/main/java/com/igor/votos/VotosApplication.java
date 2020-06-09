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
import com.igor.votos.domain.Voto;
import com.igor.votos.repositories.AssociadoRepository;
import com.igor.votos.repositories.PautaRepository;
import com.igor.votos.repositories.SessaoRepository;
import com.igor.votos.repositories.VotoRepository;

@SpringBootApplication
public class VotosApplication implements CommandLineRunner {
	
	@Autowired
	private AssociadoRepository associadoRepository ;
	@Autowired
	private PautaRepository pautaRepository ;
	@Autowired
	private SessaoRepository sessaoRepository ;
	@Autowired
	private VotoRepository votoRepository ;

	public static void main(String[] args) {
		SpringApplication.run(VotosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Associado assoc1 = new Associado(null,"Igor","12345678998");
		Associado assoc2 = new Associado(null,"Luis","98765432112");
		
		Pauta pauta1 = new Pauta(null,"Pauta de teste 1");
		Pauta pauta2 = new Pauta(null,"Pauta de teste 2"); 
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Sessao sessao1 = new Sessao(null, 10, sdf.parse("08/06/2020 01:06"), sdf.parse("08/06/2020 01:16"),pauta1);
		pauta1.setSessao(sessao1);
		
		Sessao sessao2 = new Sessao(null, 15, sdf.parse("08/06/2020 23:15"), sdf.parse("08/06/2020 23:30"),pauta2);
		pauta2.setSessao(sessao2);
		
		associadoRepository.saveAll(Arrays.asList(assoc1, assoc2));
		pautaRepository.saveAll(Arrays.asList(pauta1,pauta2));
		sessaoRepository.saveAll(Arrays.asList(sessao1, sessao2));
		
		Voto voto1 = new Voto(sessao1, assoc1, true);
		Voto voto2 = new Voto(sessao1, assoc2, false);
		
		sessao1.getVotos().addAll(Arrays.asList(voto1, voto2));
		
		assoc1.getVotos().addAll(Arrays.asList(voto1));
		assoc2.getVotos().addAll(Arrays.asList(voto2));

		votoRepository.saveAll(Arrays.asList(voto1,voto2));
		
		
	}

}
