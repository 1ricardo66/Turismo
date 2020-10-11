package com.ricardofelix.shegoTurismo.document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Estabelecimento implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	
	/*@ElementCollection(targetClass = EstabelecimentoCategoria.class)
	@Enumerated
	@Column*/
	private List<EstabelecimentoCategoria> categoria;

	
	private String nome;
	private String rua;
	private int numero;
	private String cep;
	private String cidade;
	private String telefone;
	private String email;
	private String site;
	private ArrayList<String> tags;
	


	
	public Estabelecimento(Long id, String nome) {
		
	}

	public Estabelecimento() {
		
	}
	
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public List<EstabelecimentoCategoria> getCategoria() {
		return categoria;
	}



	public void setCategoria(List<EstabelecimentoCategoria> categoria) {
		this.categoria = categoria;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	
	public ArrayList<String> getTags() {
		return tags;
	}



	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
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
		Estabelecimento other = (Estabelecimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	
	
	
	
	
	
	
}
