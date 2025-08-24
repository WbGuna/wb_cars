package br.com.wbcars.dto;

import br.com.wbcars.enuns.TipoContaPagar;
import br.com.wbcars.enuns.StatusGeral;
import java.io.Serializable;

public class ContaPagarDTO implements Serializable {

	private static final long serialVersionUID = -4929550242563769742L;
	private Long id;
    private TipoContaPagar tipo;
    private java.time.LocalDateTime prazo;
    private java.time.LocalDateTime dataCadastro;
    private java.time.LocalDateTime dataAlteracao;
    private Double valor;
    private StatusGeral status;

    public ContaPagarDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public TipoContaPagar getTipo() { return tipo; }
    public void setTipo(TipoContaPagar tipo) { this.tipo = tipo; }
    public java.time.LocalDateTime getPrazo() { return prazo; }
    public void setPrazo(java.time.LocalDateTime prazo) { this.prazo = prazo; }
    public java.time.LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(java.time.LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }
    public java.time.LocalDateTime getDataAlteracao() { return dataAlteracao; }
    public void setDataAlteracao(java.time.LocalDateTime dataAlteracao) { this.dataAlteracao = dataAlteracao; }
    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }
    public StatusGeral getStatus() { return status; }
    public void setStatus(StatusGeral status) { this.status = status; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContaPagarDTO that = (ContaPagarDTO) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
    return "ContaPagarDTO{" +
        "id=" + id +
        ", tipo=" + (tipo != null ? tipo.getDescricao() : null) +
        ", prazo=" + prazo +
        ", valor=" + valor +
        ", status=" + (status != null ? status.getDescricao() : null) +
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        '}';
    }
}
