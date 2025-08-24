
package br.com.wbcars.dto;

import java.io.Serializable;

public class ProdutoDTO implements Serializable {

	private static final long serialVersionUID = 6323987066812599152L;
	private Long id;
    private String nome;
    private FornecedorDTO fornecedor;
    private UnidadeMedidaDTO unidadeMedida;
    private java.time.LocalDateTime dataCadastro;
    private java.time.LocalDateTime dataAlteracao;
    public java.time.LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(java.time.LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }
    public java.time.LocalDateTime getDataAlteracao() { return dataAlteracao; }
    public void setDataAlteracao(java.time.LocalDateTime dataAlteracao) { this.dataAlteracao = dataAlteracao; }

    public ProdutoDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public FornecedorDTO getFornecedor() { return fornecedor; }
    public void setFornecedor(FornecedorDTO fornecedor) { this.fornecedor = fornecedor; }
    public UnidadeMedidaDTO getUnidadeMedida() { return unidadeMedida; }
    public void setUnidadeMedida(UnidadeMedidaDTO unidadeMedida) { this.unidadeMedida = unidadeMedida; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoDTO produto = (ProdutoDTO) o;
        return id != null && id.equals(produto.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
    return "ProdutoDTO{" +
        "id=" + id +
        ", nome='" + nome + '\'' +
        ", fornecedor=" + (fornecedor != null ? fornecedor.getNome() : null) +
        ", unidadeMedida=" + (unidadeMedida != null ? unidadeMedida.getTipo() : null) +
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        '}';
    }
}
