package br.com.wbcars.dto;

import java.io.Serializable;

public class VendaDTO implements Serializable {

	private static final long serialVersionUID = 642788681317206263L;
	private Long id;
    private OrcamentoDTO orcamento;
    private java.time.LocalDateTime dataCadastro;
    private java.time.LocalDateTime dataAlteracao;

    public VendaDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public OrcamentoDTO getOrcamento() { return orcamento; }
    public void setOrcamento(OrcamentoDTO orcamento) { this.orcamento = orcamento; }
    public java.time.LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(java.time.LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }
    public java.time.LocalDateTime getDataAlteracao() { return dataAlteracao; }
    public void setDataAlteracao(java.time.LocalDateTime dataAlteracao) { this.dataAlteracao = dataAlteracao; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendaDTO venda = (VendaDTO) o;
        return id != null && id.equals(venda.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "VendaDTO{" +
                "id=" + id +
                ", orcamento=" + (orcamento != null ? orcamento.getId() : null) +
                ", dataCadastro=" + dataCadastro +
                ", dataAlteracao=" + dataAlteracao +
                '}';
    }
}
