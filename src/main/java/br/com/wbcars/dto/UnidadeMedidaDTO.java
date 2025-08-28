
package br.com.wbcars.dto;

import br.com.wbcars.enuns.TipoUnidadeMedida;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class UnidadeMedidaDTO implements Serializable {

	private static final long serialVersionUID = 1363433271904234889L;
	
	private Long id;
	
    private TipoUnidadeMedida tipo;
    
    private LocalDateTime dataCadastro;
    
    private LocalDateTime dataAlteracao;

    public UnidadeMedidaDTO() {}

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
		UnidadeMedidaDTO other = (UnidadeMedidaDTO) obj;
		return Objects.equals(id, other.id);
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
