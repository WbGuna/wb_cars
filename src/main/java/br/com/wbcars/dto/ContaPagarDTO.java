package br.com.wbcars.dto;

import br.com.wbcars.enuns.TipoContaPagar;
import br.com.wbcars.enuns.StatusGeral;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class ContaPagarDTO implements Serializable {

	private static final long serialVersionUID = -4929550242563769742L;
	
	private Long id;
	
    private TipoContaPagar tipo;
    
    private LocalDateTime prazo;
    
    private LocalDateTime dataCadastro;
    
    private LocalDateTime dataAlteracao;
    
    private Double valor;
    
    private StatusGeral status;

    public ContaPagarDTO() {}

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
		ContaPagarDTO other = (ContaPagarDTO) obj;
		return Objects.equals(id, other.id);
	}

    @Override
    public String toString() {
    return "ContaPagarDTO{" +
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
