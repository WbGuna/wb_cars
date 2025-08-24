package br.com.wbcars.dto;

import java.io.Serializable;

public class RelatorioFinanceiroDTO implements Serializable {

	private static final long serialVersionUID = -2958018120295574046L;
	private Long id;
    private Double totalVendas;
    private Double totalOrcamentos;
    private Double totalGastos;
    private java.time.LocalDateTime dataCadastro;
    private java.time.LocalDateTime dataAlteracao;

    public RelatorioFinanceiroDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Double getTotalVendas() { return totalVendas; }
    public void setTotalVendas(Double totalVendas) { this.totalVendas = totalVendas; }
    public Double getTotalOrcamentos() { return totalOrcamentos; }
    public void setTotalOrcamentos(Double totalOrcamentos) { this.totalOrcamentos = totalOrcamentos; }
    public Double getTotalGastos() { return totalGastos; }
    public void setTotalGastos(Double totalGastos) { this.totalGastos = totalGastos; }
    public java.time.LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(java.time.LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }
    public java.time.LocalDateTime getDataAlteracao() { return dataAlteracao; }
    public void setDataAlteracao(java.time.LocalDateTime dataAlteracao) { this.dataAlteracao = dataAlteracao; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelatorioFinanceiroDTO that = (RelatorioFinanceiroDTO) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "RelatorioFinanceiroDTO{" +
                "id=" + id +
                ", totalVendas=" + totalVendas +
                ", totalOrcamentos=" + totalOrcamentos +
                ", totalGastos=" + totalGastos +
                ", dataCadastro=" + dataCadastro +
                ", dataAlteracao=" + dataAlteracao +
                '}';
    }
}
