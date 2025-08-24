package br.com.wbcars.enuns;

public enum SetorFuncionario {
    ADMINISTRATIVO("Administrativo"),
    MECANICA("Mecânica"),
    ESTOQUE("Estoque"),
    FINANCEIRO("Financeiro"),
    ATENDIMENTO("Atendimento"),
    VENDAS("Vendas"),
    OUTROS("Outros");

    private final String descricao;

    SetorFuncionario(String descricao) {
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
