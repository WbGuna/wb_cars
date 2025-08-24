package br.com.wbcars.entity;

import java.io.Serializable;

import org.hibernate.envers.Audited;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "agendamento_servico")
@SequenceGenerator(name = "agendamento_servico_seq", sequenceName = "agendamento_servico_seq", initialValue = 1, allocationSize = 1)
@Audited
public class AgendamentoServico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agendamento_servico_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private java.time.LocalDateTime diaAgendamento;
    private java.time.LocalDateTime dataCadastro;
    private java.time.LocalDateTime dataAlteracao;

    public AgendamentoServico() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
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
        AgendamentoServico that = (AgendamentoServico) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
    return "AgendamentoServico{" +
        "id=" + id +
        ", cliente=" + (cliente != null ? cliente.getNome() : null) +
        ", diaAgendamento=" + diaAgendamento +
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        '}';
    }
}
