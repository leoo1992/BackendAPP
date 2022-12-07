package br.com.apiclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apiclient.model.Cliente;

@Repository
public interface clienteRepository 
extends JpaRepository<Cliente, Long> { }
