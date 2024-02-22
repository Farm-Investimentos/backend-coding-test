package br.com.farmtech.productmanager.service;

import br.com.farmtech.productmanager.domain.*;
import br.com.farmtech.productmanager.infra.exceptions.ValidacaoException;
import br.com.farmtech.productmanager.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProdutoDto> obterTodos() {
        return repository
                .findAll()
                .stream()
                .map(p -> modelMapper.map(p, ProdutoDto.class))
                .toList();
    }

    public ProdutoDto cadastrar(DadosCadastroProduto dto) throws ValidacaoException {
        Produto produto = modelMapper.map(dto, Produto.class);
        Optional<Produto> banco = repository.findByNome(produto.getNome());
        if (banco.isPresent()) {
            throw new ValidacaoException("Produto ja existente");
        }
        produto.setStatus(StatusEnum.fromString(dto.getStatus()));
        produto.setDataCriacao(LocalDateTime.now());
        produto.setDataAtualizacao(LocalDateTime.now());
        Produto salvo = repository.save(produto);
        return modelMapper.map(salvo, ProdutoDto.class);
    }

    public ProdutoDto editar(DadosAtualizacaoProduto dto) throws ValidacaoException {
        Optional<Produto> banco = repository.findById(dto.getId());
        if (banco.isEmpty()){
            throw new EntityNotFoundException("Produto nao encontrado");
        } else if(!dto.getNome().equalsIgnoreCase(banco.get().getNome())) {
            Optional<Produto> byNome = repository.findByNome(dto.getNome());
            if (byNome.isPresent()) {
                throw new ValidacaoException("Produto ja existente");
            }
        }
        banco.get().atualizaProduto(dto);
        return modelMapper.map(repository.save(banco.get()), ProdutoDto.class);
    }
}