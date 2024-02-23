package br.com.farmtech.productmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {

    private Long id;
    private String nome;
    private String status;
    private String dataCriacao;
    private String dataAtualizacao;

}