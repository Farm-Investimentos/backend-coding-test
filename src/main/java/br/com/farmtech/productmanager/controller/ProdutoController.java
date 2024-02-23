package br.com.farmtech.productmanager.controller;

import br.com.farmtech.productmanager.domain.DadosCadastroProduto;
import br.com.farmtech.productmanager.domain.ProdutoDto;
import br.com.farmtech.productmanager.domain.DadosAtualizacaoProduto;
import br.com.farmtech.productmanager.infra.exceptions.ValidacaoException;
import br.com.farmtech.productmanager.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> listar() {
        return ResponseEntity.ok(service.obterTodos());
    }

    @PostMapping
    public ResponseEntity<ProdutoDto> cadastra(@RequestBody @Valid DadosCadastroProduto dto)
            throws ValidacaoException {
        ProdutoDto cadastrado = service.cadastrar(dto);
        return ResponseEntity.ok(cadastrado);
    }

    @PutMapping
    public ResponseEntity<ProdutoDto> edita(@RequestBody @Valid DadosAtualizacaoProduto dto)
            throws ValidacaoException {
        ProdutoDto editado = service.editar(dto);
        return ResponseEntity.ok(editado);
    }

}