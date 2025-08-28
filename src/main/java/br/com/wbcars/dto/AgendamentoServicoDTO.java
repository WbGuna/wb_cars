package br.com.wbcars.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class AgendamentoServicoDTO implements Serializable {

	private static final long serialVersionUID = -4778019748569501536L;
	
	private Long id;
	
    private ClienteDTO cliente;
    
    private LocalDateTime diaAgendamento;
    
    private LocalDateTime dataCadastro;
    
    private LocalDateTime dataAlteracao;

    public AgendamentoServicoDTO() {}

    public Long getId() { 
    	return id; 
    }
    
    public void setId(Long id) { 
    	this.id = id; 
    }
    
    public ClienteDTO getCliente() { 
    	return cliente; 
    }
    
    public void setCliente(ClienteDTO cliente) { 
    	this.cliente = cliente; 
    }
    
    public LocalDateTime getDiaAgendamento() { 
    	return diaAgendamento; 
    }
    
    public void setDiaAgendamento(LocalDateTime diaAgendamento) { 
    	this.diaAgendamento = diaAgendamento; 
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
		AgendamentoServicoDTO other = (AgendamentoServicoDTO) obj;
		return Objects.equals(id, other.id);
	}

    @Override
    public String toString() {
    return "AgendamentoServicoDTO{" +
        "id=" + id +
        ", cliente=" + (cliente != null ? cliente.getNome() : null) +
        ", diaAgendamento=" + diaAgendamento +
        ", dataCadastro=" + dataCadastro +
        ", dataAlteracao=" + dataAlteracao +
        '}';
    }
}
