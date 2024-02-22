package br.com.farmtech.productmanager.domain;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DadosAtualizacaoProduto {

    @NotNull
    private Long id;
    private String nome;
    private String status;

}