package br.com.wbcars.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class VendaDTO implements Serializable {

	private static final long serialVersionUID = 642788681317206263L;
	
	private Long id;
	
    private OrcamentoDTO orcamento;
    
    private LocalDateTime dataCadastro;
    
    private LocalDateTime dataAlteracao;

    public VendaDTO() {}

    public Long getId() { 
    	return id; 
    }
    
    public void setId(Long id) { 
    	this.id = id; 
    }
    
    public OrcamentoDTO getOrcamento() { 
    	return orcamento; 
    }
    
    public void setOrcamento(OrcamentoDTO orcamento) { 
    	this.orcamento = orcamento; 
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
		VendaDTO other = (VendaDTO) obj;
		return Objects.equals(id, other.id);
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
