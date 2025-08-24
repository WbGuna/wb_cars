package br.com.wbcars.enuns;

public enum TipoUnidadeMedida {
    UNIDADE("Unidade"),
    LITRO("Litro"),
    QUILOGRAMA("Quilograma"),
    KILO("Kilo"),
    METRO("Metro"),
    CAIXA("Caixa"),
    PACOTE("Pacote"),
    PAR("Par"),
    OUTROS("Outros");

    private final String descricao;

    TipoUnidadeMedida(String descricao) {
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
