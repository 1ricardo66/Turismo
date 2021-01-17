package com.ricardofelix.Turismo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.ricardofelix.Turismo.document.Estabelecimento;

@Repository
public interface EstabelecimentoRepository extends ReactiveMongoRepository<Estabelecimento, String>{

}
