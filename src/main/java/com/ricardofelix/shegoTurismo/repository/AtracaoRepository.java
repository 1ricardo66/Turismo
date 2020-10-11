package com.ricardofelix.shegoTurismo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.ricardofelix.shegoTurismo.document.Atracao;

public interface AtracaoRepository extends ReactiveMongoRepository<Atracao, String> {

}
