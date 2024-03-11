package br.com.farmtech.codingtest.domain.dto;

import br.com.farmtech.codingtest.domain.enums.StatusProdutoEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class ProdutoRequestDTO {
    @NotBlank(message = "O nome não pode estar em branco")
    @Length(min = 3, message = "O nome deve conter ao menos 3 caracteres")
    private String nome;
    private StatusProdutoEnum status;
}
