package br.com.wbcars.enuns;

public enum TipoOrcamento {
    MECANICA("Mecânica"),
    TROCA_OLEO("Troca de Óleo"),
    FREIO("Freio"),
    PINTURA("Pintura"),
    FUNILARIA("Funilaria"),
    SUSPENSAO("Suspensão"),
    ELETRICA("Elétrica"),
    OUTROS("Outros");

    private final String descricao;

    TipoOrcamento(String descricao) {
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
