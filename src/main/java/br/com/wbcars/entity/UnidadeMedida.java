package br.com.wbcars.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.envers.Audited;

import br.com.wbcars.enuns.TipoUnidadeMedida;
import jakarta.persistence.*;

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
    
    private LocalDateTime dataCadastro;
    
    private LocalDateTime dataAlteracao;
    
    public LocalDateTime getDataCadastro() { 
        return dataCadastro; 
    }
    
    public void setDataCadastro(LocalDateTime dataCadastro) { 
        this.dataCadastro = dataCadastro; 
    }
    
    public LocalDateTime getDataAlteracao() { 
        return dataAlteracao; 
    }
    
    public void setDataAlteracao(LocalDateTime dataAlteracao) { 
        this.dataAlteracao = dataAlteracao; 
    }

    public UnidadeMedida() {}

    public Long getId() { 
        return id; 
    }
    
    public void setId(Long id) { 
        this.id = id; 
    }
    
    public TipoUnidadeMedida getTipo() { 
        return tipo; 
    }
    
    public void setTipo(TipoUnidadeMedida tipo) { 
        this.tipo = tipo; 
    }

    @Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnidadeMedida other = (UnidadeMedida) obj;
		return Objects.equals(id, other.id);
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
