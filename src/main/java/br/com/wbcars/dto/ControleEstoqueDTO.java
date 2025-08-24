package br.com.wbcars.dto;

import java.io.Serializable;

public class ControleEstoqueDTO implements Serializable {

	private static final long serialVersionUID = 6485160437313514221L;
	private Long id;
    private ProdutoDTO produto;
    private Integer quantidade;
    private Double valor;
    private java.time.LocalDateTime dataCadastro;
    private java.time.LocalDateTime dataAlteracao;
    private FornecedorDTO fornecedor;

    public ControleEstoqueDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public ProdutoDTO getProduto() { return produto; }
    public void setProduto(ProdutoDTO produto) { this.produto = produto; }
    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }
    public java.time.LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(java.time.LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }
    public java.time.LocalDateTime getDataAlteracao() { return dataAlteracao; }
    public void setDataAlteracao(java.time.LocalDateTime dataAlteracao) { this.dataAlteracao = dataAlteracao; }
    public FornecedorDTO getFornecedor() { return fornecedor; }
    public void setFornecedor(FornecedorDTO fornecedor) { this.fornecedor = fornecedor; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ControleEstoqueDTO that = (ControleEstoqueDTO) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
    return "ControleEstoqueDTO{" +
        "id=" + id +
        ", produto=" + (produto != null ? produto.getNome() : null) +
        ", quantidade=" + quantidade +
        ", valor=" + valor +
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        ", fornecedor=" + (fornecedor != null ? fornecedor.getNome() : null) +
        '}';
    }
}
