package com.igor.votos.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Sessao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private Integer duracao;
	private Date inicio_sessao;
	private Date fim_sessao;

	@OneToOne
	@JoinColumn(name = "pauta_id")
	@MapsId
	private Pauta pauta;

	@OneToMany(mappedBy = "id.sessao")
	private Set<Voto> votos = new HashSet<>();
	
	public Sessao() {
	}
	
	public Sessao(Integer id, Integer duracao, Date inicio_sessao, Date fim_sessao, Pauta pauta) {
		super();
		this.id = id;
		this.duracao = duracao;
		this.inicio_sessao = inicio_sessao;
		this.fim_sessao = fim_sessao;
		this.pauta = pauta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public Date getInicio_sessao() {
		return inicio_sessao;
	}

	public void setInicio_sessao(Date inicio_sessao) {
		this.inicio_sessao = inicio_sessao;
	}

	public Date getFim_sessao() {
		return fim_sessao;
	}

	public void setFim_sessao(Date fim_sessao) {
		this.fim_sessao = fim_sessao;
	}

	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}

	public Set<Voto> getVotos() {
		return votos;
	}

	public void setVotos(Set<Voto> votos) {
		this.votos = votos;
	}

	public String getResultado() {

		Integer votosFavor = 0;
		Integer votosContra = 0;

		for (Voto x : votos) {
			if (x.getOpcao()) {
				votosFavor++;
			} else {
				votosContra++;
			}
		}

		return "Resultado: Votos a favor: " + votosFavor + ", Votos contra: " + votosContra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sessao other = (Sessao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
