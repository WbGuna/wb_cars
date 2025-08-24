package br.com.wbcars.enuns;

public enum StatusOrcamento {
    ABERTO("Aberto"),
    APROVADO("Aprovado"),
    REPROVADO("Reprovado"),
    CANCELADO("Cancelado"),
    FINALIZADO("Finalizado");

    private final String descricao;

    StatusOrcamento(String descricao) {
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
