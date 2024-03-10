package br.com.farmtech.codingtest.domain.enums.converters;

import br.com.farmtech.codingtest.domain.enums.StatusProdutoEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Objects;

@Converter(autoApply = true)
public class StatusProdutoEnumConverter implements AttributeConverter<StatusProdutoEnum, String> {

    @Override
    public String convertToDatabaseColumn(StatusProdutoEnum value) {
        if(Objects.isNull(value)){
            return null;
        }
        return value.getKey();
    }

    @Override
    public StatusProdutoEnum convertToEntityAttribute(String value) {
        if(Objects.isNull(value)){
            return null;
        }

        for (StatusProdutoEnum s : StatusProdutoEnum.values()) {
            if (s.getKey().equals(value)) {
                return s;
            }
        }
        throw new IllegalArgumentException(
                String.format("Valor %s é inválido para a classe %s", value, StatusProdutoEnum.class.getName()));
    }
}
