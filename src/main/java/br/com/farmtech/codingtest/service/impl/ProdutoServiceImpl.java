package br.com.farmtech.codingtest.service.impl;

import br.com.farmtech.codingtest.domain.dto.ProdutoRequestDTO;
import br.com.farmtech.codingtest.domain.entity.Produto;
import br.com.farmtech.codingtest.domain.mapper.ProdutoMapper;
import br.com.farmtech.codingtest.exception.BusinessException;
import br.com.farmtech.codingtest.exception.NotFoundException;
import br.com.farmtech.codingtest.repository.ProdutoRepository;
import br.com.farmtech.codingtest.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public Produto criar(ProdutoRequestDTO produtoRequestDTO) throws BusinessException {
        isExistingProduct(produtoRequestDTO.getNome());
        return produtoRepository.save(produtoMapper.dtoToModel(produtoRequestDTO));
    }

    @Override
    public Produto atualizar(UUID id, ProdutoRequestDTO produtoRequestDTO) throws NotFoundException, BusinessException {
        Produto produto = getById(id);
        if(!produto.getNome().equalsIgnoreCase(produtoRequestDTO.getNome())){
            isExistingProduct(produtoRequestDTO.getNome());
        }
        produto.setNome(produtoRequestDTO.getNome());
        produto.setStatus(produtoRequestDTO.getStatus());
        produto.setDtAtualizacao(LocalDateTime.now());
        return produtoRepository.save(produto);
    }

    public Produto getById(UUID id) throws NotFoundException {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto não encontrado."));
    }

    public void isExistingProduct(String nome) throws BusinessException {
        if(produtoRepository.findByNome(nome).isPresent()){
            throw new BusinessException("Produto já existente.");
        }
    }

}
