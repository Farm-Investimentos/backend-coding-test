package br.com.farmtech.codingtest.service;

import br.com.farmtech.codingtest.domain.dto.ProdutoDTO;
import br.com.farmtech.codingtest.domain.entity.Produto;

import java.util.List;
import java.util.UUID;

public interface ProdutoService {
    List<Produto> listar();
    Produto criar(ProdutoDTO produtoDTO);
    Produto atualizar(UUID id, ProdutoDTO produtoDTO) throws Exception;
}
