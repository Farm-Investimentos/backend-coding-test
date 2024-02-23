package br.com.farmtech.productmanager.domain;

public enum StatusEnum {

    ATIVO("ativo"),
    INATIVO("inativo"),
    FORA_DE_LINHA("fora de linha"),
    EM_HOMOLOGACAO("em homologação");

    private String statusFriendly;

    StatusEnum(String statusFriendly) {
        this.statusFriendly = statusFriendly;
    }

    public static StatusEnum fromString(String text) {
        for (StatusEnum status : StatusEnum.values()) {
            if (status.name().equalsIgnoreCase(text)) {
                return status;
            }
        }
        for (StatusEnum status : StatusEnum.values()) {
            if (status.statusFriendly.equalsIgnoreCase(text)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Nenhum status encontrado para a string fornecida: " + text);
    }

}