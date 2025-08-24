package br.com.wbcars.entity;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;
import java.io.Serializable;

@Entity
@Table(name = "relatorio_financeiro")
@SequenceGenerator(name = "relatorio_financeiro_seq", sequenceName = "relatorio_financeiro_seq", initialValue = 1, allocationSize = 1)
@Audited
public class RelatorioFinanceiro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "relatorio_financeiro_seq")
    private Long id;

    private Double totalVendas;
    private Double totalOrcamentos;
    private Double totalGastos;
    private java.time.LocalDateTime dataCadastro;
    private java.time.LocalDateTime dataAlteracao;
    public java.time.LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(java.time.LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }
    public java.time.LocalDateTime getDataAlteracao() { return dataAlteracao; }
    public void setDataAlteracao(java.time.LocalDateTime dataAlteracao) { this.dataAlteracao = dataAlteracao; }

    public RelatorioFinanceiro() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Double getTotalVendas() { return totalVendas; }
    public void setTotalVendas(Double totalVendas) { this.totalVendas = totalVendas; }
    public Double getTotalOrcamentos() { return totalOrcamentos; }
    public void setTotalOrcamentos(Double totalOrcamentos) { this.totalOrcamentos = totalOrcamentos; }
    public Double getTotalGastos() { return totalGastos; }
    public void setTotalGastos(Double totalGastos) { this.totalGastos = totalGastos; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelatorioFinanceiro that = (RelatorioFinanceiro) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
    return "RelatorioFinanceiro{" +
        "id=" + id +
        ", totalVendas=" + totalVendas +
        ", totalOrcamentos=" + totalOrcamentos +
        ", totalGastos=" + totalGastos +
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        '}';
    }
}
