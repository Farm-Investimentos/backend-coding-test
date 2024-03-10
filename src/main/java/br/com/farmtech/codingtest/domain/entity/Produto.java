package br.com.farmtech.codingtest.domain.entity;

import br.com.farmtech.codingtest.domain.enums.StatusProdutoEnum;
import br.com.farmtech.codingtest.domain.enums.converters.StatusProdutoEnumConverter;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_PRODUTOS")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "NOME")
    private String nome;

    @Convert(converter = StatusProdutoEnumConverter.class)
    @Column(name = "STATUS")
    private StatusProdutoEnum status;

    @Column(name = "DT_ATUALIZACAO")
    private LocalDateTime dtAtualizacao;

    @CreationTimestamp
    @Column(name = "DT_CRIACAO", insertable = false, updatable = false)
    private LocalDateTime dtCriacao;

}
