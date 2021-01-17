package com.ricardofelix.Turismo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.ricardofelix.Turismo.document.Atracao;

public interface AtracaoRepository extends ReactiveMongoRepository<Atracao, String> {

}
