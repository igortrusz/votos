package com.igor.votos.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sessao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer duracao;
	private Date inicio_sessao;
	private Date fim_sessao;
	
	public Sessao(Integer id, Integer duracao, Date inicio_sessao, Date fim_sessao) {
		super();
		this.id = id;
		this.duracao = duracao;
		this.inicio_sessao = inicio_sessao;
		this.fim_sessao = fim_sessao;
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
