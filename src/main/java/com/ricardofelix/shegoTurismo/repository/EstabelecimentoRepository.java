package com.ricardofelix.shegoTurismo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.ricardofelix.shegoTurismo.document.Estabelecimento;

@Repository
public interface EstabelecimentoRepository extends ReactiveMongoRepository<Estabelecimento, String>{

}
