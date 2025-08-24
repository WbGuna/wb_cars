package br.com.wbcars.dto;

import br.com.wbcars.enuns.TipoOrcamento;
import br.com.wbcars.enuns.StatusOrcamento;
import java.io.Serializable;

public class OrcamentoDTO implements Serializable {

	private static final long serialVersionUID = 5845989520742398040L;
	private Long id;
    private TipoOrcamento tipo;
    private ProdutoDTO produto;
    private FuncionarioDTO funcionario;
    private ClienteDTO cliente;
    private Double valorTotal;
    private java.time.LocalDateTime dataInicial;
    private java.time.LocalDateTime dataEntrega;
    private java.time.LocalDateTime dataCadastro;
    private java.time.LocalDateTime dataAlteracao;
    private StatusOrcamento status;

    public OrcamentoDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public TipoOrcamento getTipo() { return tipo; }
    public void setTipo(TipoOrcamento tipo) { this.tipo = tipo; }
    public ProdutoDTO getProduto() { return produto; }
    public void setProduto(ProdutoDTO produto) { this.produto = produto; }
    public FuncionarioDTO getFuncionario() { return funcionario; }
    public void setFuncionario(FuncionarioDTO funcionario) { this.funcionario = funcionario; }
    public ClienteDTO getCliente() { return cliente; }
    public void setCliente(ClienteDTO cliente) { this.cliente = cliente; }
    public Double getValorTotal() { return valorTotal; }
    public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }
    public java.time.LocalDateTime getDataInicial() { return dataInicial; }
    public void setDataInicial(java.time.LocalDateTime dataInicial) { this.dataInicial = dataInicial; }
    public java.time.LocalDateTime getDataEntrega() { return dataEntrega; }
    public void setDataEntrega(java.time.LocalDateTime dataEntrega) { this.dataEntrega = dataEntrega; }
    public java.time.LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(java.time.LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }
    public java.time.LocalDateTime getDataAlteracao() { return dataAlteracao; }
    public void setDataAlteracao(java.time.LocalDateTime dataAlteracao) { this.dataAlteracao = dataAlteracao; }
    public StatusOrcamento getStatus() { return status; }
    public void setStatus(StatusOrcamento status) { this.status = status; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrcamentoDTO that = (OrcamentoDTO) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
    return "OrcamentoDTO{" +
        "id=" + id +
        ", tipo=" + (tipo != null ? tipo.getDescricao() : null) +
        ", produto=" + (produto != null ? produto.getNome() : null) +
        ", funcionario=" + (funcionario != null ? funcionario.getNome() : null) +
        ", cliente=" + (cliente != null ? cliente.getNome() : null) +
        ", valorTotal=" + valorTotal +
        ", dataInicial=" + dataInicial +
        ", dataEntrega=" + dataEntrega +
        ", status=" + (status != null ? status.getDescricao() : null) +
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        '}';
    }
}
