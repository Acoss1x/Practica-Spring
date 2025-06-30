package com.acoss.proyecto.proyecto_uno.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.acoss.proyecto.proyecto_uno.model.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, Integer> {

}
