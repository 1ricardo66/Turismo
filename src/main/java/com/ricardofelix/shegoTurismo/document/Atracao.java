package com.ricardofelix.shegoTurismo.document;

import java.util.List;

/*import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;

import org.hibernate.annotations.GenericGenerator;*/
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Atracao {
	
	//@GeneratedValue(generator = "increment")
	//@GenericGenerator(name = "increment", strategy = "increment")
	
	@Id
	private String id;
	
	
	private String descricao;
	private String bairro;
	private String cidade;
	/*@ElementCollection(targetClass = AtracaoCategoria.class)
	@Enumerated
	@Column*/
	private List<AtracaoCategoria> categoria;
	
	
	public Atracao() {
		
	}
	
	public Atracao(Long id, String descricao) {
		
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
	
	public List<AtracaoCategoria> getCategoria() {
		return categoria;
	}


	public void setCategoria(List<AtracaoCategoria> categoria) {
		this.categoria = categoria;
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
		Atracao other = (Atracao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
