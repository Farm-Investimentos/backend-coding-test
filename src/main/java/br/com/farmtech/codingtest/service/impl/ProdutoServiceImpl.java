package br.com.farmtech.codingtest.service.impl;

import br.com.farmtech.codingtest.domain.dto.ProdutoDTO;
import br.com.farmtech.codingtest.domain.entity.Produto;
import br.com.farmtech.codingtest.domain.mapper.ProdutoMapper;
import br.com.farmtech.codingtest.repository.ProdutoRepository;
import br.com.farmtech.codingtest.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoMapper produtoMapper;

    @Override
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto criar(ProdutoDTO produtoDTO) {
        return produtoRepository.save(produtoMapper.dtoToModel(produtoDTO));
    }

    @Override
    public Produto atualizar(UUID id, ProdutoDTO produtoDTO) throws Exception {
        Produto produto = getById(id);
        produtoDTO.setId(produto.getId());
        return produtoRepository.save(produtoMapper.dtoToModel(produtoDTO));
    }

    public Produto getById(UUID id) throws Exception {
        return produtoRepository.findById(id).orElseThrow(Exception::new);
    }

}
