package br.com.farmtech.codingtest.domain.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequestDTO {
    private String nome;
    private String status;
}
