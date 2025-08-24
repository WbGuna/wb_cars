package br.com.wbcars.enuns;

public enum TipoContaPagar {
    AGUA("Água"),
    LUZ("Luz"),
    TELEFONE("Telefone"),
    INTERNET("Internet"),
    ALUGUEL("Aluguel"),
    FORNECEDOR("Fornecedor"),
    IMPOSTOS("Impostos"),
    PAGAMENTO_FUNCIONARIO("Pagamento Funcionário"),
    OUTROS("Outros");

    private final String descricao;

    TipoContaPagar(String descricao) {
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
