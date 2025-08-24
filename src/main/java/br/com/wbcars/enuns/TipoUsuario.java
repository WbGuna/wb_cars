package br.com.wbcars.enuns;

public enum TipoUsuario {
    ADMINISTRADOR("Administrador"),
    FUNCIONARIO("Funcionário");

    private final String descricao;

    TipoUsuario(String descricao) {
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
