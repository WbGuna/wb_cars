package br.com.wbcars.dto;

import java.io.Serializable;
import java.util.List;

public class RelatorioFinanceiroDetalhadoDTO implements Serializable {

	private static final long serialVersionUID = -3073090949282464081L;
	private Long id;
    private List<OrdemServicoDTO> ordensServico;
    private List<ContaPagarDTO> contasPagar;
    private Double valorTotalEntrada;
    private java.time.LocalDateTime dataCadastro;
    private java.time.LocalDateTime dataAlteracao;

    public RelatorioFinanceiroDetalhadoDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public List<OrdemServicoDTO> getOrdensServico() { return ordensServico; }
    public void setOrdensServico(List<OrdemServicoDTO> ordensServico) { this.ordensServico = ordensServico; }
    public List<ContaPagarDTO> getContasPagar() { return contasPagar; }
    public void setContasPagar(List<ContaPagarDTO> contasPagar) { this.contasPagar = contasPagar; }
    public Double getValorTotalEntrada() { return valorTotalEntrada; }
    public void setValorTotalEntrada(Double valorTotalEntrada) { this.valorTotalEntrada = valorTotalEntrada; }
    public java.time.LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(java.time.LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }
    public java.time.LocalDateTime getDataAlteracao() { return dataAlteracao; }
    public void setDataAlteracao(java.time.LocalDateTime dataAlteracao) { this.dataAlteracao = dataAlteracao; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelatorioFinanceiroDetalhadoDTO that = (RelatorioFinanceiroDetalhadoDTO) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "RelatorioFinanceiroDetalhadoDTO{" +
                "id=" + id +
                ", ordensServico=" + (ordensServico != null ? ordensServico.size() : 0) +
                ", contasPagar=" + (contasPagar != null ? contasPagar.size() : 0) +
                ", valorTotalEntrada=" + valorTotalEntrada +
                ", dataCadastro=" + dataCadastro +
                ", dataAlteracao=" + dataAlteracao +
                '}';
    }
}
