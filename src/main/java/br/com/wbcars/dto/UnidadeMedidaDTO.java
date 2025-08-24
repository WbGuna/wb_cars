
package br.com.wbcars.dto;

import br.com.wbcars.enuns.TipoUnidadeMedida;
import java.io.Serializable;

public class UnidadeMedidaDTO implements Serializable {

	private static final long serialVersionUID = 1363433271904234889L;
	private Long id;
    private TipoUnidadeMedida tipo;
    private java.time.LocalDateTime dataCadastro;
    private java.time.LocalDateTime dataAlteracao;
    public java.time.LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(java.time.LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }
    public java.time.LocalDateTime getDataAlteracao() { return dataAlteracao; }
    public void setDataAlteracao(java.time.LocalDateTime dataAlteracao) { this.dataAlteracao = dataAlteracao; }

    public UnidadeMedidaDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public TipoUnidadeMedida getTipo() { return tipo; }
    public void setTipo(TipoUnidadeMedida tipo) { this.tipo = tipo; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnidadeMedidaDTO that = (UnidadeMedidaDTO) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
    return "UnidadeMedidaDTO{" +
        "id=" + id +
        ", tipo=" + (tipo != null ? tipo.getDescricao() : null) +
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        '}';
    }
}
