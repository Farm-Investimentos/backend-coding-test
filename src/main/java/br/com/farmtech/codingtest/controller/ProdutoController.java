package br.com.farmtech.codingtest.controller;

import br.com.farmtech.codingtest.domain.dto.ProdutoRequestDTO;
import br.com.farmtech.codingtest.domain.dto.ProdutoResponseDTO;
import br.com.farmtech.codingtest.domain.mapper.ProdutoMapper;
import br.com.farmtech.codingtest.exception.BusinessException;
import br.com.farmtech.codingtest.exception.NotFoundException;
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
    public ResponseEntity<List<ProdutoResponseDTO>> getAll(){
        return ResponseEntity.ok().body(produtoMapper.modelToDto(produtoService.listar()));
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> create(@RequestBody ProdutoRequestDTO produtoRequestDTO)
            throws BusinessException {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoMapper.modelToDto(produtoService.criar(produtoRequestDTO)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> update(@PathVariable UUID id,
                                                     @RequestBody ProdutoRequestDTO produtoRequestDTO) throws NotFoundException, BusinessException {
        return ResponseEntity.ok().body(produtoMapper.modelToDto(produtoService.atualizar(id, produtoRequestDTO)));
    }
}
