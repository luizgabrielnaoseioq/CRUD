package com.nazax.crud.repository;

import com.nazax.crud.models.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository // Indica que esta interface é um repositório do Spring Data JPA
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    // Método para buscar cidades pelo nome
    List<Cidade> findByNomeContainingIgnoreCase(String nome);
}

