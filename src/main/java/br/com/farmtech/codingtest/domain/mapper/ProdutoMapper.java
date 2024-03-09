package br.com.farmtech.codingtest.domain.mapper;

import br.com.farmtech.codingtest.domain.dto.ProdutoDTO;
import br.com.farmtech.codingtest.domain.entity.Produto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ProdutoMapper {
    List<ProdutoDTO> modelToDto(List<Produto> produtoList);
    ProdutoDTO modelToDto(Produto produto);
    Produto dtoToModel(ProdutoDTO produtoDTO);
}
