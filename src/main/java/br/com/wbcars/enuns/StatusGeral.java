package br.com.wbcars.enuns;

public enum StatusGeral {
    ATIVO("Ativo"),
    INATIVO("Inativo"),
    PENDENTE("Pendente"),
    APROVADO("Aprovado"),
    REPROVADO("Reprovado"),
    CANCELADO("Cancelado");

    private final String descricao;

    StatusGeral(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
