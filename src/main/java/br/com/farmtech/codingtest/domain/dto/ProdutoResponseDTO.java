package br.com.farmtech.codingtest.domain.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoResponseDTO {
    private UUID id;
    private String nome;
    private String status;
    private LocalDateTime dtAtualizacao;
    private LocalDateTime dtCriacao;
}
