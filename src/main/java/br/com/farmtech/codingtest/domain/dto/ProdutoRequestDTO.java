package br.com.farmtech.codingtest.domain.dto;

import br.com.farmtech.codingtest.domain.enums.StatusProdutoEnum;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequestDTO {
    private String nome;
    private StatusProdutoEnum status;
}
