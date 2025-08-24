package br.com.wbcars.entity;

import br.com.wbcars.enuns.TipoContaPagar;
import br.com.wbcars.enuns.StatusGeral;
import jakarta.persistence.*;
import org.hibernate.envers.Audited;
import java.io.Serializable;

@Entity
@Table(name = "conta_pagar")
@SequenceGenerator(name = "conta_pagar_seq", sequenceName = "conta_pagar_seq", initialValue = 1, allocationSize = 1)
@Audited
public class ContaPagar implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conta_pagar_seq")
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoContaPagar tipo;
    private java.time.LocalDateTime prazo;
    private java.time.LocalDateTime dataCadastro;
    private java.time.LocalDateTime dataAlteracao;
    private Double valor;
    @Enumerated(EnumType.STRING)
    private StatusGeral status;

    public ContaPagar() {}

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
        ContaPagar that = (ContaPagar) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
    return "ContaPagar{" +
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
