
package br.com.wbcars.dto;

import java.io.Serializable;
import java.util.List;

public class OrdemServicoDTO implements Serializable {

	private static final long serialVersionUID = -9173594545345680738L;
	private Long id;
    private FuncionarioDTO atendente;
    private ClienteDTO cliente;
    private String descricao;
    private Double valor;
    private List<ControleEstoqueDTO> pecas;
    private java.time.LocalDateTime dataCadastro;
    private java.time.LocalDateTime dataAlteracao;
    public java.time.LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(java.time.LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }
    public java.time.LocalDateTime getDataAlteracao() { return dataAlteracao; }
    public void setDataAlteracao(java.time.LocalDateTime dataAlteracao) { this.dataAlteracao = dataAlteracao; }

    public OrdemServicoDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public FuncionarioDTO getAtendente() { return atendente; }
    public void setAtendente(FuncionarioDTO atendente) { this.atendente = atendente; }
    public ClienteDTO getCliente() { return cliente; }
    public void setCliente(ClienteDTO cliente) { this.cliente = cliente; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }
    public List<ControleEstoqueDTO> getPecas() { return pecas; }
    public void setPecas(List<ControleEstoqueDTO> pecas) { this.pecas = pecas; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdemServicoDTO that = (OrdemServicoDTO) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
    return "OrdemServicoDTO{" +
        "id=" + id +
        ", atendente=" + (atendente != null ? atendente.getNome() : null) +
        ", cliente=" + (cliente != null ? cliente.getNome() : null) +
        ", descricao='" + descricao + '\'' +
        ", valor=" + valor +
        ", pecas=" + (pecas != null ? pecas.size() : 0) +
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        '}';
    }
}
