package br.com.wbcars.enuns;

public enum TipoFornecimento {
    PECA("Peça"),
    PRODUTO("Produto"),
    SERVICO("Serviço"),
    OUTROS("Outros");

    private final String descricao;

    TipoFornecimento(String descricao) {
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
