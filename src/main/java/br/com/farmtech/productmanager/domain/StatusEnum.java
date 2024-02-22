package br.com.farmtech.productmanager.domain;

public enum StatusEnum {

    ATIVO,
    INATIVO,
    FORA_DE_LINHA,
    EM_HOMOLOGACAO;

    public static StatusEnum fromString(String text) {
        for (StatusEnum status : StatusEnum.values()) {
            if (status.name().equalsIgnoreCase(text)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Nenhum status encontrado para a string fornecida: " + text);
    }

}