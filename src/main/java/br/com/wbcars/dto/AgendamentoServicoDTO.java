package br.com.wbcars.dto;

import java.io.Serializable;

public class AgendamentoServicoDTO implements Serializable {

	private static final long serialVersionUID = -4778019748569501536L;
	private Long id;
    private ClienteDTO cliente;
    private java.time.LocalDateTime diaAgendamento;
    private java.time.LocalDateTime dataCadastro;
    private java.time.LocalDateTime dataAlteracao;

    public AgendamentoServicoDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public ClienteDTO getCliente() { return cliente; }
    public void setCliente(ClienteDTO cliente) { this.cliente = cliente; }
    public java.time.LocalDateTime getDiaAgendamento() { return diaAgendamento; }
    public void setDiaAgendamento(java.time.LocalDateTime diaAgendamento) { this.diaAgendamento = diaAgendamento; }
    public java.time.LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(java.time.LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }
    public java.time.LocalDateTime getDataAlteracao() { return dataAlteracao; }
    public void setDataAlteracao(java.time.LocalDateTime dataAlteracao) { this.dataAlteracao = dataAlteracao; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgendamentoServicoDTO that = (AgendamentoServicoDTO) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
    return "AgendamentoServicoDTO{" +
        "id=" + id +
        ", cliente=" + (cliente != null ? cliente.getNome() : null) +
        ", diaAgendamento=" + diaAgendamento +
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        '}';
    }
}
