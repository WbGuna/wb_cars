package br.com.wbcars.entity;

import br.com.wbcars.enuns.TipoUnidadeMedida;
import jakarta.persistence.*;
import org.hibernate.envers.Audited;
import java.io.Serializable;

@Entity
@Table(name = "unidade_medida")
@SequenceGenerator(name = "unidade_medida_seq", sequenceName = "unidade_medida_seq", initialValue = 1, allocationSize = 1)
@Audited
public class UnidadeMedida implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unidade_medida_seq")
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoUnidadeMedida tipo;
    private java.time.LocalDateTime dataCadastro;
    private java.time.LocalDateTime dataAlteracao;
    public java.time.LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(java.time.LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }
    public java.time.LocalDateTime getDataAlteracao() { return dataAlteracao; }
    public void setDataAlteracao(java.time.LocalDateTime dataAlteracao) { this.dataAlteracao = dataAlteracao; }

    public UnidadeMedida() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public TipoUnidadeMedida getTipo() { return tipo; }
    public void setTipo(TipoUnidadeMedida tipo) { this.tipo = tipo; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnidadeMedida that = (UnidadeMedida) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
    return "UnidadeMedida{" +
        "id=" + id +
        ", tipo=" + (tipo != null ? tipo.getDescricao() : null) +
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        '}';
    }
}
