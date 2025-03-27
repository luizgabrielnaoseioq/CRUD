package com.nazax.crud.service;

import com.nazax.crud.dtos.CidadeDTO;
import com.nazax.crud.models.Cidade;
import com.nazax.crud.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service // Indica que essa classe é um serviço do Spring
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository; // Injeta o repositório para acessar os dados

    // Buscar todas as cidades
    public List<CidadeDTO> findAll() {
        List<Cidade> cidades = cidadeRepository.findAll();
        return cidades.stream().map(CidadeService::toDTO).toList(); // Converte para DTO
    }

    // Buscar cidade por ID
    public CidadeDTO findById(Long id) {
        Optional<Cidade> cidade = cidadeRepository.findById(id);
        return cidade.map(CidadeService::toDTO).orElse(null); // Se existir, converte para DTO
    }

    // Buscar cidades pelo nome
    public List<CidadeDTO> findByNome(String nome) {
        List<Cidade> cidades = cidadeRepository.findByNomeContainingIgnoreCase(nome);
        return cidades.stream().map(CidadeService::toDTO).toList(); // Converte para DTO
    }

    // Criar ou atualizar uma cidade
    public CidadeDTO save(CidadeDTO cidadeDTO) {
        Cidade cidade = cidadeRepository.save(toEntity(cidadeDTO)); // Converte DTO para Entidade e salva
        return toDTO(cidade); // Retorna DTO
    }

    // Deletar cidade pelo ID
    public void deleteById(Long id) {
        cidadeRepository.deleteById(id);
    }

    // Métodos de conversão

    // Converte Entidade para DTO
    public static CidadeDTO toDTO(Cidade cidade) {
        return new CidadeDTO(cidade.getId(), cidade.getNome(), cidade.getCep());
    }

    // Converte DTO para Entidade
    public static Cidade toEntity(CidadeDTO cidadeDTO) {
        return new Cidade(cidadeDTO.getId(), cidadeDTO.getNome(), cidadeDTO.getCep());
    }
}

