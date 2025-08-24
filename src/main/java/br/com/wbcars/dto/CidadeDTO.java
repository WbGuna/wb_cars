
package br.com.wbcars.dto;

import br.com.wbcars.enuns.EstadoBrasil;
import java.io.Serializable;

public class CidadeDTO implements Serializable {

	private static final long serialVersionUID = -5472585569386278692L;
	private Long id;
    private String nome;
    private EstadoBrasil estado;
    private String pais;
    private java.time.LocalDateTime dataCadastro;
    private java.time.LocalDateTime dataAlteracao;
    public java.time.LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(java.time.LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }
    public java.time.LocalDateTime getDataAlteracao() { return dataAlteracao; }
    public void setDataAlteracao(java.time.LocalDateTime dataAlteracao) { this.dataAlteracao = dataAlteracao; }

    public CidadeDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public EstadoBrasil getEstado() { return estado; }
    public void setEstado(EstadoBrasil estado) { this.estado = estado; }
    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CidadeDTO cidade = (CidadeDTO) o;
        return id != null && id.equals(cidade.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
    return "CidadeDTO{" +
        "id=" + id +
        ", nome='" + nome + '\'' +
        ", estado=" + (estado != null ? estado.getNome() : null) +
        ", pais='" + pais + '\'' +
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        '}';
    }
}
