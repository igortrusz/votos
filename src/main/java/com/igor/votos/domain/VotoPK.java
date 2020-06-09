package com.igor.votos.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class VotoPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="associado_id")
	private Associado associado;
	
	@ManyToOne
	@JoinColumn(name="sessao_id")
	private Sessao sessao;
	
	public Associado getAssociado() {
		return associado;
	}
	public void setAssociado(Associado associado) {
		this.associado = associado;
	}
	public Sessao getSessao() {
		return sessao;
	}
	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((associado == null) ? 0 : associado.hashCode());
		result = prime * result + ((sessao == null) ? 0 : sessao.hashCode());
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
		VotoPK other = (VotoPK) obj;
		if (associado == null) {
			if (other.associado != null)
				return false;
		} else if (!associado.equals(other.associado))
			return false;
		if (sessao == null) {
			if (other.sessao != null)
				return false;
		} else if (!sessao.equals(other.sessao))
			return false;
		return true;
	}
	
	
	
	

}
