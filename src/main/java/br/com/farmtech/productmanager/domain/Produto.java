package br.com.farmtech.productmanager.domain;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "produtos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=3)
    private String nome;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @NotNull
    private LocalDateTime dataCriacao;

    @NotNull
    private LocalDateTime dataAtualizacao;

    public void atualizaProduto(DadosAtualizacaoProduto dto) {
        this.setNome(dto.getNome());
        this.setStatus(StatusEnum.fromString(dto.getStatus()));
        this.setDataAtualizacao(LocalDateTime.now());
    }

}