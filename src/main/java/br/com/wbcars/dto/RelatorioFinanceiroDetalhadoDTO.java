package br.com.wbcars.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class RelatorioFinanceiroDetalhadoDTO implements Serializable {

	private static final long serialVersionUID = -3073090949282464081L;
	
	private Long id;
	
    private List<OrdemServicoDTO> ordensServico;
    
    private List<ContaPagarDTO> contasPagar;
    
    private Double valorTotalEntrada;
    
    private LocalDateTime dataCadastro;
    
    private LocalDateTime dataAlteracao;

    public RelatorioFinanceiroDetalhadoDTO() {}

    public Long getId() { 
    	return id; 
    }
    
    public void setId(Long id) { 
    	this.id = id; 
    }
    
    public List<OrdemServicoDTO> getOrdensServico() { 
    	return ordensServico; 
    }
    
    public void setOrdensServico(List<OrdemServicoDTO> ordensServico) { 
    	this.ordensServico = ordensServico; 
    }
    
    public List<ContaPagarDTO> getContasPagar() { 
    	return contasPagar; 
    }
    
    public void setContasPagar(List<ContaPagarDTO> contasPagar) { 
    	this.contasPagar = contasPagar; 
    }
    
    public Double getValorTotalEntrada() { 
    	return valorTotalEntrada; 
    }
    
    public void setValorTotalEntrada(Double valorTotalEntrada) { 
    	this.valorTotalEntrada = valorTotalEntrada; 
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
		RelatorioFinanceiroDetalhadoDTO other = (RelatorioFinanceiroDetalhadoDTO) obj;
		return Objects.equals(id, other.id);
	}

    @Override
    public String toString() {
        return "RelatorioFinanceiroDetalhadoDTO{" +
                "id=" + id +
                ", ordensServico=" + (ordensServico != null ? ordensServico.size() : 0) +
                ", contasPagar=" + (contasPagar != null ? contasPagar.size() : 0) +
                ", valorTotalEntrada=" + valorTotalEntrada +
                ", dataCadastro=" + dataCadastro +
                ", dataAlteracao=" + dataAlteracao +
                '}';
    }
}
