package br.com.farmtech.codingtest.domain.mapper;

import br.com.farmtech.codingtest.domain.dto.ProdutoRequestDTO;
import br.com.farmtech.codingtest.domain.dto.ProdutoResponseDTO;
import br.com.farmtech.codingtest.domain.entity.Produto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ProdutoMapper {
    List<ProdutoResponseDTO> modelToDto(List<Produto> produtoList);
    ProdutoResponseDTO modelToDto(Produto produto);
    Produto dtoToModel(ProdutoRequestDTO produtoRequestDTO);
}
