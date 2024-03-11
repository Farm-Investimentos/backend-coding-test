package br.com.farmtech.codingtest.domain.enums;

public enum StatusProdutoEnum {
    ATIVO("A", "Ativo"),
    INATIVO("I", "Inativo"),
    FORA_DE_LINHA("F", "Fora de Linha"),
    EM_HOMOLOGACAO("H", "Em Homologação");

    private String key;
    private String value;

    StatusProdutoEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public StatusProdutoEnum getEnum(String key) {
        for (StatusProdutoEnum s : StatusProdutoEnum.values()) {
            if (s.getKey().equals(key)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Valor não permitido");
    }
}
