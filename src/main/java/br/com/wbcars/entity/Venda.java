package br.com.wbcars.entity;

import java.io.Serializable;

import org.hibernate.envers.Audited;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "venda")
@SequenceGenerator(name = "venda_seq", sequenceName = "venda_seq", initialValue = 1, allocationSize = 1)
@Audited
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_seq")
    private Long id;

    @OneToOne
    @JoinColumn(name = "orcamento_id")
    private Orcamento orcamento;
    private java.time.LocalDateTime dataCadastro;
    private java.time.LocalDateTime dataAlteracao;
    public java.time.LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(java.time.LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }
    public java.time.LocalDateTime getDataAlteracao() { return dataAlteracao; }
    public void setDataAlteracao(java.time.LocalDateTime dataAlteracao) { this.dataAlteracao = dataAlteracao; }

    public Venda() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Orcamento getOrcamento() { return orcamento; }
    public void setOrcamento(Orcamento orcamento) { this.orcamento = orcamento; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venda venda = (Venda) o;
        return id != null && id.equals(venda.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
    return "Venda{" +
        "id=" + id +
        ", orcamento=" + (orcamento != null ? orcamento.getId() : null) +
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        '}';
    }
}
