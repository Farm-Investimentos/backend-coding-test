package br.com.farmtech.codingtest.service;

import br.com.farmtech.codingtest.domain.dto.ProdutoRequestDTO;
import br.com.farmtech.codingtest.domain.entity.Produto;
import br.com.farmtech.codingtest.exception.BusinessException;
import br.com.farmtech.codingtest.exception.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProdutoService {
    List<Produto> listar();
    Produto criar(ProdutoRequestDTO produtoRequestDTO) throws BusinessException;
    Produto atualizar(UUID id, ProdutoRequestDTO produtoRequestDTO) throws NotFoundException, BusinessException;
}
