package br.com.wbcars.entity;

import java.io.Serializable;
import java.util.List;

import org.hibernate.envers.Audited;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "relatorio_financeiro_detalhado")
@SequenceGenerator(name = "relatorio_financeiro_detalhado_seq", sequenceName = "relatorio_financeiro_detalhado_seq", initialValue = 1, allocationSize = 1)
@Audited
public class RelatorioFinanceiroDetalhado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "relatorio_financeiro_detalhado_seq")
    private Long id;

    @OneToMany
    @JoinColumn(name = "relatorio_financeiro_detalhado_id")
    private List<OrdemServico> ordensServico;

    @OneToMany
    @JoinColumn(name = "relatorio_financeiro_detalhado_id")
    private List<ContaPagar> contasPagar;

    private Double valorTotalEntrada;
    private java.time.LocalDateTime dataCadastro;
    private java.time.LocalDateTime dataAlteracao;
    public java.time.LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(java.time.LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }
    public java.time.LocalDateTime getDataAlteracao() { return dataAlteracao; }
    public void setDataAlteracao(java.time.LocalDateTime dataAlteracao) { this.dataAlteracao = dataAlteracao; }

    public RelatorioFinanceiroDetalhado() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public List<OrdemServico> getOrdensServico() { return ordensServico; }
    public void setOrdensServico(List<OrdemServico> ordensServico) { this.ordensServico = ordensServico; }
    public List<ContaPagar> getContasPagar() { return contasPagar; }
    public void setContasPagar(List<ContaPagar> contasPagar) { this.contasPagar = contasPagar; }
    public Double getValorTotalEntrada() { return valorTotalEntrada; }
    public void setValorTotalEntrada(Double valorTotalEntrada) { this.valorTotalEntrada = valorTotalEntrada; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelatorioFinanceiroDetalhado that = (RelatorioFinanceiroDetalhado) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
    return "RelatorioFinanceiroDetalhado{" +
        "id=" + id +
        ", ordensServico=" + (ordensServico != null ? ordensServico.size() : 0) +
        ", contasPagar=" + (contasPagar != null ? contasPagar.size() : 0) +
        ", valorTotalEntrada=" + valorTotalEntrada +
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        '}';
    }
}
