package br.com.wbcars.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.envers.Audited;

import br.com.wbcars.enuns.StatusGeral;
import br.com.wbcars.enuns.TipoContaPagar;
import jakarta.persistence.*;

@Entity
@Table(name = "conta_pagar")
@SequenceGenerator(name = "conta_pagar_seq", sequenceName = "conta_pagar_seq", initialValue = 1, allocationSize = 1)
@Audited
public class ContaPagar implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conta_pagar_seq")
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoContaPagar tipo;
    
    private LocalDateTime prazo;
    
    private LocalDateTime dataCadastro;
    
    private LocalDateTime dataAlteracao;
    
    private Double valor;
    
    @Enumerated(EnumType.STRING)
    private StatusGeral status;

    public ContaPagar() {}

    public Long getId() { 
        return id; 
    }
    
    public void setId(Long id) { 
        this.id = id; 
    }
    
    public TipoContaPagar getTipo() { 
        return tipo; 
    }
    
    public void setTipo(TipoContaPagar tipo) { 
        this.tipo = tipo; 
    }
    
    public LocalDateTime getPrazo() { 
        return prazo; 
    }
    
    public void setPrazo(LocalDateTime prazo) { 
        this.prazo = prazo; 
    }
    
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
    
    public Double getValor() { 
        return valor; 
    }
    
    public void setValor(Double valor) { 
        this.valor = valor; 
    }
    
    public StatusGeral getStatus() { 
        return status; 
    }
    
    public void setStatus(StatusGeral status) { 
        this.status = status; 
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
		ContaPagar other = (ContaPagar) obj;
		return Objects.equals(id, other.id);
	}

    @Override
    public String toString() {
    return "ContaPagar{" +
        "id=" + id +
        ", tipo=" + (tipo != null ? tipo.getDescricao() : null) +
        ", prazo=" + prazo +
        ", valor=" + valor +
        ", status=" + (status != null ? status.getDescricao() : null) +
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        '}';
    }
}
