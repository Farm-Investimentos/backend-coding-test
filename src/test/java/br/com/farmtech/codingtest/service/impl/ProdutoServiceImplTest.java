package br.com.farmtech.codingtest.service.impl;

import br.com.farmtech.codingtest.domain.dto.ProdutoRequestDTO;
import br.com.farmtech.codingtest.domain.entity.Produto;
import br.com.farmtech.codingtest.domain.enums.StatusProdutoEnum;
import br.com.farmtech.codingtest.domain.mapper.ProdutoMapper;
import br.com.farmtech.codingtest.exception.BusinessException;
import br.com.farmtech.codingtest.exception.NotFoundException;
import br.com.farmtech.codingtest.repository.ProdutoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProdutoServiceImplTest {

    private static final UUID ID = UUID.randomUUID();
    private static final String NOME = "Produto Teste";
    private static final StatusProdutoEnum STATUS_ATIVO = StatusProdutoEnum.ATIVO;
    private static final LocalDateTime NOW = LocalDateTime.now();
    private static final int INDEX = 0;

    @InjectMocks
    private ProdutoServiceImpl service;

    @Mock
    private ProdutoRepository repository;

    @Mock
    private ProdutoMapper produtoMapper;

    private Produto produto;
    private ProdutoRequestDTO produtoRequestDTO;
    private Optional<Produto> optionalProduto;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        buildProduto();
    }

    @Test
    void whenFindByIdThenReturnAnProductInstance() throws NotFoundException {
        when(repository.findById(any(UUID.class))).thenReturn(optionalProduto);
        Produto response = service.getById(ID);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(Produto.class, response.getClass());
    }

    @Test
    void whenFindAllThenReturnAnListOfProducts(){
        when(repository.findAll()).thenReturn(List.of(produto));
        List<Produto> response = service.listar();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(Produto.class, response.get(INDEX).getClass());
        assertEquals(ID, response.get(INDEX).getId());
    }

    @Test
    void whenCreateThenReturnSuccess() throws BusinessException {
        when(repository.save(any())).thenReturn(produto);
        Produto response = service.criar(produtoRequestDTO);

        assertNotNull(response);
        assertEquals(ID, response.getId());
        assertEquals(NOME, response.getNome());
        assertEquals(STATUS_ATIVO, response.getStatus());
        assertNull(response.getDtAtualizacao());
        assertEquals(NOW, response.getDtCriacao());
    }

    @Test
    void whenCreateThenReturnAnBusinessException() {
        when(repository.findByNome(anyString())).thenReturn(optionalProduto);
        try{
            service.criar(produtoRequestDTO);
        } catch (Exception ex){
            assertEquals(BusinessException.class, ex.getClass());
        }
    }

    @Test
    void whenUpdateThenReturnSuccess() throws BusinessException, NotFoundException {
        when(repository.findById(any(UUID.class))).thenReturn(optionalProduto);
        when(repository.save(any())).thenReturn(produto);
        Produto response = service.atualizar(ID, produtoRequestDTO);

        assertNotNull(response);
        assertEquals(ID, response.getId());
        assertEquals(NOME, response.getNome());
        assertEquals(STATUS_ATIVO, response.getStatus());
        assertNull(response.getDtAtualizacao());
        assertEquals(NOW, response.getDtCriacao());
    }

    @Test
    void whenUpdateThenReturnAnNotFoundException() {
        when(repository.findByNome(anyString())).thenReturn(optionalProduto);
        try{
            service.atualizar(ID, produtoRequestDTO);
        } catch (Exception ex){
            assertEquals(NotFoundException.class, ex.getClass());
        }
    }

    @Test
    void whenUpdateThenReturnAnBusinessException() {
        when(repository.findById(any(UUID.class))).thenReturn(optionalProduto);
        when(repository.findByNome(anyString())).thenReturn(optionalProduto);
        try{
            produtoRequestDTO.setNome("Produto existente");
            service.atualizar(ID, produtoRequestDTO);
        } catch (Exception ex){
            assertEquals(BusinessException.class, ex.getClass());
        }
    }

    private void buildProduto(){
        produto = new Produto(ID, NOME, STATUS_ATIVO, null, NOW);
        produtoRequestDTO = new ProdutoRequestDTO(NOME, STATUS_ATIVO);
        optionalProduto = Optional.of(new Produto(ID, NOME, STATUS_ATIVO, null, NOW));
    }
}