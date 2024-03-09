package br.com.farmtech.codingtest.controller;

import br.com.farmtech.codingtest.domain.dto.ProdutoDTO;
import br.com.farmtech.codingtest.domain.mapper.ProdutoMapper;
import br.com.farmtech.codingtest.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoMapper produtoMapper;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> getAll(){
        return ResponseEntity.ok().body(produtoMapper.modelToDto(produtoService.listar()));
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> create(@RequestBody ProdutoDTO produtoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoMapper.modelToDto(produtoService.criar(produtoDTO)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> update(@PathVariable UUID id,
                                             @RequestBody ProdutoDTO produtoDTO) throws Exception {
        return ResponseEntity.ok().body(produtoMapper.modelToDto(produtoService.atualizar(id, produtoDTO)));
    }
}
