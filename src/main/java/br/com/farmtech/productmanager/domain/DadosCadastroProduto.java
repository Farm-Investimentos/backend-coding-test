package br.com.farmtech.productmanager.domain;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class DadosCadastroProduto {

    @Length(min = 3, message = "O nome deve ter mais de 3 caracteres")
    private String nome;
    @NotNull(message = "O status nao pode ser nulo")
    private String status;

}